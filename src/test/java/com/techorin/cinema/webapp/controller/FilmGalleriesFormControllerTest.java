package com.techorin.cinema.webapp.controller;

import com.techorin.cinema.webapp.controller.BaseControllerTestCase;
import com.techorin.cinema.model.FilmGalleries;
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

public class FilmGalleriesFormControllerTest extends BaseControllerTestCase {
    @Autowired
    private FilmGalleriesFormController form;
    private FilmGalleries filmGalleries;
    private MockHttpServletRequest request;

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        request = newGet("/filmGalleriesform");
        request.addParameter("id", "-1");

        filmGalleries = form.showForm(request);
        assertNotNull(filmGalleries);
    }

    @Test
    public void testSave() throws Exception {
        request = newGet("/filmGalleriesform");
        request.addParameter("id", "-1");

        filmGalleries = form.showForm(request);
        assertNotNull(filmGalleries);

        request = newPost("/filmGalleriesform");

        filmGalleries = form.showForm(request);
        // update required fields
        filmGalleries.setCreated(new java.util.Date());
        filmGalleries.setImageName("YuQzJbUxQmLrTbUlDiPjFjJnLsBaZrLkIdZxUuKgQsUiKzTaUuLuZzJaMkLgHqZoZmAkNcEnDlYcCmAxBfBgIgEjZiGqBiErHdKkZlZgJjVpJwKmXwTpKeHlPeIdZhMaYwIzArHqNgTdSfFkDvNiXuBvHfKmZvTzBaZxIrRjPpRuAvYvJzQaPzFqHyYlPlVkBvGcYsOiKhFhFzAxDtQeYwVoKlWaWvLeZxSlAqCvAeKtFtWoJqEzEhJfKgUaItM");
        filmGalleries.setModified(new java.util.Date());

        BindingResult errors = new DataBinder(filmGalleries).getBindingResult();
        form.onSubmit(filmGalleries, errors, request, new MockHttpServletResponse());
        assertFalse(errors.hasErrors());
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    @Test
    public void testRemove() throws Exception {
        request = newPost("/filmGalleriesform");
        request.addParameter("delete", "");
        filmGalleries = new FilmGalleries();
        filmGalleries.setId(-2L);

        BindingResult errors = new DataBinder(filmGalleries).getBindingResult();
        form.onSubmit(filmGalleries, errors, request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}
