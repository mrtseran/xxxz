package com.techorin.cinema.service.impl;

import com.techorin.cinema.dao.FilmCategoriesDao;
import com.techorin.cinema.model.FilmCategories;
import com.techorin.cinema.service.FilmCategoriesManager;
import com.techorin.cinema.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("filmCategoriesManager")
@WebService(serviceName = "FilmCategoriesService", endpointInterface = "com.techorin.cinema.service.FilmCategoriesManager")
public class FilmCategoriesManagerImpl extends GenericManagerImpl<FilmCategories, Long> implements FilmCategoriesManager {
    FilmCategoriesDao filmCategoriesDao;

    @Autowired
    public FilmCategoriesManagerImpl(FilmCategoriesDao filmCategoriesDao) {
        super(filmCategoriesDao);
        this.filmCategoriesDao = filmCategoriesDao;
    }
}