package guru.springgroup.spring5WebApp.bootstrap;

import guru.springgroup.spring5WebApp.Domain.Author;
import guru.springgroup.spring5WebApp.Domain.Book;
import guru.springgroup.spring5WebApp.Domain.Publisher;
import guru.springgroup.spring5WebApp.repositories.AuthorRepository;
import guru.springgroup.spring5WebApp.repositories.BookRepository;
import guru.springgroup.spring5WebApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("CredentialVoid Publishing");
        publisher.setCity("New York");
        publisher.setState("NY");
        System.out.println("Number of Publishers: " + publisherRepository.count());
        publisherRepository.save(publisher);
        System.out.println("Number of Publishers: " + publisherRepository.count());


        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Development without EJB","987634");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisher);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisher.getBooks().add(ddd);
        publisher.getBooks().add(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Books with this publisher: " + publisher.getBooks().size());
    }
}
