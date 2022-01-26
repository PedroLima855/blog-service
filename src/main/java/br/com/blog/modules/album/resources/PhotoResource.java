package br.com.blog.modules.album.resources;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.blog.modules.album.entities.Photo;
import br.com.blog.modules.album.services.PhotoService;

@RestController
@RequestMapping("/api/photo")
public class PhotoResource {
    
    @Autowired
    private PhotoService photoService;
    
    @PostMapping("/photos")
    public ResponseEntity<Photo> saveAlbum(@RequestBody Photo photo) throws URISyntaxException{
        
        Photo photoSaved = photoService.savePhotos(photo);
        
        return ResponseEntity.created(new URI("/photo/photos/" + photoSaved.getId())).body(photoSaved);
    }

}
