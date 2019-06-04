package com.mex.SpringBootProject.controllers;

import com.mex.SpringBootProject.entities.FilmEntity;
import com.mex.SpringBootProject.exceptions.MessageException;
import com.mex.SpringBootProject.services.FilmService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @RequestMapping(value = {"/title/{title}"}, method = RequestMethod.GET)
    public List<FilmEntity> getFilmByTitle(@PathVariable("title") String title) throws MessageException {
        return filmService.getFilmByTitle(title);
    }

    @Produces(value = MediaType.APPLICATION_JSON)
    @RequestMapping(value = {"/filmByStatus/{status}"}, method = RequestMethod.GET)
    public List<FilmEntity> getFilmsByStatus(@PathVariable("status") boolean isActive) throws MessageException {
        return filmService.getFilmsByStatus(isActive);
    }

    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @PutMapping(value = "/updFilm/{idFilm}")
    public @ResponseBody FilmEntity updateStatus(@PathVariable("idFilm") long idFilm) throws MessageException {
        return filmService.updateStatus(idFilm);
    }
}
