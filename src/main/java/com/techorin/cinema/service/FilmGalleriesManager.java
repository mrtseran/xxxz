package com.techorin.cinema.service;

import com.techorin.cinema.service.GenericManager;
import com.techorin.cinema.model.FilmGalleries;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface FilmGalleriesManager extends GenericManager<FilmGalleries, Long> {
	
    
}