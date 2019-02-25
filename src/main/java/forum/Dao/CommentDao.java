package forum.Dao;

import forum.Model.Comment;

/**
 * @author Edward
 */
public interface CommentDao extends CRUDDao<Comment> {

    Comment getByTopicId(Long topicId);
}
