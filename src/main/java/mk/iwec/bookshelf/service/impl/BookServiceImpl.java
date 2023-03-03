package mk.iwec.bookshelf.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import mk.iwec.bookshelf.model.Author;
import mk.iwec.bookshelf.model.Book;
import mk.iwec.bookshelf.repository.BookRepository;
import mk.iwec.bookshelf.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book findById(Integer id) {
		return bookRepository.findById(id).get();
	}

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public void insert(Book book) {
		Author author = new Author();
		Optional<Book> bookByUniqueAttributes = bookRepository.findBookByTitleAndSubtitleAndAuthorsAndEditionNumber(
				book.getTitle(), book.getSubtitle(), author.getId(), book.getEditionNumber());
		if (bookByUniqueAttributes.isPresent()) {
			throw new IllegalStateException("Book already exists in database.");
		}
		bookRepository.save(book);
	}

	@Override
	public void deleteById(Integer id) {
		boolean bookExists = bookRepository.existsById(id);
		if (!bookExists) {
			throw new IllegalStateException("Book with the given id does not exist in database.");
		}
		bookRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void update(Integer id, Book book) {
		Book bookExists = bookRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("Book with the given id does not exist in database."));

		bookExists.setTitle(book.getTitle());
		bookExists.setSubtitle(book.getSubtitle());
		bookExists.setEditionNumber(book.getEditionNumber());
		bookExists.setPageNumber(book.getPageNumber());
		bookExists.setPublicationDate(book.getPublicationDate());
		bookExists.setIsbn(book.getIsbn());
		bookExists.setCoverFileName(book.getBookFileName());
		bookExists.setBookFileName(book.getBookFileName());
		bookExists.setLanguage(book.getLanguage());
		bookExists.setPublisher(book.getPublisher());
		bookExists.setAuthors(book.getAuthors());
		bookExists.setTranslators(book.getTranslators());
		bookExists.setGenres(book.getGenres());
		bookExists.setFileTypes(book.getFileTypes());

	}

}
