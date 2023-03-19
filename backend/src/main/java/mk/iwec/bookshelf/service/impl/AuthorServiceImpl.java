package mk.iwec.bookshelf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import mk.iwec.bookshelf.model.Author;
import mk.iwec.bookshelf.repository.AuthorRepository;
import mk.iwec.bookshelf.service.AuthorService;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public Author findById(Long id) {
		return authorRepository.findById(id).get();
	}

	@Override
	public List<Author> findAll() {
		return authorRepository.findAll();
	}

	@Override
	public Author insert(Author author) {
		Author authorByFullName = authorRepository.findAuthorByFirstNameAndMiddleNameAndLastName(author.getFirstName(),
				author.getMiddleName(), author.getLastName());
		if (authorByFullName != null) {
			throw new IllegalStateException("Author already exists in database.");
		}
		return authorRepository.save(author);
	}

	@Override
	public void deleteById(Long id) {
		boolean authorExists = authorRepository.existsById(id);
		if (!authorExists) {
			throw new IllegalStateException("Author with the given id does not exist in database.");
		}
		authorRepository.deleteById(id);
	}

	@Override
	public Author update(Long id, Author author) {
		Author authorExists = authorRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("Author with the given id does not exist in database."));

		authorExists.setFirstName(author.getFirstName());
		authorExists.setMiddleName(author.getMiddleName());
		authorExists.setLastName(author.getLastName());
		authorExists.setBooks(author.getBooks());

		return authorExists;
	}

}
