package com.techorin.cinema.webapp.controller;

import com.techorin.cinema.webapp.controller.BaseControllerTestCase;
import com.techorin.cinema.model.Films;
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

public class FilmsFormControllerTest extends BaseControllerTestCase {
    @Autowired
    private FilmsFormController form;
    private Films films;
    private MockHttpServletRequest request;

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        request = newGet("/filmsform");
        request.addParameter("id", "-1");

        films = form.showForm(request);
        assertNotNull(films);
    }

    @Test
    public void testSave() throws Exception {
        request = newGet("/filmsform");
        request.addParameter("id", "-1");

        films = form.showForm(request);
        assertNotNull(films);

        request = newPost("/filmsform");

        films = form.showForm(request);
        // update required fields

        BindingResult errors = new DataBinder(films).getBindingResult();
        form.onSubmit(films, errors, request, new MockHttpServletResponse());
        assertFalse(errors.hasErrors());
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    @Test
    public void testRemove() throws Exception {
        request = newPost("/filmsform");
        request.addParameter("delete", "");
        films = new Films();
        films.setId(-2L);

        BindingResult errors = new DataBinder(films).getBindingResult();
        form.onSubmit(films, errors, request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}
