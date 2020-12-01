package guru.springframework.bootstrap;

import guru.springframework.domain.Author;
import guru.springframework.domain.Book;
import guru.springframework.domain.Publisher;
import guru.springframework.repositories.AuthorRepository;
import guru.springframework.repositories.BookRepository;
import guru.springframework.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design","123123");
        Publisher pgn = new Publisher("LA", "Test", "90015", "Penguin");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(pgn);

        publisherRepository.save(pgn);
        authorRepository.save(eric);
        bookRepository.save(ddd);
        pgn.getBooks().add(ddd);


        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Development without EJB","123123");
        rod.getBooks().add(noEJB);;
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(pgn);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books:" + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println("Publisher Number of Books: " + pgn.getBooks().size());
    }
}
