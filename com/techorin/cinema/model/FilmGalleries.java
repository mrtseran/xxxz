package com.techorin.cinema.model;

import com.techorin.cinema.model.BaseObject;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
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
    private Long id;
    private Long filmId;
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
    
    @Column(name="film_id", nullable=false)
    @Field
    public Long getFilmId() {
        return this.filmId;
    }
    
    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }
    
    @Column(name="image_name", nullable=false)
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

        if (filmId != null ? !filmId.equals(pojo.filmId) : pojo.filmId != null) return false;
        if (imageName != null ? !imageName.equals(pojo.imageName) : pojo.imageName != null) return false;
        if (created != null ? !created.equals(pojo.created) : pojo.created != null) return false;
        if (modified != null ? !modified.equals(pojo.modified) : pojo.modified != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (filmId != null ? filmId.hashCode() : 0);
        result = 31 * result + (imageName != null ? imageName.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (modified != null ? modified.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("id").append("='").append(getId()).append("', ");
        sb.append("filmId").append("='").append(getFilmId()).append("', ");
        sb.append("imageName").append("='").append(getImageName()).append("', ");
        sb.append("created").append("='").append(getCreated()).append("', ");
        sb.append("modified").append("='").append(getModified()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
