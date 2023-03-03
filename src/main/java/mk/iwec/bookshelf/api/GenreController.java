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

	@GetMapping("/genre/{id}")
	public Genre getGenreById(@PathVariable("id") Integer id) {
		return genreService.findById(id);
	}

	@PostMapping
	public void registerNewGenre(@RequestBody Genre genre) {
		genreService.insert(genre);
	}

	@PutMapping("/genre/{id}")
	public void updateGenre(@PathVariable("id") Integer id, @RequestBody Genre genre) {
		genreService.update(id, genre);
	}

	@DeleteMapping("/genre/{id}")
	public void deleteGenre(@PathVariable("id") Integer id) {
		genreService.deleteById(id);
	}
}
