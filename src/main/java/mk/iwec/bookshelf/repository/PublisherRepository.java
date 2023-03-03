package mk.iwec.bookshelf.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mk.iwec.bookshelf.model.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

	public Optional<Publisher> findPublisherByName(String name);

}
