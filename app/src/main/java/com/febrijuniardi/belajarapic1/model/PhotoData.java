package com.febrijuniardi.belajarapic1.model;

import com.google.gson.annotations.SerializedName;

public class PhotoData {
    @SerializedName("albumID")
    private Integer albumId;
    @SerializedName("id")
    private Integer id;
    @SerializedName("title")
    private String title;
    @SerializedName("url")
    private String url;
    @SerializedName("thumbnailurl")
    private String thumbnailUrl;

    public PhotoData(Integer albumId , Integer id , String title , String url , String thumbnailUrl ){
        this.albumId = albumId;
        this.id     = id;
        this.title = title;
        this.url    = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}
