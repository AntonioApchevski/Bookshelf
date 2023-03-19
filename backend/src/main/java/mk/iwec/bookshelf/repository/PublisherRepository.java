package mk.iwec.bookshelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mk.iwec.bookshelf.model.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

	public Publisher findPublisherByName(String name);

}
