package guru.springgroup.spring5WebApp.repositories;

import guru.springgroup.spring5WebApp.Domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
