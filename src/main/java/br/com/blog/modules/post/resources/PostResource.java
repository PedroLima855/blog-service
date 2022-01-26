package br.com.blog.modules.post.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.blog.modules.post.entities.Post;
import br.com.blog.modules.post.services.PostService;

@RestController
@RequestMapping("/api/post")
public class PostResource {

    @Autowired
    private PostService postService;
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Post> findAllPosts(){
        return postService.findAllPosts();
    }
    
    @PostMapping("/posts")
    public ResponseEntity<Post> savePost(@RequestBody Post post) throws URISyntaxException {
        try {

            Post postSaved = postService.savePost(post);
            return ResponseEntity.created(new URI("/post/posts/" + postSaved.getId())).body(postSaved);

        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().build();
        }

    }
    
    @DeleteMapping("/delete/{idUser}/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long idUser, @PathVariable Long id) {

        Optional<Post> post = postService.findByIdPost(id);

        if (!post.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        try {

            postService.deletePostById(idUser, id);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.noContent().build();

    }
    
}
