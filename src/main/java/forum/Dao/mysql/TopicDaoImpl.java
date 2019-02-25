package forum.Dao.mysql;

import forum.Dao.HibernateUtil;
import forum.Dao.TopicDao;
import forum.Model.Topic;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Topic DAO implementation
 *
 * @author Edward
 */
@Repository("topicDao")
public class TopicDaoImpl implements TopicDao {

    @Autowired
    HibernateUtil hibernateUtil;


    @Override
    public Optional<Topic> getById(Long id) {
        return Optional.ofNullable(hibernateUtil.getSession().find(Topic.class, id));
    }

    @Override
    public List<Topic> getAll() {
        Query query = hibernateUtil.getSession().createQuery("SELECT topic FROM Topic topic");
        return query.getResultList();
    }

    @Override
    public void save(Topic topic) {
        HibernateUtil.executeInsideTransaction((session -> session.save(topic)), hibernateUtil.getSession());
    }

    @Override
    public void update(Topic topic) {
        HibernateUtil.executeInsideTransaction((session -> session.update(topic)), hibernateUtil.getSession());
    }

    @Override
    public void delete(Topic topic) {
        HibernateUtil.executeInsideTransaction((session -> session.remove(topic)), hibernateUtil.getSession());
    }
}