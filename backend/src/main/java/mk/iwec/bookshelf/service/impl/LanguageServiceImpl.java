package mk.iwec.bookshelf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import mk.iwec.bookshelf.model.Language;
import mk.iwec.bookshelf.repository.LanguageRepository;
import mk.iwec.bookshelf.service.LanguageService;

@Service
@Transactional
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageRepository languageRepository;

	@Override
	public Language findById(Long id) {
		return languageRepository.findById(id).get();
	}

	@Override
	public List<Language> findAll() {
		return languageRepository.findAll();
	}

	@Override
	public Language insert(Language language) {
		Language languageByName = languageRepository.findLanguageByName(language.getName());
		if (languageByName != null) {
			throw new IllegalStateException("Language already exists in database.");
		}
		return languageRepository.save(language);
	}

	@Override
	public void deleteById(Long id) {
		boolean languageExists = languageRepository.existsById(id);
		if (!languageExists) {
			throw new IllegalStateException("Language with the given id does not exist in database.");
		}
		languageRepository.deleteById(id);
	}

	@Override
	public Language update(Long id, Language language) {
		Language languageExists = languageRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("Language with the given id does not exist in database."));

		languageExists.setName(language.getName());

		return languageExists;
	}

}
