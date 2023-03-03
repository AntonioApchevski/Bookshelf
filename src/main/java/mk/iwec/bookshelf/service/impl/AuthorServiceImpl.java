package mk.iwec.bookshelf.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import mk.iwec.bookshelf.model.Author;
import mk.iwec.bookshelf.repository.AuthorRepository;
import mk.iwec.bookshelf.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public Author findById(Integer id) {
		return authorRepository.findById(id).get();
	}

	@Override
	public List<Author> findAll() {
		return authorRepository.findAll();
	}

	@Override
	public void insert(Author author) {
		Optional<Author> authorByFullName = authorRepository.findAuthorByFirstNameAndMiddleNameAndLastName(
				author.getFirstName(), author.getMiddleName(), author.getLastName());
		if (authorByFullName.isPresent()) {
			throw new IllegalStateException("Author already exists in database.");
		}
		authorRepository.save(author);
	}

	@Override
	public void deleteById(Integer id) {
		boolean authorExists = authorRepository.existsById(id);
		if (!authorExists) {
			throw new IllegalStateException("Author with the given id does not exist in database.");
		}
		authorRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void update(Integer id, Author author) {
		Author authorExists = authorRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("Author with the given id does not exist in database."));

		authorExists.setFirstName(author.getFirstName());
		authorExists.setMiddleName(author.getMiddleName());
		authorExists.setLastName(author.getLastName());
	}

}
