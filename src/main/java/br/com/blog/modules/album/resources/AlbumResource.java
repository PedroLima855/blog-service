package br.com.blog.modules.album.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.blog.modules.album.entities.Album;
import br.com.blog.modules.album.services.AlbumService;

@RestController
@RequestMapping("/api/album")
public class AlbumResource {
    
    @Autowired
    private AlbumService albumService;
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Album> findAll(){
        return albumService.findAllAlbums();
    }
    
    @PostMapping("/albums")
    public ResponseEntity<Album> saveAlbum(@RequestBody Album album) throws URISyntaxException{
        
        Album albumSaved = albumService.saveAlbums(album);
        
        return ResponseEntity.created(new URI("/album/albums/" + albumSaved.getId())).body(albumSaved);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlbum(@PathVariable Long id) {

        Optional<Album> album = albumService.findByIdAlbum(id);

        if (!album.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        albumService.deleteAlbums(id);
        return ResponseEntity.noContent().build();
    }

}
