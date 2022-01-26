package br.com.blog.modules.post.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<Post> savePost(@RequestBody Post post) throws URISyntaxException{
        
        Post postSaved = postService.savePost(post);
        
        return ResponseEntity.created(new URI("/post/posts/" + postSaved.getId())).body(postSaved);
    }
    
}
