package com.techorin.cinema.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.techorin.cinema.dao.FilmGalleriesDao;
import com.techorin.cinema.model.FilmGalleries;
import com.techorin.cinema.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

public class FilmGalleriesManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private FilmGalleriesManagerImpl manager;

    @Mock
    private FilmGalleriesDao dao;


    @Test
    public void testGetFilmGalleries() {
        log.debug("testing get...");
        //given
        final Long id = 7L;
        final FilmGalleries filmGalleries = new FilmGalleries();
        given(dao.get(id)).willReturn(filmGalleries);

        //when
        FilmGalleries result = manager.get(id);

        //then
        assertSame(filmGalleries, result);
    }

    @Test
    public void testGetFilmGalleriess() {
        log.debug("testing getAll...");
        //given
        final List filmGalleriess = new ArrayList();
        given(dao.getAll()).willReturn(filmGalleriess);

        //when
        List result = manager.getAll();

        //then
        assertSame(filmGalleriess, result);
    }

    @Test
    public void testSaveFilmGalleries() {
        log.debug("testing save...");

        //given
        final FilmGalleries filmGalleries = new FilmGalleries();
        // enter all required fields
        filmGalleries.setCreated(new java.util.Date());
        filmGalleries.setImageName("IsRdEuYqMqQfCwTeTyQwSoZtZzHlGgMnImVqLkIjJmWdXhGqTnQwMyLeSkOpPmMuCsVnQgXbAlMmBjUeHsPaMpAgDwRxIgNfWrTwNkJbTpLdHlNmVhXlIyWxQcXqNhPhKpYpEqYqNjBvSgGsUiOgOnUmUsCbJhEmGePoWcDyWtZmCfThUoXvPkZqKwQxYuPaFgAjCuQzMgEvRmAfBjDrDgBqGfUfWtOlSrWbAyIcQyPlYuFiGtMgLfKwQxHhIzB");
        filmGalleries.setModified(new java.util.Date());
        


        given(dao.save(filmGalleries)).willReturn(filmGalleries);

        //when
        manager.save(filmGalleries);

        //then
        verify(dao).save(filmGalleries);
    }

    @Test
    public void testRemoveFilmGalleries() {
        log.debug("testing remove...");

        //given
        final Long id = -11L;
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}