package com.techorin.cinema.webapp.controller;

import org.apache.commons.lang.StringUtils;
import com.techorin.cinema.service.FilmCategoriesManager;
import com.techorin.cinema.model.FilmCategories;
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
@RequestMapping("/filmCategoriesform*")
public class FilmCategoriesFormController extends BaseFormController {
    private FilmCategoriesManager filmCategoriesManager = null;

    @Autowired
    public void setFilmCategoriesManager(FilmCategoriesManager filmCategoriesManager) {
        this.filmCategoriesManager = filmCategoriesManager;
    }

    public FilmCategoriesFormController() {
        setCancelView("redirect:filmCategoriess");
        setSuccessView("redirect:filmCategoriess");
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected FilmCategories showForm(HttpServletRequest request)
    throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return filmCategoriesManager.get(new Long(id));
        }

        return new FilmCategories();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(FilmCategories filmCategories, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        if (validator != null) { // validator is null during testing
            validator.validate(filmCategories, errors);

            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "filmCategoriesform";
            }
        }

        log.debug("entering 'onSubmit' method...");

        boolean isNew = (filmCategories.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            filmCategoriesManager.remove(filmCategories.getId());
            saveMessage(request, getText("filmCategories.deleted", locale));
        } else {
            filmCategoriesManager.save(filmCategories);
            String key = (isNew) ? "filmCategories.added" : "filmCategories.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:filmCategoriesform?id=" + filmCategories.getId();
            }
        }

        return success;
    }
}
