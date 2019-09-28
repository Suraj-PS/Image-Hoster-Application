package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment addCommentForImage(Comment newComment) {
        return commentRepository.addComment(newComment);
    }

    public List<Comment> getAllCommentsForSpecificImage(String imageId) {
        return commentRepository.getAllCommentsByImageId(imageId);
    }

}