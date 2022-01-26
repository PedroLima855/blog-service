package br.com.blog.modules.security.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.blog.modules.security.entities.User;
import br.com.blog.modules.security.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserResource {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> findByIdUser(@PathVariable Long id){
        Optional<User> user =  userService.findByIdUser(id);

        if(!user.isPresent()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(user.get());
    }
    
    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody User user) throws URISyntaxException {
        try {

            User userSaved = userService.saveUsers(user);
            return ResponseEntity.created(new URI("/user/users/" + userSaved.getId())).body(userSaved);

        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().build();
        }

    }

}
