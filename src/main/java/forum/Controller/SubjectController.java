package forum.Controller;


import forum.Model.Subject;
import forum.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 25.02.2019 15:52
 *
 * @author Edward
 */
@Controller
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @RequestMapping(path = "/subjects", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAllUsers() {
        List<Subject> subjects = subjectService.getAll();
        ModelAndView modelAndView = new ModelAndView("main");
        modelAndView.addObject("allSubjects", subjects);
        return modelAndView;
    }

}
