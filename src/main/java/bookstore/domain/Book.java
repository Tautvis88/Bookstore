package bookstore.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer bookId;

    private String title;

    private Double price;

    @ManyToOne
    // Many books to One author. Book is owning side, so the book must have an author, but the author books - mustn't.
    @JoinColumn(name = "author_id")
    // @JoinColumn anotacija prideda FOREIGN KEY stulpelį books lentelėje SQL'e, kuris vadinsis 'author_id', bet
    // pavadinimą galima parašyti kokį tik nori, pvz. 'bet_koks_pavadinimas'.
    private Author author;
    // Field "author" gets PRIMARY KEY (@Id) from Author class.
    // So in SQL query this whole block of code (@ManyToMany, @JoinColumn) would look like this:
    //      CONSTRAINT fk_books_authors FOREIGN KEY (author_id) REFERENCES authors (author_id)

    @ManyToMany(mappedBy = "bookSet")
    private Set<Bookstore> bookstoreSet = new HashSet<>();

    public Book() {
    }

    public Book(String title, Double price, Author author) {
        this.title = title;
        this.price = price;
        this.author = author;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", author=" + author +
                '}';
    }
}
