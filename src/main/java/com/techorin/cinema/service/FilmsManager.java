package com.techorin.cinema.service;

import com.techorin.cinema.service.GenericManager;
import com.techorin.cinema.model.Films;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface FilmsManager extends GenericManager<Films, Long> {
    
}