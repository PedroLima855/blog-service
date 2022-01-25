package br.com.blog.modules.album.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.blog.modules.album.entities.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

}
