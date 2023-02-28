package mk.iwec.bookshelf.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
