package com.techorin.cinema.webapp.controller;

import com.techorin.cinema.dao.SearchException;
import com.techorin.cinema.service.CinemaShowsManager;
import com.techorin.cinema.model.CinemaShows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cinemaShowss*")
public class CinemaShowsController {
    private CinemaShowsManager cinemaShowsManager;

    @Autowired
    public void setCinemaShowsManager(CinemaShowsManager cinemaShowsManager) {
        this.cinemaShowsManager = cinemaShowsManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Model handleRequest(@RequestParam(required = false, value = "q") String query)
    throws Exception {
        Model model = new ExtendedModelMap();
        try {
            model.addAttribute(cinemaShowsManager.search(query, CinemaShows.class));
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(cinemaShowsManager.getAll());
        }
        return model;
    }
}
