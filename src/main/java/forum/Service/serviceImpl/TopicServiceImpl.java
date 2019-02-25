package forum.Service.serviceImpl;


import forum.Dao.mysql.TopicDaoImpl;
import forum.Model.Topic;
import forum.Service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * 22.02.2019 16:29
 *
 * @author Edward
 */
@Service("topicService")
@Transactional
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicDaoImpl topicDao;

    @Override
    public void save(Topic topic) {
        topicDao.save(topic);
    }

    @Override
    public Topic getById(Long id) {
        Optional topic = topicDao.getById(id);
        return (Topic) topic.orElseGet(
                () -> new Topic("no topic found"));
    }

    @Override
    public void update(Topic topic) {
        topicDao.update(topic);
    }

    @Override
    public void delete(Topic topic) {
        topicDao.delete(topic);
    }

    @Override
    public List<Topic> getAll() {
        return topicDao.getAll();
    }
}
