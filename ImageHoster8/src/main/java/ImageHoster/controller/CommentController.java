package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
public class CommentController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
    public String addCommentSubmit(@PathVariable("imageId") String imageId, Comment comment, HttpSession session) {
        comment.setCreatedDate(LocalDate.now());
        comment.setUser((User) session.getAttribute("loggeduser"));
        comment.setImage(imageService.getImageById(imageId));
        commentService.addCommentForImage(comment);

        return "redirect:/images/" + imageId;
    }

}
