package mk.iwec.bookshelf.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.iwec.bookshelf.model.Genre;
import mk.iwec.bookshelf.service.GenreService;

@RestController
@RequestMapping("genres")
public class GenreController {

	@Autowired
	private GenreService genreService;

	@GetMapping
	public List<Genre> findAll() {
		return genreService.findAll();
	}
}
