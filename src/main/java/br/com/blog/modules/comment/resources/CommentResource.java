package br.com.blog.modules.comment.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.blog.modules.comment.entities.Comment;
import br.com.blog.modules.comment.services.CommentService;

@RestController
@RequestMapping("/api/comment")
public class CommentResource {

    @Autowired
    private CommentService commentService;

    @PostMapping("/comments")
    public ResponseEntity<Comment> saveAlbum(@RequestBody Comment comment) throws URISyntaxException {
        try {

            Comment commentSaved = commentService.saveComments(comment);
            return ResponseEntity.created(new URI("/comment/comments/" + commentSaved.getId())).body(commentSaved);

        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @DeleteMapping("/delete/{idUser}/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable Long idUser, @PathVariable Long id) {

        Optional<Comment> comment = commentService.findByIdComment(id);

        if (!comment.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        try {

            commentService.deleteCommentById(idUser, id);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.noContent().build();

    }

}
