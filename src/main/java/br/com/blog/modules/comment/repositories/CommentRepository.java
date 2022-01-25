package br.com.blog.modules.comment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.blog.modules.comment.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
