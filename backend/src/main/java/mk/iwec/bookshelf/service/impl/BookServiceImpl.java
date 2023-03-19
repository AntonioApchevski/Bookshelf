package mk.iwec.bookshelf.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import mk.iwec.bookshelf.model.Author;
import mk.iwec.bookshelf.model.Book;
import mk.iwec.bookshelf.model.FileType;
import mk.iwec.bookshelf.model.Genre;
import mk.iwec.bookshelf.model.Language;
import mk.iwec.bookshelf.model.Publisher;
import mk.iwec.bookshelf.model.Translator;
import mk.iwec.bookshelf.repository.AuthorRepository;
import mk.iwec.bookshelf.repository.BookRepository;
import mk.iwec.bookshelf.repository.FileTypeRepository;
import mk.iwec.bookshelf.repository.GenreRepository;
import mk.iwec.bookshelf.repository.LanguageRepository;
import mk.iwec.bookshelf.repository.PublisherRepository;
import mk.iwec.bookshelf.repository.TranslatorRepository;
import mk.iwec.bookshelf.service.BookService;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;
	private final LanguageRepository languageRepository;
	private final PublisherRepository publisherRepository;
	private final AuthorRepository authorRepository;
	private final TranslatorRepository translatorRepository;
	private final GenreRepository genreRepository;
	private final FileTypeRepository fileTypeRepository;

	@Autowired
	public BookServiceImpl(BookRepository bookRepository, LanguageRepository languageRepository,
			PublisherRepository publisherRepository, AuthorRepository authorRepository,
			TranslatorRepository translatorRepository, GenreRepository genreRepository,
			FileTypeRepository fileTypeRepository) {
		this.bookRepository = bookRepository;
		this.languageRepository = languageRepository;
		this.publisherRepository = publisherRepository;
		this.authorRepository = authorRepository;
		this.translatorRepository = translatorRepository;
		this.genreRepository = genreRepository;
		this.fileTypeRepository = fileTypeRepository;
	}

	@Override
	public Book findById(Long id) {
		return bookRepository.findById(id).get();
	}

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public Book insert(Book book) {
		Book bookByUniqueAttributes = bookRepository.findBookByTitleAndSubtitle(book.getTitle(), book.getSubtitle());
		if (bookByUniqueAttributes != null) {
			throw new IllegalStateException("Book already exists in database.");
		}

		Book newBook = new Book();

		setBookAttributes(book, newBook);

		// Language
		setLanguage(book, newBook);

		// Publisher
		setPublisher(book, newBook);

		// Authors
		setAuthors(book, newBook);

		// Translators
		setTranslators(book, newBook);

		// Genres
		setGenres(book, newBook);

		// File Types
		setFileTypes(book, newBook);

		return bookRepository.save(newBook);
	}

	@Override
	public void deleteById(Long id) {
		boolean bookExists = bookRepository.existsById(id);
		if (!bookExists) {
			throw new IllegalStateException("Book with the given id does not exist in database.");
		}
		bookRepository.deleteById(id);
	}

	@Override
	public Book update(Long id, Book book) {
		Book bookExists = bookRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("Book with the given id does not exist in database."));

		setBookAttributes(book, bookExists);
		
		setLanguage(book, bookExists);
		
		setPublisher(book, bookExists);
		
		setAuthors(book, bookExists);
		
		setTranslators(book, bookExists);
		
		setGenres(book, bookExists);
		
		setFileTypes(book, bookExists);

		return bookExists;
	}

	private void setBookAttributes(Book book, Book newBook) {
		newBook.setTitle(book.getTitle());
		newBook.setSubtitle(book.getSubtitle());
		newBook.setEditionNumber(book.getEditionNumber());
		newBook.setPageNumber(book.getPageNumber());
		newBook.setPublicationDate(book.getPublicationDate());
		newBook.setIsbn(book.getIsbn());
		newBook.setCoverFileName(book.getCoverFileName());
		newBook.setBookFileName(book.getBookFileName());
		newBook.setSummary(book.getSummary());
	}

	private void setLanguage(Book book, Book newBook) {
		Language existingLanguage = languageRepository.findLanguageByName(book.getLanguage().getName());
		if (existingLanguage != null) {
			newBook.setLanguage(existingLanguage);
		} else {
			Language newLanguage = new Language();
			newLanguage.setName(book.getLanguage().getName());
			newBook.setLanguage(newLanguage);
		}
	}

	private void setPublisher(Book book, Book newBook) {
		Publisher existingPublisher = publisherRepository.findPublisherByName(book.getPublisher().getName());
		if (existingPublisher != null) {
			newBook.setPublisher(existingPublisher);
		} else {
			Publisher newPublisher = new Publisher();
			newPublisher.setName(book.getPublisher().getName());
			newBook.setPublisher(newPublisher);
		}
	}

	private void setAuthors(Book book, Book newBook) {
		Set<Author> authors = new HashSet<>();
		for (Author author : book.getAuthors()) {
			Author existingAuthor = authorRepository.findAuthorByFirstNameAndMiddleNameAndLastName(
					author.getFirstName(), author.getMiddleName(), author.getLastName());
			if (existingAuthor != null) {
				authors.add(existingAuthor);
			} else {
				Author newAuthor = new Author();
				newAuthor.setFirstName(author.getFirstName());
				newAuthor.setMiddleName(author.getMiddleName());
				newAuthor.setLastName(author.getLastName());
				authors.add(newAuthor);
			}
		}

		newBook.setAuthors(authors);
	}

	private void setTranslators(Book book, Book newBook) {
		Set<Translator> translators = new HashSet<>();
		for (Translator translator : book.getTranslators()) {
			Translator existingTranslator = translatorRepository.findTranslatorByFirstNameAndMiddleNameAndLastName(
					translator.getFirstName(), translator.getMiddleName(), translator.getLastName());
			if (existingTranslator != null) {
				translators.add(existingTranslator);
			} else {
				Translator newTranslator = new Translator();
				newTranslator.setFirstName(translator.getFirstName());
				newTranslator.setMiddleName(translator.getMiddleName());
				newTranslator.setLastName(translator.getLastName());
				translators.add(newTranslator);
			}
		}

		newBook.setTranslators(translators);
	}

	private void setGenres(Book book, Book newBook) {
		Set<Genre> genres = new HashSet<>();
		for (Genre genre : book.getGenres()) {
			Genre existingGenre = genreRepository.findGenreByName(genre.getName());
			if (existingGenre != null) {
				genres.add(existingGenre);
			} else {
				Genre newGenre = new Genre();
				newGenre.setName(genre.getName());
				genres.add(newGenre);
			}
		}

		newBook.setGenres(genres);
	}

	private void setFileTypes(Book book, Book newBook) {
		Set<FileType> fileTypes = new HashSet<>();
		for (FileType fileType : book.getFileTypes()) {
			FileType existingFileType = fileTypeRepository.findFileTypeByFullName(fileType.getFullName());
			if (existingFileType != null) {
				fileTypes.add(existingFileType);
			} else {
				FileType newFileType = new FileType();
				newFileType.setFullName(fileType.getFullName());
				newFileType.setShortName(fileType.getShortName());
				fileTypes.add(newFileType);
			}
		}

		newBook.setFileTypes(fileTypes);
	}

}
