package com.techorin.cinema.dao.hibernate;

import com.techorin.cinema.model.FilmCategories;
import com.techorin.cinema.dao.FilmCategoriesDao;
import com.techorin.cinema.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("filmCategoriesDao")
public class FilmCategoriesDaoHibernate extends GenericDaoHibernate<FilmCategories, Long> implements FilmCategoriesDao {

    public FilmCategoriesDaoHibernate() {
        super(FilmCategories.class);
    }
}
