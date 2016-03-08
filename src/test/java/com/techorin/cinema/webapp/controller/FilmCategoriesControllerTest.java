package com.techorin.cinema.webapp.controller;

import com.techorin.cinema.service.FilmCategoriesManager;
import com.techorin.cinema.model.FilmCategories;

import com.techorin.cinema.webapp.controller.BaseControllerTestCase;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.*;

public class FilmCategoriesControllerTest extends BaseControllerTestCase {
    @Autowired
    private FilmCategoriesController controller;

    @Test
    public void testHandleRequest() throws Exception {
        Model model = controller.handleRequest(null);
        Map m = model.asMap();
        assertNotNull(m.get("filmCategoriesList"));
        assertTrue(((List) m.get("filmCategoriesList")).size() > 0);
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        FilmCategoriesManager filmCategoriesManager = (FilmCategoriesManager) applicationContext.getBean("filmCategoriesManager");
        filmCategoriesManager.reindex();

        Model model = controller.handleRequest("*");
        Map m = model.asMap();
        List results = (List) m.get("filmCategoriesList");
        assertNotNull(results);
        assertEquals(3, results.size());
    }
}