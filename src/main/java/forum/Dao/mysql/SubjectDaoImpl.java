package forum.Dao.mysql;

import forum.Dao.HibernateUtil;
import forum.Dao.SubjectDao;
import forum.Model.Subject;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 22.02.2019 14:21
 * <p>
 * Subject DAO implementation
 *
 * @author Edward
 */
@Repository("subjectDao")
public class SubjectDaoImpl implements SubjectDao {

    @Autowired
    HibernateUtil hibernateUtil;


    @Override
    public Optional<Subject> getById(Long id) {
        return Optional.ofNullable(hibernateUtil.getSession().find(Subject.class, id));
    }

    @Override
    public List<Subject> getAll() {
        Query query = hibernateUtil.getSession().createQuery("SELECT subject FROM Subject subject");
        return query.getResultList();
    }

    @Override
    public void save(Subject subject) {
        HibernateUtil.executeInsideTransaction((session -> session.save(subject)), hibernateUtil.getSession());
    }

    @Override
    public void update(Subject subject) {
        HibernateUtil.executeInsideTransaction((session -> session.update(subject)), hibernateUtil.getSession());
    }

    @Override
    public void delete(Subject subject) {
        HibernateUtil.executeInsideTransaction((session -> session.remove(subject)), hibernateUtil.getSession());
    }
}
