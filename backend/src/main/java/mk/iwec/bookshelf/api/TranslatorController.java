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
	public Translator getTranslatorById(@PathVariable("id") Long id) {
		return translatorService.findById(id);
	}

	@PostMapping
	public ResponseEntity<Translator> registerNewTranslator(@RequestBody Translator translator) {
		Translator newTranslator = translatorService.insert(translator);
		return new ResponseEntity<>(newTranslator, HttpStatus.CREATED);
	}

	@PutMapping("/translator/{id}")
	public ResponseEntity<Translator> updateTranslator(@PathVariable("id") Long id,
			@RequestBody Translator translator) {
		return new ResponseEntity<>(translatorService.update(id, translator), HttpStatus.OK);
	}

	@DeleteMapping("/translator/{id}")
	public void deleteTranslator(@PathVariable("id") Long id) {
		translatorService.deleteById(id);
	}
}
