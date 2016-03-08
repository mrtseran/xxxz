package com.techorin.cinema.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.techorin.cinema.dao.FilmCategoriesDao;
import com.techorin.cinema.model.FilmCategories;
import com.techorin.cinema.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

public class FilmCategoriesManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private FilmCategoriesManagerImpl manager;

    @Mock
    private FilmCategoriesDao dao;


    @Test
    public void testGetFilmCategories() {
        log.debug("testing get...");
        //given
        final Long id = 7L;
        final FilmCategories filmCategories = new FilmCategories();
        given(dao.get(id)).willReturn(filmCategories);

        //when
        FilmCategories result = manager.get(id);

        //then
        assertSame(filmCategories, result);
    }

    @Test
    public void testGetFilmCategoriess() {
        log.debug("testing getAll...");
        //given
        final List filmCategoriess = new ArrayList();
        given(dao.getAll()).willReturn(filmCategoriess);

        //when
        List result = manager.getAll();

        //then
        assertSame(filmCategoriess, result);
    }

    @Test
    public void testSaveFilmCategories() {
        log.debug("testing save...");

        //given
        final FilmCategories filmCategories = new FilmCategories();
        // enter all required fields
        


        given(dao.save(filmCategories)).willReturn(filmCategories);

        //when
        manager.save(filmCategories);

        //then
        verify(dao).save(filmCategories);
    }

    @Test
    public void testRemoveFilmCategories() {
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