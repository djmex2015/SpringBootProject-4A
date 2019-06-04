package com.mex.SpringBootProject.services;

import com.mex.SpringBootProject.entities.FilmEntity;
import com.mex.SpringBootProject.exceptions.MessageException;
import com.mex.SpringBootProject.repositories.IFilmRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("filmService")
public class FilmServiceImpl implements FilmService {

    IFilmRepository filmRepo;

    @Autowired
    public FilmServiceImpl(IFilmRepository filmRepo) {
        this.filmRepo = filmRepo;
    }

    @Override
    public List<FilmEntity> getFilmByTitle(String title) throws MessageException {
        List<FilmEntity> filmEntities = filmRepo.findByTitle(title);
        if (filmEntities == null) {
            throw new MessageException("The film does not exist.");
        }
        return filmEntities;
    }

    @Override
    public List<FilmEntity> getFilmsByStatus(boolean isActive) throws MessageException {
        List<FilmEntity> filmEntities = filmRepo.findByStatus(isActive);
        if (filmEntities.isEmpty()) {
            throw new MessageException("There are not films availables.");
        }
        return filmEntities;
    }

    @Override
    public FilmEntity updateStatus(Long id) throws MessageException {
        Optional<FilmEntity> filmExists = filmRepo.findById(id);
        if (!filmExists.isPresent()) {
            throw new MessageException("Film does not exists.");
        }
        FilmEntity film = filmExists.get();
        film.setStatus(!film.isStatus());
        return filmRepo.save(film);
    }
}
