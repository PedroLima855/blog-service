package br.com.blog.modules.security.services.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.blog.modules.security.entities.User;

@Component
public class UserAssembler {

    private ModelMapper modelMapper;

    public UserAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    
    public UserDTO toDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public List<UserDTO> toCollectionDTO(List<User> users) {
        return users.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
    
}
