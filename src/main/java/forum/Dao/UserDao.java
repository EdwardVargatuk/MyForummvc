package forum.Dao;

import forum.Model.User;

import java.util.Optional;

/**
 * @author Edward
 */
public interface UserDao extends CRUDDao<User> {

    Optional getByLogin(String login);

}