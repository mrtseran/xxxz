package com.techorin.cinema.dao.hibernate;

import com.techorin.cinema.model.Films;
import com.techorin.cinema.dao.FilmsDao;
import com.techorin.cinema.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("filmsDao")
public class FilmsDaoHibernate extends GenericDaoHibernate<Films, Long> implements FilmsDao {

    public FilmsDaoHibernate() {
        super(Films.class);
    }
}
