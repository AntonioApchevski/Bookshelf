package mk.iwec.bookshelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mk.iwec.bookshelf.model.Translator;

@Repository
public interface TranslatorRepository extends JpaRepository<Translator, Long> {

	public Translator findTranslatorByFirstNameAndMiddleNameAndLastName(String firstName, String middleName,
			String lastName);

}
