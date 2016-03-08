package com.techorin.cinema.dao.hibernate;

import com.techorin.cinema.model.FilmGalleries;
import com.techorin.cinema.dao.FilmGalleriesDao;
import com.techorin.cinema.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("filmGalleriesDao")
public class FilmGalleriesDaoHibernate extends GenericDaoHibernate<FilmGalleries, Long> implements FilmGalleriesDao {

    public FilmGalleriesDaoHibernate() {
        super(FilmGalleries.class);
    }
}
