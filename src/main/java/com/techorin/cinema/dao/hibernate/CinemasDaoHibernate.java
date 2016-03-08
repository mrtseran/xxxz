package com.techorin.cinema.dao.hibernate;

import com.techorin.cinema.model.Cinemas;
import com.techorin.cinema.dao.CinemasDao;
import com.techorin.cinema.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("cinemasDao")
public class CinemasDaoHibernate extends GenericDaoHibernate<Cinemas, Long> implements CinemasDao {

    public CinemasDaoHibernate() {
        super(Cinemas.class);
    }
}
