package br.com.blog.modules.post.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.blog.modules.post.entities.Post;
import br.com.blog.modules.post.repositories.PostRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    public Post savePost(Post post) {
        try {
            post = postRepository.save(post);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        }
        return post;
    }

}
