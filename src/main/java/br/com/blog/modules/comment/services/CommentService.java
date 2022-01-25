package br.com.blog.modules.comment.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.blog.modules.comment.entities.Comment;
import br.com.blog.modules.comment.repositories.CommentRepository;

@Service
public class CommentService {
    
    @Autowired
    private CommentRepository commentRepository;
    
    public Comment saveComment(Comment comment) {
        try {
            comment = commentRepository.save(comment);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        }
        return comment;
    }
    
    public void deleteCommentById(Long id) {
        commentRepository.deleteById(id);
    }
    
    public Optional<Comment> findByIdComment(Long id) {
        return commentRepository.findById(id);
    }


}
