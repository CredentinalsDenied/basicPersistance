package guru.springgroup.spring5WebApp.repositories;

import guru.springgroup.spring5WebApp.Domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
