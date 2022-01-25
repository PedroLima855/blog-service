package br.com.blog.modules.album.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.blog.modules.album.entities.Photo;


@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {

}
