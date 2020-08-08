package bookstore.dao;

import bookstore.domain.Book;
import bookstore.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookDao {
    private Transaction transaction = null;

    public void addBook(Book book) {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
            session.close();
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }
    }

    public void removeBook(Book book) {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Book bookToRemove = session.find(Book.class, book.getBookId());
            session.delete(bookToRemove);
            transaction.commit();
            session.close();
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }
    }

    public void setNewPrice(Integer bookId, Double price) {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Book bookById = session.find(Book.class, bookId);
            bookById.setPrice(price);
            session.update(bookById);
            transaction.commit();
            session.close();
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }
    }
}
