package mk.iwec.bookshelf.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
