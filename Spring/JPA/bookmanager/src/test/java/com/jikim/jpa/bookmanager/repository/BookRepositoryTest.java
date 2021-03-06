package com.jikim.jpa.bookmanager.repository;

import com.jikim.jpa.bookmanager.domain.Book;
import com.jikim.jpa.bookmanager.domain.Publisher;
import com.jikim.jpa.bookmanager.domain.Review;
import com.jikim.jpa.bookmanager.domain.User;
import com.jikim.jpa.bookmanager.repository.dto.BookStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    void bookTest() {
        Book book = new Book();
        book.setName("BOOK");
        book.setAuthorId(1L);
//        book.setPublisherId(1L);

        bookRepository.save(book);

        System.out.println(bookRepository.findAll());

    }

    @Test
    @Transactional
    void bookRelationTest() {
        givenBookAndReview();

        User user = userRepository.findByEmail("martin@fastcampus.com");

        System.out.println("getReviews() = " + user.getReviews());
        System.out.println("getBook() = " + user.getReviews().get(0).getBook());
        System.out.println("getPublisher() = " + user.getReviews().get(0).getBook().getPublisher());
    }

//    @Transactional
    @Test
    void bookCascadeTest() {
        Book book = new Book();
        book.setName("JPA");

        Publisher publisher = new Publisher();
        publisher.setName("KIM");

        book.setPublisher(publisher);
        bookRepository.save(book);

        System.out.println("bookRepository.findAll() = " + bookRepository.findAll());
        System.out.println("publisherRepository.findAll() = " + publisherRepository.findAll());

        Book book1 = bookRepository.findById(1L).get();
        book1.getPublisher().setName("LEE");

        bookRepository.save(book1);

        System.out.println("publisherRepository.findAll() = " + publisherRepository.findAll());

        Book book2 = bookRepository.findById(1L).get();
//        bookRepository.delete(book2);

//        publisherRepository.delete(book2.getPublisher());

        Book book3 = bookRepository.findById(1L).get();
        book3.setPublisher(null);

        bookRepository.save(book3);

        System.out.println("bookRepository.findAll() = " + bookRepository.findAll());
        System.out.println("publisherRepository.findAll() = " + publisherRepository.findAll());
        System.out.println("bookRepository.findById(1L).get().getPublisher() = " + bookRepository.findById(1L).get().getPublisher());
    }

    @Test
    void bookRemoveCascade() {
        bookRepository.deleteById(1L);
        System.out.println("bookRepository.findAll() = " + bookRepository.findAll());
        System.out.println("publisherRepository.findAll() = " + publisherRepository.findAll());

        bookRepository.findAll().forEach(book -> System.out.println(book.getPublisher()));
    }

    @Test
    void softDelete() {
        bookRepository.findAll().forEach(System.out::println);
        System.out.println(bookRepository.findById(3L));

        bookRepository.findByCategoryIsNull().forEach(System.out::println);

//        bookRepository.findAllByDeletedFalse().forEach(System.out::println);
//        bookRepository.findByCategoryIsNullAndDeletedFalse().forEach(System.out::println);
    }

    @Test
    void queryTest() {
        bookRepository.findAll().forEach(System.out::println);
        System.out.println("bookRepository.findByCategoryIsNullAndNameEqualsAndCreatedAtGreaterThanEqualAndUpdatedAtGreaterThanEqual() = " +
                bookRepository.findByCategoryIsNullAndNameEqualsAndCreatedAtGreaterThanEqualAndUpdatedAtGreaterThanEqual(
                        "JPA",
                        LocalDateTime.now().minusDays(1L),
                        LocalDateTime.now().minusDays(1L)
                ));

        System.out.println("findByNameRecently" +
                bookRepository.findByNameRecently(
                        "JPA",
                        LocalDateTime.now().minusDays(1L),
                        LocalDateTime.now().minusDays(1L)
                ));

        System.out.println(bookRepository.findBookNameAndCategory());

//        bookRepository.findBookNameAndCategory().forEach(tuple -> System.out.println(tuple.get(0) + " : " + tuple.get(1)));
        bookRepository.findBookNameAndCategory().forEach(b -> System.out.println(b.getName() + " : " + b.getCategory()));

        bookRepository.findBookNameAndCategory(PageRequest.of(1,1)).forEach(
                bookNameAndCategory -> System.out.println(bookNameAndCategory.getName() + " : " + bookNameAndCategory.getCategory())
        );

        bookRepository.findBookNameAndCategory(PageRequest.of(0,1)).forEach(
                bookNameAndCategory -> System.out.println(bookNameAndCategory.getName() + " : " + bookNameAndCategory.getCategory())
        );
    }

    @Test
    void nativeQueryTest() {
//        bookRepository.findAll().forEach(System.out::println);
//        bookRepository.findAllCustom().forEach(System.out::println);

        List<Book> books = bookRepository.findAll();

        for (Book book : books) {
            book.setCategory("IT?????????");
        }
        bookRepository.saveAll(books);
        System.out.println(bookRepository.findAll());

        System.out.println("affected rows : " + bookRepository.updateCategories());
        bookRepository.findAllCustom().forEach(System.out::println);

        System.out.println(bookRepository.showTables());
    }

    @Test
    void converterTest() {
        bookRepository.findAll().forEach(System.out::println);

        Book book = new Book();
        book.setName("IT ????????????");
        book.setStatus(new BookStatus(200));
        bookRepository.save(book);
        System.out.println(bookRepository.findRawRecord().values());

        bookRepository.findAll().forEach(System.out::println);
    }

    private void givenBookAndReview() {
        giveReview(givenUser(), givenBook(givenPublisher()));
    }

    private Book givenBook(Publisher publisher) {
        Book book = new Book();
        book.setName("JPA");
        book.setPublisher(publisher);

        return bookRepository.save(book);
    }

    private User givenUser() {
        return userRepository.findByEmail("martin@fastcampus.com");
    }

    private void giveReview(User user, Book book) {
        Review review = new Review();
        review.setTitle("??? ????????? ?????? ???");
        review.setContent("???????????? ???????????? ????????? ???????????????.");
        review.setScore(5.0f);
        review.setUser(user);
        review.setBook(book);

        reviewRepository.save(review);
    }

    private Publisher givenPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("fastcampus");

        return publisherRepository.save(publisher);
    }
}