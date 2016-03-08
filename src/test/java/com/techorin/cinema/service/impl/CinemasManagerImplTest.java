package com.techorin.cinema.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.techorin.cinema.dao.CinemasDao;
import com.techorin.cinema.model.Cinemas;
import com.techorin.cinema.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

public class CinemasManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private CinemasManagerImpl manager;

    @Mock
    private CinemasDao dao;


    @Test
    public void testGetCinemas() {
        log.debug("testing get...");
        //given
        final Long id = 7L;
        final Cinemas cinemas = new Cinemas();
        given(dao.get(id)).willReturn(cinemas);

        //when
        Cinemas result = manager.get(id);

        //then
        assertSame(cinemas, result);
    }

    @Test
    public void testGetCinemass() {
        log.debug("testing getAll...");
        //given
        final List cinemass = new ArrayList();
        given(dao.getAll()).willReturn(cinemass);

        //when
        List result = manager.getAll();

        //then
        assertSame(cinemass, result);
    }

    @Test
    public void testSaveCinemas() {
        log.debug("testing save...");

        //given
        final Cinemas cinemas = new Cinemas();
        // enter all required fields
        cinemas.setDisplayInHome(Boolean.FALSE);
        


        given(dao.save(cinemas)).willReturn(cinemas);

        //when
        manager.save(cinemas);

        //then
        verify(dao).save(cinemas);
    }

    @Test
    public void testRemoveCinemas() {
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