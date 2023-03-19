package mk.iwec.bookshelf.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public Language getLanguageById(@PathVariable("id") Long id) {
		return languageService.findById(id);
	}

	@PostMapping
	public ResponseEntity<Language> registerNewLanguage(@RequestBody Language language) {
		Language newLanguage = languageService.insert(language);
		return new ResponseEntity<>(newLanguage, HttpStatus.CREATED);
	}

	@PutMapping("/language/{id}")
	public ResponseEntity<Language> updateLanguage(@PathVariable("id") Long id, @RequestBody Language language) {
		return new ResponseEntity<>(languageService.update(id, language), HttpStatus.OK);

	}

	@DeleteMapping("/language/{id}")
	public void deleteLanguage(@PathVariable("id") Long id) {
		languageService.deleteById(id);
	}
}
