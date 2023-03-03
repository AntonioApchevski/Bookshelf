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

	@GetMapping("/author/{id}")
	public Author getAuthorById(@PathVariable("id") Integer id) {
		return authorService.findById(id);
	}

	@PostMapping
	public void registerNewAuthor(@RequestBody Author author) {
		authorService.insert(author);
	}

	@PutMapping("/author/{id}")
	public void updateAuthor(@PathVariable("id") Integer id, @RequestBody Author author) {
		authorService.update(id, author);
	}

	@DeleteMapping("/author/{id}")
	public void deleteAuthor(@PathVariable("id") Integer id) {
		authorService.deleteById(id);
	}

}
