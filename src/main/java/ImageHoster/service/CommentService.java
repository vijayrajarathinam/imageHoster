package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.repository.CommentRepository;
import ImageHoster.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ImageService imageService;

    //The method calls the createImage() method in the Repository and passes the image to be persisted in the database
    public void addComment(String comment_text,Integer imageId,String image_title, User user) {

        Comment comment = new Comment();
        Image image = imageService.getImage(imageId);
        comment.setText(comment_text);
        comment.setImage(image);
        comment.setUser(user);

        commentRepository.addComment(comment);
    }

}
