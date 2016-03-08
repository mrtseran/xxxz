package com.techorin.cinema.service.impl;

import com.techorin.cinema.dao.CinemaShowsDao;
import com.techorin.cinema.model.CinemaShows;
import com.techorin.cinema.service.CinemaShowsManager;
import com.techorin.cinema.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("cinemaShowsManager")
@WebService(serviceName = "CinemaShowsService", endpointInterface = "com.techorin.cinema.service.CinemaShowsManager")
public class CinemaShowsManagerImpl extends GenericManagerImpl<CinemaShows, Long> implements CinemaShowsManager {
    CinemaShowsDao cinemaShowsDao;

    @Autowired
    public CinemaShowsManagerImpl(CinemaShowsDao cinemaShowsDao) {
        super(cinemaShowsDao);
        this.cinemaShowsDao = cinemaShowsDao;
    }
}