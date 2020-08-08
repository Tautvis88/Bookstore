package bookstore.utils;

import bookstore.domain.Author;
import bookstore.domain.Book;
import bookstore.domain.Bookstore;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtils {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Properties properties = new Properties();
                properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                properties.put(Environment.URL, "jdbc:mysql://localhost:3306/bookstore?useSSL=false&serverTimezone=UTC");
                properties.put(Environment.USER, "root");
                properties.put(Environment.PASS, "admin");
                properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                properties.put(Environment.SHOW_SQL, "true");
                properties.put(Environment.HBM2DDL_AUTO, "create");

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(properties).build();

                Configuration configuration = new Configuration();
                configuration.addAnnotatedClass(Author.class);
                configuration.addAnnotatedClass(Book.class);
                configuration.addAnnotatedClass(Bookstore.class);

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
