package com.techorin.cinema.webapp.controller;

import com.techorin.cinema.dao.SearchException;
import com.techorin.cinema.service.FilmCategoriesManager;
import com.techorin.cinema.model.FilmCategories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/filmCategoriess*")
public class FilmCategoriesController {
    private FilmCategoriesManager filmCategoriesManager;

    @Autowired
    public void setFilmCategoriesManager(FilmCategoriesManager filmCategoriesManager) {
        this.filmCategoriesManager = filmCategoriesManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Model handleRequest(@RequestParam(required = false, value = "q") String query)
    throws Exception {
        Model model = new ExtendedModelMap();
        try {
            model.addAttribute(filmCategoriesManager.search(query, FilmCategories.class));
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(filmCategoriesManager.getAll());
        }
        return model;
    }
}
