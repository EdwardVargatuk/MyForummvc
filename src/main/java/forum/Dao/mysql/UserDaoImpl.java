package forum.Dao.mysql;

import forum.Dao.HibernateUtil;
import forum.Dao.UserDao;
import forum.Model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * User DAO implementation
 *
 * @author Edward
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    HibernateUtil hibernateUtil;



    @Override
    public Optional<User> getById(Long id) {
        return Optional.ofNullable(hibernateUtil.getSession().find(User.class, id));
    }

    @Override
    public List<User> getAll() {
        Query query = hibernateUtil.getSession().createQuery("SELECT user FROM User user");
        return query.getResultList();
    }

    @Override
    public void save(User user) {
        HibernateUtil.executeInsideTransaction((session -> session.save(user)), hibernateUtil.getSession());
    }

    @Override
    public void update(User user) {
        HibernateUtil.executeInsideTransaction((session -> session.update(user)), hibernateUtil.getSession());
    }

    @Override
    public void delete(User user) {
        HibernateUtil.executeInsideTransaction((session -> session.remove(user)), hibernateUtil.getSession());
    }

    @Override
    public Optional getByLogin(String login) {
        Query query = hibernateUtil.getSession().getNamedQuery("findUserByLogin");
        query.setParameter("login", login);
        return Optional.ofNullable(query.uniqueResult());

    }
}