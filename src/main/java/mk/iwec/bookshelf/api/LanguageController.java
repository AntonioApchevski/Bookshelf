package mk.iwec.bookshelf.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.iwec.bookshelf.model.Language;
import mk.iwec.bookshelf.service.LanguageService;

@RestController
@RequestMapping("languages")
public class LanguageController {

	@Autowired
	private LanguageService languageService;

	@GetMapping
	public List<Language> findAll() {
		return languageService.findAll();
	}

	@GetMapping("/language/{id}")
	public Language getLanguageById(@PathVariable("id") Integer id) {
		return languageService.findById(id);
	}

	@PostMapping
	public void registerNewLanguage(@RequestBody Language language) {
		languageService.insert(language);
	}

	@PutMapping("/language/{id}")
	public void updateLanguage(@PathVariable("id") Integer id, @RequestBody Language language) {
		languageService.update(id, language);
	}

	@DeleteMapping("/language/{id}")
	public void deleteLanguage(@PathVariable("id") Integer id) {
		languageService.deleteById(id);
	}
}
