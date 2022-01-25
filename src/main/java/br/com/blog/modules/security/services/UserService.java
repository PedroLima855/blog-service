package br.com.blog.modules.security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blog.modules.security.entities.User;
import br.com.blog.modules.security.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public Optional<User> findByIdUser(Long id) {
        return userRepository.findById(id);
    }

}
