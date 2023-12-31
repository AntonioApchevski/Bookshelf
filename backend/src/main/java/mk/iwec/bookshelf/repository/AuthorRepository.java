package mk.iwec.bookshelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mk.iwec.bookshelf.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

	public Author findAuthorByFirstNameAndMiddleNameAndLastName(String firstName, String middleName, String lastName);

}
