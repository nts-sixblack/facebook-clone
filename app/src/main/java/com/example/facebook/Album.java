package com.example.facebook;

public class Album {
    private int albumId;
    private String albumName;
    private int pictureNumber;
    private int thumbnailId;

    public Album(int albumId, String albumName, int pictureNumber, int thumbnailId) {
        this.albumId = albumId;
        this.albumName = albumName;
        this.pictureNumber = pictureNumber;
        this.thumbnailId = thumbnailId;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getPictureNumber() {
        return pictureNumber;
    }

    public void setPictureNumber(int pictureNumber) {
        this.pictureNumber = pictureNumber;
    }

    public int getThumbnailId() {
        return thumbnailId;
    }

    public void setThumbnailId(int thumbnailId) {
        this.thumbnailId = thumbnailId;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumName() {
        return albumName;
    }
}
