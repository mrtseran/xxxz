package com.techorin.cinema.model;

import com.techorin.cinema.model.BaseObject;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@Table(name="films",catalog="todaycinema")
@Indexed
@XmlRootElement
public class Films extends BaseObject implements Serializable {
    private Long id;
    private FilmCategories filmCategories;
    private String name;
    private String starring;
    private String directedBy;
    private String musicBy;
    private String description;
    private String imageUrl;
    private Date created;
    private Date modified;
    private Set<CinemaShows> cinemaShowses = new HashSet<CinemaShows>(0);
    private Set<FilmGalleries> filmGallerieses = new HashSet<FilmGalleries>(0);

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId    
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="film_categories_id", nullable=false)
    public FilmCategories getFilmCategories() {
        return this.filmCategories;
    }
    
    public void setFilmCategories(FilmCategories filmCategories) {
        this.filmCategories = filmCategories;
    }
    
    @Column(name="name", columnDefinition = "VARCHAR(254)")
    @Field
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="starring", columnDefinition = "VARCHAR(254)")
    @Field
    public String getStarring() {
        return this.starring;
    }
    
    public void setStarring(String starring) {
        this.starring = starring;
    }
    
    @Column(name="directed_by", columnDefinition = "VARCHAR(254)")
    @Field
    public String getDirectedBy() {
        return this.directedBy;
    }
    
    public void setDirectedBy(String directedBy) {
        this.directedBy = directedBy;
    }
    
    @Column(name="music_by")
    @Field
    public String getMusicBy() {
        return this.musicBy;
    }
    
    public void setMusicBy(String musicBy) {
        this.musicBy = musicBy;
    }
    
    @Column(name="description", columnDefinition = "TEXT")
    @Field
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column(name="image_url")
    @Field
    public String getImageUrl() {
        return this.imageUrl;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="films")
    public Set<CinemaShows> getCinemaShowses() {
        return this.cinemaShowses;
    }
    
    public void setCinemaShowses(Set<CinemaShows> cinemaShowses) {
        this.cinemaShowses = cinemaShowses;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="films")
    public Set<FilmGalleries> getFilmGallerieses() {
        return this.filmGallerieses;
    }
    
    public void setFilmGallerieses(Set<FilmGalleries> filmGallerieses) {
        this.filmGallerieses = filmGallerieses;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Films pojo = (Films) o;

        if (filmCategories != null ? !filmCategories.equals(pojo.filmCategories) : pojo.filmCategories != null) return false;
        if (name != null ? !name.equals(pojo.name) : pojo.name != null) return false;
        if (starring != null ? !starring.equals(pojo.starring) : pojo.starring != null) return false;
        if (directedBy != null ? !directedBy.equals(pojo.directedBy) : pojo.directedBy != null) return false;
        if (musicBy != null ? !musicBy.equals(pojo.musicBy) : pojo.musicBy != null) return false;
        if (description != null ? !description.equals(pojo.description) : pojo.description != null) return false;
        if (imageUrl != null ? !imageUrl.equals(pojo.imageUrl) : pojo.imageUrl != null) return false;
        if (created != null ? !created.equals(pojo.created) : pojo.created != null) return false;
        if (modified != null ? !modified.equals(pojo.modified) : pojo.modified != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (filmCategories != null ? filmCategories.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (starring != null ? starring.hashCode() : 0);
        result = 31 * result + (directedBy != null ? directedBy.hashCode() : 0);
        result = 31 * result + (musicBy != null ? musicBy.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (modified != null ? modified.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("id").append("='").append(getId()).append("', ");
        sb.append("filmCategories").append("='").append(getFilmCategories()).append("', ");
        sb.append("name").append("='").append(getName()).append("', ");
        sb.append("starring").append("='").append(getStarring()).append("', ");
        sb.append("directedBy").append("='").append(getDirectedBy()).append("', ");
        sb.append("musicBy").append("='").append(getMusicBy()).append("', ");
        sb.append("description").append("='").append(getDescription()).append("', ");
        sb.append("imageUrl").append("='").append(getImageUrl()).append("', ");
        sb.append("created").append("='").append(getCreated()).append("', ");
        sb.append("modified").append("='").append(getModified()).append("', ");
        
        
        sb.append("]");
      
        return sb.toString();
    }

}
