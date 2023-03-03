package mk.iwec.bookshelf.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mk.iwec.bookshelf.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

	public Optional<Location> findLocationByCountryName(String countryName);

}
