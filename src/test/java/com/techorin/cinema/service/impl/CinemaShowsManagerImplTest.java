package com.techorin.cinema.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.techorin.cinema.dao.CinemaShowsDao;
import com.techorin.cinema.model.CinemaShows;
import com.techorin.cinema.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

public class CinemaShowsManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private CinemaShowsManagerImpl manager;

    @Mock
    private CinemaShowsDao dao;


    @Test
    public void testGetCinemaShows() {
        log.debug("testing get...");
        //given
        final Long id = 7L;
        final CinemaShows cinemaShows = new CinemaShows();
        given(dao.get(id)).willReturn(cinemaShows);

        //when
        CinemaShows result = manager.get(id);

        //then
        assertSame(cinemaShows, result);
    }

    @Test
    public void testGetCinemaShowss() {
        log.debug("testing getAll...");
        //given
        final List cinemaShowss = new ArrayList();
        given(dao.getAll()).willReturn(cinemaShowss);

        //when
        List result = manager.getAll();

        //then
        assertSame(cinemaShowss, result);
    }

    @Test
    public void testSaveCinemaShows() {
        log.debug("testing save...");

        //given
        final CinemaShows cinemaShows = new CinemaShows();
        // enter all required fields
        cinemaShows.setShowTime(new java.util.Date());
        


        given(dao.save(cinemaShows)).willReturn(cinemaShows);

        //when
        manager.save(cinemaShows);

        //then
        verify(dao).save(cinemaShows);
    }

    @Test
    public void testRemoveCinemaShows() {
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