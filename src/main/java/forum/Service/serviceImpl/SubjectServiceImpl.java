package forum.Service.serviceImpl;


import forum.Dao.mysql.SubjectDaoImpl;
import forum.Model.Subject;
import forum.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * 22.02.2019 16:28
 *
 * @author Edward
 */
@Service("/subjectService")
@Transactional
public class SubjectServiceImpl implements SubjectService {
    
    @Autowired
    private SubjectDaoImpl subjectDao;


    @Override
    public void save(Subject subject) {
        subjectDao.save(subject);
    }

    @Override
    public Subject getById(Long id) {
        Optional subject = subjectDao.getById(id);
        return (Subject) subject.orElseGet(
                () -> new Subject("no subject"));
    }

    @Override
    public void update(Subject subject) {
        subjectDao.update(subject);
    }

    @Override
    public void delete(Subject subject) {
        subjectDao.delete(subject);
    }

    @Override
    public List<Subject> getAll() {
        return subjectDao.getAll();
    }
}
