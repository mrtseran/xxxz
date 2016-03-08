package com.techorin.cinema.service;

import com.techorin.cinema.service.GenericManager;
import com.techorin.cinema.model.FilmCategories;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface FilmCategoriesManager extends GenericManager<FilmCategories, Long> {
    
}