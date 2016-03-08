package com.techorin.cinema.service.impl;

import com.techorin.cinema.dao.FilmGalleriesDao;
import com.techorin.cinema.model.FilmGalleries;
import com.techorin.cinema.service.FilmGalleriesManager;
import com.techorin.cinema.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("filmGalleriesManager")
@WebService(serviceName = "FilmGalleriesService", endpointInterface = "com.techorin.cinema.service.FilmGalleriesManager")
public class FilmGalleriesManagerImpl extends GenericManagerImpl<FilmGalleries, Long> implements FilmGalleriesManager {
    FilmGalleriesDao filmGalleriesDao;

    @Autowired
    public FilmGalleriesManagerImpl(FilmGalleriesDao filmGalleriesDao) {
        super(filmGalleriesDao);
        this.filmGalleriesDao = filmGalleriesDao;
    }
}