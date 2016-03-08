package com.techorin.cinema.dao;

import com.techorin.cinema.dao.BaseDaoTestCase;
import com.techorin.cinema.model.FilmCategories;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FilmCategoriesDaoTest extends BaseDaoTestCase {
    @Autowired
    private FilmCategoriesDao filmCategoriesDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveFilmCategories() {
        FilmCategories filmCategories = new FilmCategories();

        // enter all required fields

        log.debug("adding filmCategories...");
        filmCategories = filmCategoriesDao.save(filmCategories);

        filmCategories = filmCategoriesDao.get(filmCategories.getId());

        assertNotNull(filmCategories.getId());

        log.debug("removing filmCategories...");

        filmCategoriesDao.remove(filmCategories.getId());

        // should throw DataAccessException 
        filmCategoriesDao.get(filmCategories.getId());
    }
}