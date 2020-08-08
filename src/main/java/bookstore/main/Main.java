package bookstore.main;

import bookstore.dao.AuthorDao;
import bookstore.dao.BookDao;
import bookstore.dao.BookstoreDao;
import bookstore.domain.Author;
import bookstore.domain.Book;
import bookstore.domain.Bookstore;
import bookstore.utils.HibernateUtils;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        // Creating authors
        Author author1 = new Author("Joanne", "Rowling",
                LocalDate.of(1975,10,5), "England");

        Author author2 = new Author("Vytautas", "Didysis",
                LocalDate.of(1800,1,10), "Lietuva");

        Author author3 = new Author("Edvinas", "Geriausias",
                LocalDate.of(1991,5,28), "USA");

        // Adding authors to database
        AuthorDao authorDao = new AuthorDao();
        authorDao.addAuthor(author1);
        authorDao.addAuthor(author2);
        authorDao.addAuthor(author3);

        // Creating books
        Book book1 = new Book("Haris Poteris", 25.5, author1);
        Book book2 = new Book("Namai namai", 20.6, author1);
        Book book3 = new Book("Be namu negerai", 15.5, author1);
        Book book4 = new Book("Programavimas", 36.0, author2);
        Book book5 = new Book("Super knyga", 12.0, author2);
        Book book6 = new Book("Bestseleris", 10.9, author2);
        Book book7 = new Book("Java Fundamentals", 50.99, author3);
        Book book8 = new Book("SQL", 35.88, author3);
        Book book9 = new Book("Paspirtukas", 5.99, author3);

        // Adding books to database
        BookDao bookDao = new BookDao();
        bookDao.addBook(book1);
        bookDao.addBook(book2);
        bookDao.addBook(book3);
        bookDao.addBook(book4);
        bookDao.addBook(book5);
        bookDao.addBook(book6);
        bookDao.addBook(book7);
        bookDao.addBook(book8);
        bookDao.addBook(book9);


        // Creating book lists
        Set<Book> bookSet1 = new HashSet<>();
        bookSet1.add(book1);
        bookSet1.add(book2);
        bookSet1.add(book3);
        bookSet1.add(book4);
        bookSet1.add(book5);
        bookSet1.add(book6);
        bookSet1.add(book7);
        bookSet1.add(book8);
        bookSet1.add(book9);

        Set<Book> bookSet2 = new HashSet<>();
        bookSet2.add(book2);
        bookSet2.add(book4);
        bookSet2.add(book6);
        bookSet2.add(book8);

        Set<Book> bookSet3 = new HashSet<>();
        bookSet3.add(book1);
        bookSet3.add(book3);
        bookSet3.add(book5);
        bookSet3.add(book7);
        bookSet3.add(book9);

        // Creating bookstores
        Bookstore bookstore1 = new Bookstore("Pegasas", "Ozo g. 25, Vilnius, Lietuva", bookSet1);
        Bookstore bookstore2 = new Bookstore("Vaga", "Gedimino pr. 13, Vilnius, Lietuva", bookSet2);
        Bookstore bookstore3 = new Bookstore("Eureka", "Universiteto g. 10, Vilnius, Lietuva", bookSet3);

        // Adding bookstores to database
        BookstoreDao bookstoreDao = new BookstoreDao();
        bookstoreDao.addBookstore(bookstore1);
        bookstoreDao.addBookstore(bookstore2);
        bookstoreDao.addBookstore(bookstore3);

        // Removing author from database
        authorDao.removeAuthor(author3);

        // Removing book from database
        bookDao.removeBook(book1);

        // Changing book price
        bookDao.setNewPrice(4, 99.0);
        bookDao.setNewPrice(6, 99.0);


        HibernateUtils.shutdown();
    }
}
