package com.mex.SpringBootProject.repositories;

import com.mex.SpringBootProject.entities.FilmEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "film", collectionResourceRel = "film")
public interface IFilmRepository extends CrudRepository<FilmEntity, Long> {

    List<FilmEntity> findByTitle(String title);
    
    List<FilmEntity> findByStatus(boolean isActive);
}