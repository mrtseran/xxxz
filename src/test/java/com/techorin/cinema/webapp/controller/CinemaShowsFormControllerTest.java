package com.techorin.cinema.webapp.controller;

import com.techorin.cinema.webapp.controller.BaseControllerTestCase;
import com.techorin.cinema.model.CinemaShows;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CinemaShowsFormControllerTest extends BaseControllerTestCase {
    @Autowired
    private CinemaShowsFormController form;
    private CinemaShows cinemaShows;
    private MockHttpServletRequest request;

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        request = newGet("/cinemaShowsform");
        request.addParameter("id", "-1");

        cinemaShows = form.showForm(request);
        assertNotNull(cinemaShows);
    }

    @Test
    public void testSave() throws Exception {
        request = newGet("/cinemaShowsform");
        request.addParameter("id", "-1");

        cinemaShows = form.showForm(request);
        assertNotNull(cinemaShows);

        request = newPost("/cinemaShowsform");

        cinemaShows = form.showForm(request);
        // update required fields
        cinemaShows.setShowTime(new java.util.Date());

        BindingResult errors = new DataBinder(cinemaShows).getBindingResult();
        form.onSubmit(cinemaShows, errors, request, new MockHttpServletResponse());
        assertFalse(errors.hasErrors());
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    @Test
    public void testRemove() throws Exception {
        request = newPost("/cinemaShowsform");
        request.addParameter("delete", "");
        cinemaShows = new CinemaShows();
        cinemaShows.setId(-2L);

        BindingResult errors = new DataBinder(cinemaShows).getBindingResult();
        form.onSubmit(cinemaShows, errors, request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}
