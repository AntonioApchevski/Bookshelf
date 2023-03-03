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

	@GetMapping("/translator/{id}")
	public Translator getTranslatorById(@PathVariable("id") Integer id) {
		return translatorService.findById(id);
	}

	@PostMapping
	public void registerNewTranslator(@RequestBody Translator translator) {
		translatorService.insert(translator);
	}

	@PutMapping("/translator/{id}")
	public void updateTranslator(@PathVariable("id") Integer id, @RequestBody Translator translator) {
		translatorService.update(id, translator);
	}

	@DeleteMapping("/translator/{id}")
	public void deleteTranslator(@PathVariable("id") Integer id) {
		translatorService.deleteById(id);
	}
}
