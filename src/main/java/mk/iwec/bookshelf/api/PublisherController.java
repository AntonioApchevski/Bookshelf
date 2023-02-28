package mk.iwec.bookshelf.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
