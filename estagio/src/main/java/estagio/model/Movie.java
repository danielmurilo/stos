package estagio.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
@Table(name = "MOVIE")
public class Movie implements Serializable {
	
	@Id
    @GeneratedValue
    @Column(name = "MOVIE_ID")
    private long movieId;

    @Column(name = "MOVIE_TITLE", nullable = false)
    private String title;
    
    @Column(name = "MOVIE_DESCRIPTION", nullable = false, length = 255)
    private String description;

    @Lob
    @Column(name = "MOVIE_IMAGE", nullable = true, columnDefinition = "mediumblob")
    private byte[] image;
    
    @Transient
    private String imgTO64;
    
    private String link;
    
    //GETTERS AND SETTERS...
    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
    
    public void setImgTO64(String imgTO64) {
        this.imgTO64 = imgTO64;
    }

    public String getImgTO64() {
        return imgTO64;
    } 
    
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}






	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
