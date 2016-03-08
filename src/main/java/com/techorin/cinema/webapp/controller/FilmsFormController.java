package com.techorin.cinema.webapp.controller;

import org.apache.commons.lang.StringUtils;
import com.techorin.cinema.service.FilmsManager;
import com.techorin.cinema.model.Films;
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
@RequestMapping("/filmsform*")
public class FilmsFormController extends BaseFormController {
    private FilmsManager filmsManager = null;

    @Autowired
    public void setFilmsManager(FilmsManager filmsManager) {
        this.filmsManager = filmsManager;
    }

    public FilmsFormController() {
        setCancelView("redirect:filmss");
        setSuccessView("redirect:filmss");
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Films showForm(HttpServletRequest request)
    throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return filmsManager.get(new Long(id));
        }

        return new Films();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Films films, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        if (validator != null) { // validator is null during testing
            validator.validate(films, errors);

            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "filmsform";
            }
        }

        log.debug("entering 'onSubmit' method...");

        boolean isNew = (films.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            filmsManager.remove(films.getId());
            saveMessage(request, getText("films.deleted", locale));
        } else {
            filmsManager.save(films);
            String key = (isNew) ? "films.added" : "films.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:filmsform?id=" + films.getId();
            }
        }

        return success;
    }
}
