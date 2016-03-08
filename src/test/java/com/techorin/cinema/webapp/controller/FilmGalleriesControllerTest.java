package com.techorin.cinema.webapp.controller;

import com.techorin.cinema.service.FilmGalleriesManager;
import com.techorin.cinema.model.FilmGalleries;

import com.techorin.cinema.webapp.controller.BaseControllerTestCase;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.*;

public class FilmGalleriesControllerTest extends BaseControllerTestCase {
    @Autowired
    private FilmGalleriesController controller;

    @Test
    public void testHandleRequest() throws Exception {
        Model model = controller.handleRequest(null);
        Map m = model.asMap();
        assertNotNull(m.get("filmGalleriesList"));
        assertTrue(((List) m.get("filmGalleriesList")).size() > 0);
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        FilmGalleriesManager filmGalleriesManager = (FilmGalleriesManager) applicationContext.getBean("filmGalleriesManager");
        filmGalleriesManager.reindex();

        Model model = controller.handleRequest("*");
        Map m = model.asMap();
        List results = (List) m.get("filmGalleriesList");
        assertNotNull(results);
        assertEquals(3, results.size());
    }
}