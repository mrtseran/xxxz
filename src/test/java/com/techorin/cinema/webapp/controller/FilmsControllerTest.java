package com.techorin.cinema.webapp.controller;

import com.techorin.cinema.service.FilmsManager;
import com.techorin.cinema.model.Films;

import com.techorin.cinema.webapp.controller.BaseControllerTestCase;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.*;

public class FilmsControllerTest extends BaseControllerTestCase {
    @Autowired
    private FilmsController controller;

    @Test
    public void testHandleRequest() throws Exception {
        Model model = controller.handleRequest(null);
        Map m = model.asMap();
        assertNotNull(m.get("filmsList"));
        assertTrue(((List) m.get("filmsList")).size() > 0);
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        FilmsManager filmsManager = (FilmsManager) applicationContext.getBean("filmsManager");
        filmsManager.reindex();

        Model model = controller.handleRequest("*");
        Map m = model.asMap();
        List results = (List) m.get("filmsList");
        assertNotNull(results);
        assertEquals(3, results.size());
    }
}