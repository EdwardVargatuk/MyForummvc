package forum.Service;

import forum.Model.Comment;

/**
 * 22.02.2019 16:01
 *
 * @author Edward
 */
public interface CommentService extends CRUDService<Comment> {
    Comment getByTopicId(Long topicId);
}
