package forum.Dao;


import forum.Model.Comment;
import forum.Model.Subject;
import forum.Model.Topic;
import forum.Model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * @author Edward
 */
@Component
public class HibernateUtil {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }


//
//    static {
//        try {
//            Configuration configuration = new Configuration().configure();
//            configuration.addAnnotatedClass(User.class);
//            configuration.addAnnotatedClass(Comment.class);
//            configuration.addAnnotatedClass(Subject.class);
//            configuration.addAnnotatedClass(Topic.class);
//            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
//            sessionFactory = configuration.buildSessionFactory(builder.build());
//        } catch (Throwable e) {
//            System.err.println("initialize session fact" + e);
//            throw new ExceptionInInitializerError(e);
//        }
//    }
//
//
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }

    public static void executeInsideTransaction(Consumer<Session> action, Session session) {


//            t = session.beginTransaction();
        action.accept(session);
//            t.commit();

    }
}
