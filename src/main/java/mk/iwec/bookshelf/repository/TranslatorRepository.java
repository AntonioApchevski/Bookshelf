package mk.iwec.bookshelf.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mk.iwec.bookshelf.model.Translator;

@Repository
public interface TranslatorRepository extends JpaRepository<Translator, Integer> {

	public Optional<Translator> findTranslatorByFirstNameAndMiddleNameAndLastName(String firstName, String middleName,
			String lastName);

}
