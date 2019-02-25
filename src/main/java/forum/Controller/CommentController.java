package forum.Controller;

import forum.Model.Comment;

import forum.Model.CommentJsonResponse;
import forum.Model.Subject;
import forum.Service.CommentService;
import forum.Service.serviceImpl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 25.02.2019 18:25
 *
 * @author Edward
 */
@Controller
public class CommentController {


    @Autowired
    CommentService commentService;


    @PostMapping(value = "/saveComment", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public CommentJsonResponse saveComment(@ModelAttribute @Valid Comment comment,
                                           BindingResult result) {

        CommentJsonResponse jsonResponse = new CommentJsonResponse();

        if (result.hasErrors()) {
            Map<String, String> errors = result.getFieldErrors().stream()
                    .collect(
                            Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            jsonResponse.setValidated(false);
            jsonResponse.setErrorMessages(errors);
        } else {

            Comment comment1 = new Comment(comment.getUserComment(), LocalDate.now());
            commentService.save(comment1);
            jsonResponse.setValidated(true);
            jsonResponse.setComment(comment);
        }
        return jsonResponse;
    }

    @RequestMapping(path = "/comments", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAllComments() {
        List<Comment> comments = commentService.getAll();
        ModelAndView modelAndView = new ModelAndView("comments");
        modelAndView.addObject("allComments", comments);
        return modelAndView;
    }
}
