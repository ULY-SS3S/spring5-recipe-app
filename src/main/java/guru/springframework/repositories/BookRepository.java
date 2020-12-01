package guru.springframework.repositories;

import guru.springframework.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface BookRepository extends CrudRepository<Book,Long> {

}
