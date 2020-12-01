package guru.springframework.repositories;

import guru.springframework.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface AuthorRepository extends CrudRepository<Author,Long>{
}
