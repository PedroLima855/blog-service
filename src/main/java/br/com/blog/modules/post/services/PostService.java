package br.com.blog.modules.post.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.blog.modules.post.entities.Post;
import br.com.blog.modules.post.repositories.PostRepository;

@Service
public class PostService {
    
    private final String MESSAGE_DEFAULT_POST = "This user does not have permission to delete this post";

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }
    
    public Optional<Post> findByIdPost(Long id){
        return postRepository.findById(id);
    }

    public Post savePost(Post post) {
        try {
            post = postRepository.save(post);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        }
        return post;
    }
    
    public void deletePostById(Long idUser, Long id) {

        Optional<Post> post = postRepository.findById(id);

        if (!post.get().getIdUser().equals(idUser)) {
            throw new IllegalArgumentException(MESSAGE_DEFAULT_POST);
        }
        
        postRepository.deleteById(id);

    }

}
