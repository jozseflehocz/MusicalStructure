package com.example.jlehocz.musicalstructure;

/**
 *
 */

public class Track {

    private String mArtist;
    private String mAlbum;
    private String mTitle;
    private String mTime;
    private String mCover;
    private int mYear;
    private String mGenre;

    public Track(String artist, String album, String title, String time,String cover,int year,String genre) {
        mArtist = artist;
        mAlbum=album;
        mTitle = title;
        mTime =time;
        mCover=cover;
        mYear=year;
        mGenre=genre;
    }

    public String getmArtist() {
        return mArtist;
    }
    public String getmAlbum() {
        return mAlbum;
    }
    public String getmTitle() {
        return mTitle;
    }
    public String getmTime() {
        return mTime;
    }
    public String getmCover() {
        return mCover;
    }
    public int getmYear() {
        return mYear;
    }
    public String getmGenre() {
        return mGenre;
    }
}
