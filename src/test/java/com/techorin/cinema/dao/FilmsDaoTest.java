package com.techorin.cinema.dao;

import com.techorin.cinema.dao.BaseDaoTestCase;
import com.techorin.cinema.model.Films;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FilmsDaoTest extends BaseDaoTestCase {
    @Autowired
    private FilmsDao filmsDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveFilms() {
        Films films = new Films();

        // enter all required fields

        log.debug("adding films...");
        films = filmsDao.save(films);

        films = filmsDao.get(films.getId());

        assertNotNull(films.getId());

        log.debug("removing films...");

        filmsDao.remove(films.getId());

        // should throw DataAccessException 
        filmsDao.get(films.getId());
    }
}