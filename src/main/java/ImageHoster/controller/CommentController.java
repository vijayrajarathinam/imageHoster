package ImageHoster.controller;

import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    //Here a list of tags is added in the Model type object
    //this list is then sent to 'images/image.html' file and the tags are displayed
    @RequestMapping(value = "/image/{imageId}/{title}/comments",method = RequestMethod.POST)
    public String addComment(
            @PathVariable("imageId") Integer imageId,
            @PathVariable("title") String title,
            @RequestParam("comment") String comment_text,
            Model model, HttpSession session) {

        User user = (User) session.getAttribute("loggeduser");
        commentService.addComment(comment_text,imageId,title,user);

        return "redirect:/images/"+imageId+"/"+title;
    }
}
