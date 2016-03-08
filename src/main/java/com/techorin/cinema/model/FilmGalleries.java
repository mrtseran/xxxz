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
@Table(name="film_galleries",catalog="todaycinema")
@Indexed
@XmlRootElement
public class FilmGalleries extends BaseObject implements Serializable {
	private static final long serialVersionUID = 6718074317526220760L;
	private Long id;
    private Films films;
    private String imageName;
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
    
    @Column(name="image_name", nullable=false, columnDefinition = "VARCHAR(254)")
    @Field
    public String getImageName() {
        return this.imageName;
    }
    
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created", nullable=false, length=19)
    @Field
    public Date getCreated() {
        return this.created;
    }
    
    public void setCreated(Date created) {
        this.created = created;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="modified", nullable=false, length=19)
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

        FilmGalleries pojo = (FilmGalleries) o;

        if (films != null ? !films.equals(pojo.films) : pojo.films != null) return false;
        if (imageName != null ? !imageName.equals(pojo.imageName) : pojo.imageName != null) return false;
        if (created != null ? !created.equals(pojo.created) : pojo.created != null) return false;
        if (modified != null ? !modified.equals(pojo.modified) : pojo.modified != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (films != null ? films.hashCode() : 0);
        result = 31 * result + (imageName != null ? imageName.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (modified != null ? modified.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("id").append("='").append(getId()).append("', ");
        sb.append("films").append("='").append(getFilms()).append("', ");
        sb.append("imageName").append("='").append(getImageName()).append("', ");
        sb.append("created").append("='").append(getCreated()).append("', ");
        sb.append("modified").append("='").append(getModified()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
