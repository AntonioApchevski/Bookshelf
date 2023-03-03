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

import mk.iwec.bookshelf.model.Book;
import mk.iwec.bookshelf.service.BookService;

@RestController
@RequestMapping("books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping
	public List<Book> findAll() {
		return bookService.findAll();
	}

	@GetMapping("/book/{id}")
	public Book getBookById(@PathVariable("id") Integer id) {
		return bookService.findById(id);
	}

	@PostMapping
	public void registerNewBook(@RequestBody Book book) {
		bookService.insert(book);
	}

	@PutMapping("book/{id}")
	public void updateBook(@PathVariable("id") Integer id, @RequestBody Book book) {
		bookService.update(id, book);
	}

	@DeleteMapping("book/{id}")
	public void deleteBook(@PathVariable("id") Integer id) {
		bookService.deleteById(id);
	}
}
