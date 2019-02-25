package forum.Controller;

import forum.Model.User;
import forum.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 25.02.2019 10:54
 *
 * @author Edward
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAllUsers() {
        List<User> users = userService.getAll();
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("usersFromServer", users);
        return modelAndView;
    }


    @RequestMapping(path = "/userCheck", method = RequestMethod.GET)
    public ModelAndView getUserByLogin(@RequestParam(value = "login", required = false) String login,
                                       @RequestParam(value = "password", required = false) String password) {
        User user = null;
        ModelAndView modelAndView = new ModelAndView("users");

        if (login != null) {
            user = userService.getByLogin(login);
            if (password.equals(user.getPassword())) {
                modelAndView.addObject("user", user);
            }
            //not check
        }
        return modelAndView;
    }
}
