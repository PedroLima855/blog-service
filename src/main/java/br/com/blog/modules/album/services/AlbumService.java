package br.com.blog.modules.album.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.blog.modules.album.entities.Album;
import br.com.blog.modules.album.repositories.AlbumRepository;

@Service
public class AlbumService {
    
    private final String MESSAGE_DEFAULT_ALBUM = "This user does not have permission to delete this album";
    
    @Autowired
    private AlbumRepository albumRepository;
    
    public List<Album> findAllAlbums(){
        return albumRepository.findAll();
    }
    
    public Album saveAlbums(Album album) {
        try {
            album = albumRepository.save(album);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        }
        return album;
    }
    
    public void deleteAlbumById(Long idUser, Long id) {

        Optional<Album> album = albumRepository.findById(id);

        if (!album.get().getIdUser().equals(idUser)) {
            throw new IllegalArgumentException(MESSAGE_DEFAULT_ALBUM);
        }
        
        albumRepository.deleteById(id);
    }
    
    public Optional<Album> findByIdAlbum(Long id) {
        return albumRepository.findById(id);
    }
    
}
