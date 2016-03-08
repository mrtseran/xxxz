package com.techorin.cinema.webapp.controller;

import com.techorin.cinema.service.CinemaShowsManager;
import com.techorin.cinema.model.CinemaShows;

import com.techorin.cinema.webapp.controller.BaseControllerTestCase;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.*;

public class CinemaShowsControllerTest extends BaseControllerTestCase {
    @Autowired
    private CinemaShowsController controller;

    @Test
    public void testHandleRequest() throws Exception {
        Model model = controller.handleRequest(null);
        Map m = model.asMap();
        assertNotNull(m.get("cinemaShowsList"));
        assertTrue(((List) m.get("cinemaShowsList")).size() > 0);
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        CinemaShowsManager cinemaShowsManager = (CinemaShowsManager) applicationContext.getBean("cinemaShowsManager");
        cinemaShowsManager.reindex();

        Model model = controller.handleRequest("*");
        Map m = model.asMap();
        List results = (List) m.get("cinemaShowsList");
        assertNotNull(results);
        assertEquals(3, results.size());
    }
}