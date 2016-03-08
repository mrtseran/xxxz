package com.techorin.cinema.dao;

import com.techorin.cinema.dao.BaseDaoTestCase;
import com.techorin.cinema.model.CinemaShows;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CinemaShowsDaoTest extends BaseDaoTestCase {
    @Autowired
    private CinemaShowsDao cinemaShowsDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveCinemaShows() {
        CinemaShows cinemaShows = new CinemaShows();

        // enter all required fields
        cinemaShows.setShowTime(new java.util.Date());

        log.debug("adding cinemaShows...");
        cinemaShows = cinemaShowsDao.save(cinemaShows);

        cinemaShows = cinemaShowsDao.get(cinemaShows.getId());

        assertNotNull(cinemaShows.getId());

        log.debug("removing cinemaShows...");

        cinemaShowsDao.remove(cinemaShows.getId());

        // should throw DataAccessException 
        cinemaShowsDao.get(cinemaShows.getId());
    }
}