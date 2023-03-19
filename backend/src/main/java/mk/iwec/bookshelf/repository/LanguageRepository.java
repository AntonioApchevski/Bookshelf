package mk.iwec.bookshelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mk.iwec.bookshelf.model.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

	public Language findLanguageByName(String name);

}
