package forum.Service.serviceImpl;

import forum.Dao.UserDao;
import forum.Dao.mysql.UserDaoImpl;
import forum.Model.User;
import forum.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * 22.02.2019 15:40
 *
 * @author Edward
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao ;

    @Override
    public User getByLogin(String login) {
        Optional user = userDao.getByLogin(login);
        return (User) user.orElseGet(
                () -> new User("no name", "no password"));
    }

    @Override
    public User getById(Long id) {
        Optional user = userDao.getById(id);
        return (User) user.orElseGet(
                () -> new User("no name", "no password"));
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }


    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public List<User> getAll() {
       return userDao.getAll();
    }
}
