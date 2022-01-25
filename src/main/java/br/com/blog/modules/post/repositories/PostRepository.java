package br.com.blog.modules.post.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.blog.modules.post.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
