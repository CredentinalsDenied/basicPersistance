package guru.springgroup.spring5WebApp.repositories;

import guru.springgroup.spring5WebApp.Domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
