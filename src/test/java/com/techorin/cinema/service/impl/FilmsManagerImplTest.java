package com.techorin.cinema.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.techorin.cinema.dao.FilmsDao;
import com.techorin.cinema.model.Films;
import com.techorin.cinema.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

public class FilmsManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private FilmsManagerImpl manager;

    @Mock
    private FilmsDao dao;


    @Test
    public void testGetFilms() {
        log.debug("testing get...");
        //given
        final Long id = 7L;
        final Films films = new Films();
        given(dao.get(id)).willReturn(films);

        //when
        Films result = manager.get(id);

        //then
        assertSame(films, result);
    }

    @Test
    public void testGetFilmss() {
        log.debug("testing getAll...");
        //given
        final List filmss = new ArrayList();
        given(dao.getAll()).willReturn(filmss);

        //when
        List result = manager.getAll();

        //then
        assertSame(filmss, result);
    }

    @Test
    public void testSaveFilms() {
        log.debug("testing save...");

        //given
        final Films films = new Films();
        // enter all required fields
        


        given(dao.save(films)).willReturn(films);

        //when
        manager.save(films);

        //then
        verify(dao).save(films);
    }

    @Test
    public void testRemoveFilms() {
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