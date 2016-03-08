package com.techorin.cinema.dao.hibernate;

import com.techorin.cinema.model.CinemaShows;
import com.techorin.cinema.dao.CinemaShowsDao;
import com.techorin.cinema.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("cinemaShowsDao")
public class CinemaShowsDaoHibernate extends GenericDaoHibernate<CinemaShows, Long> implements CinemaShowsDao {

    public CinemaShowsDaoHibernate() {
        super(CinemaShows.class);
    }
}
