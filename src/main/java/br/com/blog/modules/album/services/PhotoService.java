package br.com.blog.modules.album.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.blog.modules.album.entities.Photo;
import br.com.blog.modules.album.repositories.PhotoRepository;

@Service
public class PhotoService {
    
    @Autowired
    private PhotoRepository photoRepository;
    
    public List<Photo> findAllPhotos(){
        return photoRepository.findAll();
    }
    
    public Photo savePhotos(Photo photo) {
        try {
            photo = photoRepository.save(photo);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        }
        return photo;
    }

}
