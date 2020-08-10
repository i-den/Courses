package com.denchevgod.demo.bootstrap;

import com.denchevgod.demo.model.Author;
import com.denchevgod.demo.model.Book;
import com.denchevgod.demo.model.Publisher;
import com.denchevgod.demo.repositories.AuthorRepository;
import com.denchevgod.demo.repositories.BookRepository;
import com.denchevgod.demo.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher ericsPublisher = new Publisher("Harper Collins", "Adr");
        Book ddd = new Book("Domain Driven Design", "1234", ericsPublisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(ericsPublisher);

        publisherRepository.save(ericsPublisher);
        bookRepository.save(ddd);
        authorRepository.save(eric);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher rodsPublisher = new Publisher("Wrox", "Adr");
        Book noEJB = new Book("J2EE Development without EJB", "23444", rodsPublisher);
        noEJB.getAuthors().add(rod);
        rod.getBooks().add(noEJB);

        publisherRepository.save(rodsPublisher);
        bookRepository.save(noEJB);
        authorRepository.save(rod);
    }
}
