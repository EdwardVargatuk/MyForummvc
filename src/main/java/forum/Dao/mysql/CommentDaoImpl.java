package forum.Dao.mysql;

import forum.Dao.CommentDao;
import forum.Dao.HibernateUtil;
import forum.Model.Comment;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 22.02.2019 14:57
 * <p>
 * the Comment DAO implementation
 *
 * @author Edward
 */
@Repository("commentDao")
public class CommentDaoImpl implements CommentDao {

    @Autowired
    HibernateUtil hibernateUtil;


    @Override
    public Comment getByTopicId(Long topicId) {
        Query query = hibernateUtil.getSession().createQuery("SELECT comment FROM Comment comment where comment.topic.id =:id");
        return (Comment) query.uniqueResult();
    }

    @Override
    public void save(Comment comment) {
        HibernateUtil.executeInsideTransaction((session -> session.save(comment)), hibernateUtil.getSession());
    }

    @Override
    public Optional<Comment> getById(Long id) {
        return Optional.ofNullable(hibernateUtil.getSession().find(Comment.class, id));
    }

    @Override
    public void update(Comment comment) {
        HibernateUtil.executeInsideTransaction((session -> session.update(comment)), hibernateUtil.getSession());
    }

    @Override
    public void delete(Comment comment) {
        HibernateUtil.executeInsideTransaction((session -> session.remove(comment)), hibernateUtil.getSession());
    }

    @Override
    public List<Comment> getAll() {
        Query query = hibernateUtil.getSession().createQuery("SELECT comment FROM Comment comment");
        return query.getResultList();
    }
}
