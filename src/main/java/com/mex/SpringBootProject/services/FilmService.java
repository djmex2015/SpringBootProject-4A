package com.mex.SpringBootProject.services;

import com.mex.SpringBootProject.entities.FilmEntity;
import com.mex.SpringBootProject.exceptions.MessageException;
import java.util.List;

public interface FilmService {

    public List<FilmEntity> getFilmByTitle(String title) throws MessageException;
    
    public List<FilmEntity> getFilmsByStatus(boolean isActive) throws MessageException;

    public FilmEntity updateStatus(Long id) throws MessageException;
    
}
