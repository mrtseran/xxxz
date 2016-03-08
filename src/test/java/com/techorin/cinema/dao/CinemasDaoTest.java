package com.techorin.cinema.dao;

import com.techorin.cinema.dao.BaseDaoTestCase;
import com.techorin.cinema.model.Cinemas;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CinemasDaoTest extends BaseDaoTestCase {
    @Autowired
    private CinemasDao cinemasDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveCinemas() {
        Cinemas cinemas = new Cinemas();

        // enter all required fields
        cinemas.setDisplayInHome(Boolean.FALSE);

        log.debug("adding cinemas...");
        cinemas = cinemasDao.save(cinemas);

        cinemas = cinemasDao.get(cinemas.getId());

        assertNotNull(cinemas.getId());

        log.debug("removing cinemas...");

        cinemasDao.remove(cinemas.getId());

        // should throw DataAccessException 
        cinemasDao.get(cinemas.getId());
    }
}