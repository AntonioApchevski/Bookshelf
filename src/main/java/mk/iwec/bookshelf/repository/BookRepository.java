package mk.iwec.bookshelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mk.iwec.bookshelf.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
