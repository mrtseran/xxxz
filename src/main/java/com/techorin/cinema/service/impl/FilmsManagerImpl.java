package com.techorin.cinema.service.impl;

import com.techorin.cinema.dao.FilmsDao;
import com.techorin.cinema.model.Films;
import com.techorin.cinema.service.FilmsManager;
import com.techorin.cinema.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("filmsManager")
@WebService(serviceName = "FilmsService", endpointInterface = "com.techorin.cinema.service.FilmsManager")
public class FilmsManagerImpl extends GenericManagerImpl<Films, Long> implements FilmsManager {
    FilmsDao filmsDao;

    @Autowired
    public FilmsManagerImpl(FilmsDao filmsDao) {
        super(filmsDao);
        this.filmsDao = filmsDao;
    }
}