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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@Table(name="cinemas",catalog="todaycinema")
@Indexed
@XmlRootElement
public class Cinemas extends BaseObject implements Serializable {
    private Long id;
    private String name;
    private String fileName;
    private String address;
    private String contactNumber;
    private String description;
    private String imageUrl;
    private boolean displayInHome;
    private Date created;
    private Date modified;
    private Set<CinemaShows> cinemaShowses = new HashSet<CinemaShows>(0);

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId    
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="name", columnDefinition = "VARCHAR(254)")
    @Field
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="file_name", columnDefinition = "VARCHAR(254)")
    @Field
    public String getFileName() {
        return this.fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    @Column(name="address")
    @Field
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    @Column(name="contact_number")
    @Field
    public String getContactNumber() {
        return this.contactNumber;
    }
    
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    
    @Column(name="description", columnDefinition = "TEXT")
    @Field
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column(name="image_url", columnDefinition = "VARCHAR(254)")
    @Field
    public String getImageUrl() {
        return this.imageUrl;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    @Column(name="display_in_home", nullable=false)
    @Field
    public boolean isDisplayInHome() {
        return this.displayInHome;
    }
    
    public void setDisplayInHome(boolean displayInHome) {
        this.displayInHome = displayInHome;
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
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="cinemas")
    public Set<CinemaShows> getCinemaShowses() {
        return this.cinemaShowses;
    }
    
    public void setCinemaShowses(Set<CinemaShows> cinemaShowses) {
        this.cinemaShowses = cinemaShowses;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cinemas pojo = (Cinemas) o;

        if (name != null ? !name.equals(pojo.name) : pojo.name != null) return false;
        if (fileName != null ? !fileName.equals(pojo.fileName) : pojo.fileName != null) return false;
        if (address != null ? !address.equals(pojo.address) : pojo.address != null) return false;
        if (contactNumber != null ? !contactNumber.equals(pojo.contactNumber) : pojo.contactNumber != null) return false;
        if (description != null ? !description.equals(pojo.description) : pojo.description != null) return false;
        if (imageUrl != null ? !imageUrl.equals(pojo.imageUrl) : pojo.imageUrl != null) return false;
        if (displayInHome != pojo.displayInHome) return false;
        if (created != null ? !created.equals(pojo.created) : pojo.created != null) return false;
        if (modified != null ? !modified.equals(pojo.modified) : pojo.modified != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (name != null ? name.hashCode() : 0);
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (contactNumber != null ? contactNumber.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (displayInHome ? 1 : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (modified != null ? modified.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("id").append("='").append(getId()).append("', ");
        sb.append("name").append("='").append(getName()).append("', ");
        sb.append("fileName").append("='").append(getFileName()).append("', ");
        sb.append("address").append("='").append(getAddress()).append("', ");
        sb.append("contactNumber").append("='").append(getContactNumber()).append("', ");
        sb.append("description").append("='").append(getDescription()).append("', ");
        sb.append("imageUrl").append("='").append(getImageUrl()).append("', ");
        sb.append("displayInHome").append("='").append(isDisplayInHome()).append("', ");
        sb.append("created").append("='").append(getCreated()).append("', ");
        sb.append("modified").append("='").append(getModified()).append("', ");
        
        sb.append("]");
      
        return sb.toString();
    }

}
