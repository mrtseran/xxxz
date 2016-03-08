package com.techorin.cinema.webapp.controller;

import com.techorin.cinema.dao.SearchException;
import com.techorin.cinema.service.FilmGalleriesManager;
import com.techorin.cinema.model.FilmGalleries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/filmGalleriess*")
public class FilmGalleriesController {
    private FilmGalleriesManager filmGalleriesManager;

    @Autowired
    public void setFilmGalleriesManager(FilmGalleriesManager filmGalleriesManager) {
        this.filmGalleriesManager = filmGalleriesManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Model handleRequest(@RequestParam(required = false, value = "q") String query)
    throws Exception {
        Model model = new ExtendedModelMap();
        try {
            model.addAttribute(filmGalleriesManager.search(query, FilmGalleries.class));
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(filmGalleriesManager.getAll());
        }
        return model;
    }
}
