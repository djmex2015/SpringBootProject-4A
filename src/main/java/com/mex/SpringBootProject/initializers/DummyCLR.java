package com.mex.SpringBootProject.initializers;

import com.mex.SpringBootProject.entities.FilmEntity;
import com.mex.SpringBootProject.entities.UserEntity;
import com.mex.SpringBootProject.repositories.IFilmRepository;
import com.mex.SpringBootProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class DummyCLR implements CommandLineRunner {

    @Autowired
    private IFilmRepository filmRepo;

    @Autowired
    private UserService userServ;

    @Override
    public void run(String... args) throws Exception {

        for (int i = 0; i < 10; i++) {
            FilmEntity film = new FilmEntity();
            film.setTitle("Navegantes" + i);
            film.setDirector("Spielberg" + i);
            film.setStatus(false);
            filmRepo.save(film);

            FilmEntity film1 = new FilmEntity();
            film1.setTitle("Breaking Laws");
            film1.setDirector("Coppola");
            film1.setStatus(true);
            filmRepo.save(film1);
        }

        for (int i = 0; i < 10; i++) {
            UserEntity user = new UserEntity();
            user.setName("Test " + i);
            user.setEmail("test" + i + "@test.com");
            user.setEncryptedPassword("noencryptedyet" + i);
            userServ.saveUser(user);
        }

    }
}
