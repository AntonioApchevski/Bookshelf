package mk.iwec.bookshelf.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.iwec.bookshelf.model.Author;
import mk.iwec.bookshelf.service.AuthorService;

@RestController
@RequestMapping("authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@GetMapping
	public List<Author> findAll() {
		return authorService.findAll();
	}

}
