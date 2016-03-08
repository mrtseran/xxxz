package com.techorin.cinema.webapp.controller;

import com.techorin.cinema.dao.SearchException;
import com.techorin.cinema.service.FilmsManager;
import com.techorin.cinema.model.Films;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/filmss*")
public class FilmsController {
    private FilmsManager filmsManager;

    @Autowired
    public void setFilmsManager(FilmsManager filmsManager) {
        this.filmsManager = filmsManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Model handleRequest(@RequestParam(required = false, value = "q") String query)
    throws Exception {
        Model model = new ExtendedModelMap();
        try {
            model.addAttribute(filmsManager.search(query, Films.class));
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(filmsManager.getAll());
        }
        return model;
    }
}
