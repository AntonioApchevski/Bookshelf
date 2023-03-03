package mk.iwec.bookshelf.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.iwec.bookshelf.model.Location;
import mk.iwec.bookshelf.repository.LocationRepository;
import mk.iwec.bookshelf.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRepository;

	@Override
	public Location findById(Integer id) {
		return locationRepository.findById(id).get();
	}

	@Override
	public List<Location> findAll() {
		return locationRepository.findAll();
	}

	@Override
	public void insert(Location location) {
		Optional<Location> locationExists = locationRepository.findLocationByCountryName(location.getCountryName());
		if (locationExists.isPresent()) {
			throw new IllegalStateException("Book already exists in database.");
		}
		locationRepository.save(location);
	}

	@Override
	public void deleteById(Integer id) {
		boolean locationExists = locationRepository.existsById(id);
		if (!locationExists) {
			throw new IllegalStateException("Location with the given id does not exist in database.");
		}
		locationRepository.deleteById(id);
	}

	@Override
	public void update(Integer id, Location location) {
		Location locationExists = locationRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("Book with the given id does not exist in database."));

		locationExists.setCityName(location.getCityName());
		locationExists.setCountryName(location.getCountryName());
	}

}
