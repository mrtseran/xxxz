package com.techorin.cinema.webapp.controller;

import org.apache.commons.lang.StringUtils;
import com.techorin.cinema.service.CinemasManager;
import com.techorin.cinema.model.Cinemas;
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
@RequestMapping("/cinemasform*")
public class CinemasFormController extends BaseFormController {
    private CinemasManager cinemasManager = null;

    @Autowired
    public void setCinemasManager(CinemasManager cinemasManager) {
        this.cinemasManager = cinemasManager;
    }

    public CinemasFormController() {
        setCancelView("redirect:cinemass");
        setSuccessView("redirect:cinemass");
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Cinemas showForm(HttpServletRequest request)
    throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return cinemasManager.get(new Long(id));
        }

        return new Cinemas();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Cinemas cinemas, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        if (validator != null) { // validator is null during testing
            validator.validate(cinemas, errors);

            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "cinemasform";
            }
        }

        log.debug("entering 'onSubmit' method...");

        boolean isNew = (cinemas.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            cinemasManager.remove(cinemas.getId());
            saveMessage(request, getText("cinemas.deleted", locale));
        } else {
            cinemasManager.save(cinemas);
            String key = (isNew) ? "cinemas.added" : "cinemas.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:cinemasform?id=" + cinemas.getId();
            }
        }

        return success;
    }
}
