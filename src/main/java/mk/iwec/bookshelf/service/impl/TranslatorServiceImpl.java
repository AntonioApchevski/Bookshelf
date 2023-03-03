package mk.iwec.bookshelf.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.iwec.bookshelf.model.Translator;
import mk.iwec.bookshelf.repository.TranslatorRepository;
import mk.iwec.bookshelf.service.TranslatorService;

@Service
public class TranslatorServiceImpl implements TranslatorService {

	@Autowired
	private TranslatorRepository translatorRepository;

	@Override
	public Translator findById(Integer id) {
		return translatorRepository.findById(id).get();
	}

	@Override
	public List<Translator> findAll() {
		return translatorRepository.findAll();
	}

	@Override
	public void insert(Translator translator) {
		Optional<Translator> translatorExists = translatorRepository.findTranslatorByFirstNameAndMiddleNameAndLastName(
				translator.getFirstName(), translator.getMiddleName(), translator.getLastName());
		if (translatorExists.isPresent()) {
			throw new IllegalStateException("Translator already exists in database.");
		}
		translatorRepository.save(translator);
	}

	@Override
	public void deleteById(Integer id) {
		boolean translatorExists = translatorRepository.existsById(id);
		if (!translatorExists) {
			throw new IllegalStateException("Translator with the given id does not exist in database.");
		}
		translatorRepository.deleteById(id);
	}

	@Override
	public void update(Integer id, Translator translator) {
		Translator translatorExists = translatorRepository.findById(id).orElseThrow(
				() -> new IllegalStateException("Translator with the given id does not exist in database."));

		translatorExists.setFirstName(translator.getFirstName());
		translatorExists.setMiddleName(translator.getMiddleName());
		translatorExists.setLastName(translator.getLastName());
		translatorExists.setBooks(translator.getBooks());
	}

}
