package com.example.jlehocz.musicalstructure;

/**
 *
 */

public class Track {

    private String mArtist;
    private String mAlbum;
    private String mTitle;
    private String mTime;

    public Track(String artist, String album, String title, String time) {
        mArtist = artist;
        mAlbum=album;
        mTitle = title;
        mTime =time;
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
}
