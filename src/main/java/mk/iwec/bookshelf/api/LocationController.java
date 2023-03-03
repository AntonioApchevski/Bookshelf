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

import mk.iwec.bookshelf.model.Location;
import mk.iwec.bookshelf.service.LocationService;

@RestController
@RequestMapping("locations")
public class LocationController {

	@Autowired
	private LocationService locationService;

	@GetMapping
	public List<Location> findAll() {
		return locationService.findAll();
	}

	@GetMapping("/location/{id}")
	public Location getLocationById(@PathVariable("id") Integer id) {
		return locationService.findById(id);
	}

	@PostMapping
	public void registerNewLocation(@RequestBody Location location) {
		locationService.insert(location);
	}

	@PutMapping("/location/{id}")
	public void updateLocation(@PathVariable("id") Integer id, @RequestBody Location location) {
		locationService.update(id, location);
	}

	@DeleteMapping("/location/{id}")
	public void deleteLocation(@PathVariable("id") Integer id) {
		locationService.deleteById(id);
	}
}
