package bookstore.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bookstores")
public class Bookstore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookstore_id")
    private Integer bookstoreId;

    private String name;

    private String address;

    @ManyToMany
    @JoinTable(
            name = "bookstores_books",
            joinColumns = { @JoinColumn(name = "bookstore_Id") },
            inverseJoinColumns = { @JoinColumn(name = "book_id") }
    )
    private Set<Book> bookSet = new HashSet<>();

    public Bookstore() {
    }

    public Bookstore(String name, String address, Set<Book> bookSet) {
        this.name = name;
        this.address = address;
        this.bookSet = bookSet;
    }

    public Integer getBookstoreId() {
        return bookstoreId;
    }

    public void setBookstoreId(Integer bookstoreId) {
        this.bookstoreId = bookstoreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Bookstore{" +
                "bookstoreId=" + bookstoreId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
