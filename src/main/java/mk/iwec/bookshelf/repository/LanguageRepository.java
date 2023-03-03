package mk.iwec.bookshelf.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mk.iwec.bookshelf.model.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {

	public Optional<Language> findByName(String name);

}
