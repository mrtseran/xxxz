package com.techorin.cinema.service.impl;

import com.techorin.cinema.dao.CinemasDao;
import com.techorin.cinema.model.Cinemas;
import com.techorin.cinema.service.CinemasManager;
import com.techorin.cinema.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("cinemasManager")
@WebService(serviceName = "CinemasService", endpointInterface = "com.techorin.cinema.service.CinemasManager")
public class CinemasManagerImpl extends GenericManagerImpl<Cinemas, Long> implements CinemasManager {
    CinemasDao cinemasDao;

    @Autowired
    public CinemasManagerImpl(CinemasDao cinemasDao) {
        super(cinemasDao);
        this.cinemasDao = cinemasDao;
    }
}