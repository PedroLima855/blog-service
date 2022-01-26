package br.com.blog.modules.album.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.blog.modules.album.entities.Photo;
import br.com.blog.modules.album.services.PhotoService;

@RestController
@RequestMapping("/api/photo")
public class PhotoResource {
    
    @Autowired
    private PhotoService photoService;
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Photo> findAllPhotos(){
        return photoService.findAllPhotos();
    }
    
    @PostMapping("/photos")
    public ResponseEntity<Photo> savePhoto(@RequestBody Photo photo) throws URISyntaxException {
        try {

            Photo photoSaved = photoService.savePhotos(photo);
            return ResponseEntity.created(new URI("/photo/photos/" + photoSaved.getId())).body(photoSaved);

        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().build();
        }

    }

}
