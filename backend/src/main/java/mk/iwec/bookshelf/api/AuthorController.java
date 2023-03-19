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
	public Author getAuthorById(@PathVariable("id") Long id) {
		return authorService.findById(id);
	}

	@PostMapping
	public ResponseEntity<Author> registerNewAuthor(@RequestBody Author author) {
		Author newAuthor = authorService.insert(author);
		return new ResponseEntity<>(newAuthor, HttpStatus.CREATED);
	}

	@PutMapping("/author/{id}")
	public ResponseEntity<Author> updateAuthor(@PathVariable("id") Long id, @RequestBody Author author) {
		return new ResponseEntity<>(authorService.update(id, author), HttpStatus.OK);
	}

	@DeleteMapping("/author/{id}")
	public void deleteAuthor(@PathVariable("id") Long id) {
		authorService.deleteById(id);
	}

}
