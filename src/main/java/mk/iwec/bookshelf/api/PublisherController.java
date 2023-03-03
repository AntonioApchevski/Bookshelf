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
	public Publisher getPublisherById(@PathVariable("id") Integer id) {
		return publisherService.findById(id);
	}

	@PostMapping
	public void registerNewPublisher(@RequestBody Publisher publisher) {
		publisherService.insert(publisher);
	}

	@PutMapping("/publisher/{id}")
	public void updatePublisher(@PathVariable("id") Integer id, @RequestBody Publisher publisher) {
		publisherService.update(id, publisher);
	}

	@DeleteMapping("/publisher/{id}")
	public void deletePublisher(@PathVariable("id") Integer id) {
		publisherService.deleteById(id);
	}
}
