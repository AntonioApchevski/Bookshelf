package mk.iwec.bookshelf.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mk.iwec.bookshelf.model.Book;
import mk.iwec.bookshelf.service.BookService;

@RestController
@RequestMapping("books")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Transactional
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping
	public ResponseEntity<List<Book>> findAll() {
		List<Book> books = bookService.findAll();
		return new ResponseEntity<>(books, HttpStatus.OK);
	}

	@GetMapping("/book/{id}")
	public Book getBookById(@PathVariable("id") Long id) {
		return bookService.findById(id);
	}

	@PostMapping
	public ResponseEntity<Book> registerNewBook(@RequestBody Book book) {
		Book newBook = bookService.insert(book);
		return new ResponseEntity<>(newBook, HttpStatus.CREATED);
	}

	@PutMapping("/book/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
		return new ResponseEntity<>(bookService.update(id, book), HttpStatus.OK);
	}

	@DeleteMapping("/book/{id}")
	public void deleteBook(@PathVariable("id") Long id) {
		bookService.deleteById(id);
	}

	@RequestMapping(method = RequestMethod.OPTIONS, path = "/book/{id}")
	public ResponseEntity<?> bookCors() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		headers.add("Access-Control-Allow-Headers",
				"Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
		return new ResponseEntity<>(headers, HttpStatus.OK);
	}
}
