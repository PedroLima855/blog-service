package br.com.blog.modules.security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.blog.modules.security.entities.User;
import br.com.blog.modules.security.entities.UserResponse;
import br.com.blog.modules.security.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {
    
    @Autowired
    private UserRepository userRepository;
    
    public Optional<User> findByIdUser(Long id) {
        return userRepository.findById(id);
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByEmail(username);
        UserResponse userResponse = new UserResponse();
        userResponse.setEmail(user.getEmail());
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setPassword(user.getPassword());
        userResponse.setRoles(user.getRoles());
        return  userResponse;
    }
    
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
