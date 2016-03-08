package com.techorin.cinema.service;

import com.techorin.cinema.service.GenericManager;
import com.techorin.cinema.model.CinemaShows;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface CinemaShowsManager extends GenericManager<CinemaShows, Long> {
    
}