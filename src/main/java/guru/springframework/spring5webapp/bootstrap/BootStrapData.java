package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepositoriy;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.hibernate.Session;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepositoriy authorRepositoriy;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepositoriy authorRepositoriy, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepositoriy = authorRepositoriy;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher westing = new Publisher("Westing House","1234 Lala Lane","Los Angels","CA","67854");
        publisherRepository.save(westing);
        Author tad = new Author("Tad","Williams");
        Book DBC = new Book("Dragon Bone Chair","12345632");

        tad.getBooks().add(DBC);
        DBC.getAuthors().add(tad);

        DBC.setPublisher(westing);
        westing.getBooks().add(DBC);
        authorRepositoriy.save(tad);
        bookRepository.save(DBC);
        publisherRepository.save(westing);



        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Development Without EJB","47793921");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepositoriy.save(rod);
        bookRepository.save(noEJB);
        noEJB.setPublisher(westing);
        westing.getBooks().add(noEJB);
        publisherRepository.save(westing);
        System.out.println("Started in Bootstap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println("Number of books in westing: " + westing.getBooks().size());
    }
}
