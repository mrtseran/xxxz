package com.techorin.cinema.webapp.controller;

import com.techorin.cinema.webapp.controller.BaseControllerTestCase;
import com.techorin.cinema.model.FilmCategories;
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

public class FilmCategoriesFormControllerTest extends BaseControllerTestCase {
    @Autowired
    private FilmCategoriesFormController form;
    private FilmCategories filmCategories;
    private MockHttpServletRequest request;

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        request = newGet("/filmCategoriesform");
        request.addParameter("id", "-1");

        filmCategories = form.showForm(request);
        assertNotNull(filmCategories);
    }

    @Test
    public void testSave() throws Exception {
        request = newGet("/filmCategoriesform");
        request.addParameter("id", "-1");

        filmCategories = form.showForm(request);
        assertNotNull(filmCategories);

        request = newPost("/filmCategoriesform");

        filmCategories = form.showForm(request);
        // update required fields

        BindingResult errors = new DataBinder(filmCategories).getBindingResult();
        form.onSubmit(filmCategories, errors, request, new MockHttpServletResponse());
        assertFalse(errors.hasErrors());
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    @Test
    public void testRemove() throws Exception {
        request = newPost("/filmCategoriesform");
        request.addParameter("delete", "");
        filmCategories = new FilmCategories();
        filmCategories.setId(-2L);

        BindingResult errors = new DataBinder(filmCategories).getBindingResult();
        form.onSubmit(filmCategories, errors, request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}
