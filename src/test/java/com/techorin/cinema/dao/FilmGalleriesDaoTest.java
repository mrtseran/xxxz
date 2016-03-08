package com.techorin.cinema.dao;

import com.techorin.cinema.dao.BaseDaoTestCase;
import com.techorin.cinema.model.FilmGalleries;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FilmGalleriesDaoTest extends BaseDaoTestCase {
    @Autowired
    private FilmGalleriesDao filmGalleriesDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveFilmGalleries() {
        FilmGalleries filmGalleries = new FilmGalleries();

        // enter all required fields
        filmGalleries.setCreated(new java.util.Date());
        filmGalleries.setImageName("PdClKkIrZqRxRpPlXpOcHaXeOdXySlGqRjJpRuWhNiMkBaNbUrTyOiTyDsDtKbKyKvYfLsMjNzRrSaZgThExXoSiUnQmDeYhHtCoMaDuYzEdDqAqUhPhIhRkSlVrJmUpDwHzMbTxSsLyXwOeOjAdCoXgWiXrJsFtTrDdPhCiMkBiDbMdUoCoIrBuSjKySrZdKeKvHeCoIkDqDgTtHaVuQiMwDcUfIaPyXpQpAiWmRnJvQwUvYwMsNqOkMgUgLzU");
        filmGalleries.setModified(new java.util.Date());

        log.debug("adding filmGalleries...");
        filmGalleries = filmGalleriesDao.save(filmGalleries);

        filmGalleries = filmGalleriesDao.get(filmGalleries.getId());

        assertNotNull(filmGalleries.getId());

        log.debug("removing filmGalleries...");

        filmGalleriesDao.remove(filmGalleries.getId());

        // should throw DataAccessException 
        filmGalleriesDao.get(filmGalleries.getId());
    }
}