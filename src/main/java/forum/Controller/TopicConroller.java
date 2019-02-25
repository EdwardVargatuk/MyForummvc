package forum.Controller;

import forum.Model.Topic;
import forum.Model.User;
import forum.Service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 26.02.2019 0:21
 *
 * @author Edward
 */
@Controller
public class TopicConroller {

    @Autowired
    TopicService topicService;

    @RequestMapping(path = "/topics", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAllTopics() {
        List<Topic> topics = topicService.getAll();
        ModelAndView modelAndView = new ModelAndView("topics");
        modelAndView.addObject("allTopics", topics);
        return modelAndView;
    }
}
