package mk.iwec.bookshelf.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mk.iwec.bookshelf.model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {

	public Optional<Genre> findGenreByName(String name);

}
