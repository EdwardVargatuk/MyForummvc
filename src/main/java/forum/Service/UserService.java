package forum.Service;

import forum.Model.User;

/**
 * @author Edward
 */
public interface UserService extends CRUDService<User> {
    User getByLogin(String login);
}
