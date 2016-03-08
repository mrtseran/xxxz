package com.techorin.cinema.webapp.controller;

import com.techorin.cinema.webapp.controller.BaseControllerTestCase;
import com.techorin.cinema.model.Cinemas;
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

public class CinemasFormControllerTest extends BaseControllerTestCase {
    @Autowired
    private CinemasFormController form;
    private Cinemas cinemas;
    private MockHttpServletRequest request;

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        request = newGet("/cinemasform");
        request.addParameter("id", "-1");

        cinemas = form.showForm(request);
        assertNotNull(cinemas);
    }

    @Test
    public void testSave() throws Exception {
        request = newGet("/cinemasform");
        request.addParameter("id", "-1");

        cinemas = form.showForm(request);
        assertNotNull(cinemas);

        request = newPost("/cinemasform");

        cinemas = form.showForm(request);
        // update required fields
        cinemas.setDisplayInHome(Boolean.FALSE);

        BindingResult errors = new DataBinder(cinemas).getBindingResult();
        form.onSubmit(cinemas, errors, request, new MockHttpServletResponse());
        assertFalse(errors.hasErrors());
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    @Test
    public void testRemove() throws Exception {
        request = newPost("/cinemasform");
        request.addParameter("delete", "");
        cinemas = new Cinemas();
        cinemas.setId(-2L);

        BindingResult errors = new DataBinder(cinemas).getBindingResult();
        form.onSubmit(cinemas, errors, request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}
