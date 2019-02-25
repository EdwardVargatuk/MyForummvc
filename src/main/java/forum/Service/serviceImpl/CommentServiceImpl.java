package forum.Service.serviceImpl;


import forum.Dao.mysql.CommentDaoImpl;
import forum.Model.Comment;
import forum.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;


/**
 * 22.02.2019 16:30
 *
 * @author Edward
 */
@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDaoImpl commentDao;

    @Override
    public Comment getByTopicId(Long topicId) {
        return commentDao.getByTopicId(topicId);
    }

    @Override
    public void save(Comment comment) {
        commentDao.save(comment);
    }

    @Override
    public Comment getById(Long id) {
        Optional comment = commentDao.getById(id);
        return (Comment) comment.orElseGet(
                () -> new Comment("there is no comment"));
    }

    @Override
    public void update(Comment comment) {
        commentDao.update(comment);
    }

    @Override
    public void delete(Comment comment) {
        commentDao.delete(comment);
    }

    @Override
    public List<Comment> getAll() {
//        List<Comment> commentList = new ArrayList<>();
//        commentList= commentDao.getAll().stream().sorted().collect(Collectors.toList());
        return commentDao.getAll();
    }
}
