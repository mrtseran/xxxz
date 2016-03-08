package com.techorin.cinema.webapp.controller;

import org.apache.commons.lang.StringUtils;
import com.techorin.cinema.service.FilmGalleriesManager;
import com.techorin.cinema.model.FilmGalleries;
import com.techorin.cinema.webapp.controller.BaseFormController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
@RequestMapping("/filmGalleriesform*")
public class FilmGalleriesFormController extends BaseFormController {
    private FilmGalleriesManager filmGalleriesManager = null;

    @Autowired
    public void setFilmGalleriesManager(FilmGalleriesManager filmGalleriesManager) {
        this.filmGalleriesManager = filmGalleriesManager;
    }

    public FilmGalleriesFormController() {
        setCancelView("redirect:filmGalleriess");
        setSuccessView("redirect:filmGalleriess");
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected FilmGalleries showForm(HttpServletRequest request)
    {
    /*throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return filmGalleriesManager.get(new Long(id));
        }*/

        return new FilmGalleries();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(FilmGalleries filmGalleries, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        if (validator != null) { // validator is null during testing
            validator.validate(filmGalleries, errors);

            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "filmGalleriesform";
            }
        }

        log.debug("entering 'onSubmit' method...");

        boolean isNew = (filmGalleries.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            filmGalleriesManager.remove(filmGalleries.getId());
            saveMessage(request, getText("filmGalleries.deleted", locale));
        } else {
            filmGalleriesManager.save(filmGalleries);
            String key = (isNew) ? "filmGalleries.added" : "filmGalleries.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:filmGalleriesform?id=" + filmGalleries.getId();
            }
        }

        return success;
    }
}
