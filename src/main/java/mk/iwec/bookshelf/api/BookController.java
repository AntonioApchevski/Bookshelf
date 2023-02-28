package mk.iwec.bookshelf.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
