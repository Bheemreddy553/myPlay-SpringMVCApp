package com.reddy.my_show.server.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Target;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

/**
 * Created by varshini on 1/10/15.
 */
@Entity
@Table(name = "videos")
public class Video {

   @Id
   @Column(name = "id")
   private String id;
   private String title;
   private String video_url;
   private String video_path;
   private String description;
   private String uploadedDate;

   @ManyToOne(fetch = FetchType.EAGER)
   private UserDetails userDetails;

   public void generate(){
        this.id =this.userDetails.getEmail() + this.title + System.currentTimeMillis();
   }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return video_url;
    }

    public void setUrl(String url) {
        this.video_url = url;
    }

    public String getPath() {
        return video_path;
    }

    public void setPath(String path) {
        this.video_path = path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUploadedDate() {
        return uploadedDate;
    }

    public void setUploadedDate(String uploadedDate) {
        this.uploadedDate = uploadedDate;
    }

    @ManyToOne
    @Target(UserDetails.class)
    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
}
