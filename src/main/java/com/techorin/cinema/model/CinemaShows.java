package com.techorin.cinema.model;

import com.techorin.cinema.model.BaseObject;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@Table(name="cinema_shows",catalog="todaycinema")
@Indexed
@XmlRootElement
public class CinemaShows extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6938307929141013936L;
	private Long id;
    private Films films;
    private Cinemas cinemas;
    private Date showTime;
    private String description;
    private Date created;
    private Date modified;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId    
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="films_id", nullable=false)
    public Films getFilms() {
        return this.films;
    }
    
    public void setFilms(Films films) {
        this.films = films;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cinemas_id", nullable=false)
    public Cinemas getCinemas() {
        return this.cinemas;
    }
    
    public void setCinemas(Cinemas cinemas) {
        this.cinemas = cinemas;
    }
    @Temporal(TemporalType.TIME)
    @Column(name="show_time", nullable=false, length=8)
    @Field
    public Date getShowTime() {
        return this.showTime;
    }
    
    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }
    
    @Column(name="description", columnDefinition = "TEXT")
    @Field
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created", length=19)
    @Field
    public Date getCreated() {
        return this.created;
    }
    
    public void setCreated(Date created) {
        this.created = created;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="modified", length=19)
    @Field
    public Date getModified() {
        return this.modified;
    }
    
    public void setModified(Date modified) {
        this.modified = modified;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CinemaShows pojo = (CinemaShows) o;

        if (films != null ? !films.equals(pojo.films) : pojo.films != null) return false;
        if (cinemas != null ? !cinemas.equals(pojo.cinemas) : pojo.cinemas != null) return false;
        if (showTime != null ? !showTime.equals(pojo.showTime) : pojo.showTime != null) return false;
        if (description != null ? !description.equals(pojo.description) : pojo.description != null) return false;
        if (created != null ? !created.equals(pojo.created) : pojo.created != null) return false;
        if (modified != null ? !modified.equals(pojo.modified) : pojo.modified != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (films != null ? films.hashCode() : 0);
        result = 31 * result + (cinemas != null ? cinemas.hashCode() : 0);
        result = 31 * result + (showTime != null ? showTime.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (modified != null ? modified.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("id").append("='").append(getId()).append("', ");
        sb.append("films").append("='").append(getFilms()).append("', ");
        sb.append("cinemas").append("='").append(getCinemas()).append("', ");
        sb.append("showTime").append("='").append(getShowTime()).append("', ");
        sb.append("description").append("='").append(getDescription()).append("', ");
        sb.append("created").append("='").append(getCreated()).append("', ");
        sb.append("modified").append("='").append(getModified()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
