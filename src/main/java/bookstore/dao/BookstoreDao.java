package bookstore.dao;

import bookstore.domain.Bookstore;
import bookstore.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookstoreDao {

    private Transaction transaction = null;

    public void addBookstore(Bookstore bookstore) {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(bookstore);
            transaction.commit();
            session.close();
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }
    }

    public void removeBookstore(Bookstore bookstore) {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(bookstore);
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
