package com.techorin.cinema.service;

import com.techorin.cinema.service.GenericManager;
import com.techorin.cinema.model.Cinemas;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface CinemasManager extends GenericManager<Cinemas, Long> {
    
}