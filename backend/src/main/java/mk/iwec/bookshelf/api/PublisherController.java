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

import mk.iwec.bookshelf.model.Publisher;
import mk.iwec.bookshelf.service.PublisherService;

@RestController
@RequestMapping("publishers")
public class PublisherController {

	@Autowired
	private PublisherService publisherService;

	@GetMapping
	public List<Publisher> findAll() {
		return publisherService.findAll();
	}

	@GetMapping("/publisher/{id}")
	public Publisher getPublisherById(@PathVariable("id") Long id) {
		return publisherService.findById(id);
	}

	@PostMapping
	public ResponseEntity<Publisher> registerNewPublisher(@RequestBody Publisher publisher) {
		Publisher newPublisher = publisherService.insert(publisher);
		return new ResponseEntity<>(newPublisher, HttpStatus.CREATED);
	}

	@PutMapping("/publisher/{id}")
	public ResponseEntity<Publisher> updatePublisher(@PathVariable("id") Long id, @RequestBody Publisher publisher) {
		return new ResponseEntity<>(publisherService.update(id, publisher), HttpStatus.OK);

	}

	@DeleteMapping("/publisher/{id}")
	public void deletePublisher(@PathVariable("id") Long id) {
		publisherService.deleteById(id);
	}
}
