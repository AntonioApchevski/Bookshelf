package mk.iwec.bookshelf.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.iwec.bookshelf.model.Translator;
import mk.iwec.bookshelf.service.TranslatorService;

@RestController
@RequestMapping("translators")
public class TranslatorController {

	@Autowired
	private TranslatorService translatorService;

	@GetMapping
	public List<Translator> findAll() {
		return translatorService.findAll();
	}
}
