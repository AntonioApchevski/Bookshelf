package mk.iwec.bookshelf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import mk.iwec.bookshelf.model.Translator;
import mk.iwec.bookshelf.repository.TranslatorRepository;
import mk.iwec.bookshelf.service.TranslatorService;

@Service
@Transactional
public class TranslatorServiceImpl implements TranslatorService {

	@Autowired
	private TranslatorRepository translatorRepository;

	@Override
	public Translator findById(Long id) {
		return translatorRepository.findById(id).get();
	}

	@Override
	public List<Translator> findAll() {
		return translatorRepository.findAll();
	}

	@Override
	public Translator insert(Translator translator) {
		Translator translatorExists = translatorRepository.findTranslatorByFirstNameAndMiddleNameAndLastName(
				translator.getFirstName(), translator.getMiddleName(), translator.getLastName());
		if (translatorExists != null) {
			throw new IllegalStateException("Translator already exists in database.");
		}
		return translatorRepository.save(translator);
	}

	@Override
	public void deleteById(Long id) {
		boolean translatorExists = translatorRepository.existsById(id);
		if (!translatorExists) {
			throw new IllegalStateException("Translator with the given id does not exist in database.");
		}
		translatorRepository.deleteById(id);
	}

	@Override
	public Translator update(Long id, Translator translator) {
		Translator translatorExists = translatorRepository.findById(id).orElseThrow(
				() -> new IllegalStateException("Translator with the given id does not exist in database."));

		translatorExists.setFirstName(translator.getFirstName());
		translatorExists.setMiddleName(translator.getMiddleName());
		translatorExists.setLastName(translator.getLastName());
		translatorExists.setBooks(translator.getBooks());

		return translatorExists;
	}

}
