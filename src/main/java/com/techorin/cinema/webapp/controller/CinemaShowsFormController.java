package com.techorin.cinema.webapp.controller;

import org.apache.commons.lang.StringUtils;
import com.techorin.cinema.service.CinemaShowsManager;
import com.techorin.cinema.model.CinemaShows;
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
@RequestMapping("/cinemaShowsform*")
public class CinemaShowsFormController extends BaseFormController {
    private CinemaShowsManager cinemaShowsManager = null;

    @Autowired
    public void setCinemaShowsManager(CinemaShowsManager cinemaShowsManager) {
        this.cinemaShowsManager = cinemaShowsManager;
    }

    public CinemaShowsFormController() {
        setCancelView("redirect:cinemaShowss");
        setSuccessView("redirect:cinemaShowss");
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected CinemaShows showForm(HttpServletRequest request)
    throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return cinemaShowsManager.get(new Long(id));
        }

        return new CinemaShows();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(CinemaShows cinemaShows, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        if (validator != null) { // validator is null during testing
            validator.validate(cinemaShows, errors);

            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "cinemaShowsform";
            }
        }

        log.debug("entering 'onSubmit' method...");

        boolean isNew = (cinemaShows.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            cinemaShowsManager.remove(cinemaShows.getId());
            saveMessage(request, getText("cinemaShows.deleted", locale));
        } else {
            cinemaShowsManager.save(cinemaShows);
            String key = (isNew) ? "cinemaShows.added" : "cinemaShows.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:cinemaShowsform?id=" + cinemaShows.getId();
            }
        }

        return success;
    }
}
