package mk.iwec.bookshelf.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import mk.iwec.bookshelf.model.Language;
import mk.iwec.bookshelf.repository.LanguageRepository;
import mk.iwec.bookshelf.service.LanguageService;

@Service
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageRepository languageRepository;

	@Override
	public Language findById(Integer id) {
		return languageRepository.findById(id).get();
	}

	@Override
	public List<Language> findAll() {
		return languageRepository.findAll();
	}

	@Override
	public void insert(Language language) {
		Optional<Language> languageByName = languageRepository.findByName(language.getName());
		if (languageByName.isPresent()) {
			throw new IllegalStateException("Language already exists in database.");
		}
		languageRepository.save(language);
	}

	@Override
	public void deleteById(Integer id) {
		boolean languageExists = languageRepository.existsById(id);
		if (!languageExists) {
			throw new IllegalStateException("Language with the given id does not exist in database.");
		}
		languageRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void update(Integer id, Language language) {
		Language languageExists = languageRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("Language with the given id does not exist in database."));

		languageExists.setName(language.getName());
	}

}
