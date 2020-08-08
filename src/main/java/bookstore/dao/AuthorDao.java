package bookstore.dao;

import bookstore.domain.Author;
import bookstore.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AuthorDao {

    private Transaction transaction = null;

    public void addAuthor(Author author) {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
            session.close();
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }
    }

    public void removeAuthor(Author author) {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Author authorToRemove = session.find(Author.class, author.getAuthorId());
            session.delete(authorToRemove);
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
