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
	public Genre getGenreById(@PathVariable("id") Long id) {
		return genreService.findById(id);
	}

	@PostMapping
	public ResponseEntity<Genre> registerNewGenre(@RequestBody Genre genre) {
		Genre newGenre = genreService.insert(genre);
		return new ResponseEntity<>(newGenre, HttpStatus.CREATED);

	}

	@PutMapping("/genre/{id}")
	public ResponseEntity<Genre> updateGenre(@PathVariable("id") Long id, @RequestBody Genre genre) {
		return new ResponseEntity<>(genreService.update(id, genre), HttpStatus.OK);

	}

	@DeleteMapping("/genre/{id}")
	public void deleteGenre(@PathVariable("id") Long id) {
		genreService.deleteById(id);
	}
}
