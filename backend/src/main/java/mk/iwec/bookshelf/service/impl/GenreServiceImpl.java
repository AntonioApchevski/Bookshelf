package mk.iwec.bookshelf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import mk.iwec.bookshelf.model.Genre;
import mk.iwec.bookshelf.repository.GenreRepository;
import mk.iwec.bookshelf.service.GenreService;

@Service
@Transactional
public class GenreServiceImpl implements GenreService {

	@Autowired
	private GenreRepository genreRepository;

	@Override
	public Genre findById(Long id) {
		return genreRepository.findById(id).get();
	}

	@Override
	public List<Genre> findAll() {
		return genreRepository.findAll();
	}

	@Override
	public Genre insert(Genre genre) {
		Genre genreExists = genreRepository.findGenreByName(genre.getName());
		if (genreExists != null) {
			throw new IllegalStateException("Genre already exists in database.");
		}
		return genreRepository.save(genre);
	}

	@Override
	public void deleteById(Long id) {
		boolean genreExists = genreRepository.existsById(id);
		if (!genreExists) {
			throw new IllegalStateException("Book with the given id does not exist in database.");
		}
		genreRepository.deleteById(id);
	}

	@Override
	public Genre update(Long id, Genre genre) {
		Genre genreExists = genreRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("Book with the given id does not exist in database."));

		genreExists.setName(genre.getName());
		genreExists.setBooks(genre.getBooks());

		return genreExists;
	}

}
