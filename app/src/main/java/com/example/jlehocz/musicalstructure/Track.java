package com.example.jlehocz.musicalstructure;

/**
 *
 */

public class Track {

    private String mArtist;
    private String mAlbum;
    private String mTitle;
    private String mTime;
    // Drawable resource ID
    private int mCoverImgId;

    public Track(String artist, String album, String title, String time, int coverImgId) {
        mArtist = artist;
        mAlbum = album;
        mTitle = title;
        mTime = time;
        mCoverImgId = coverImgId;
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

    public int getmCoverImgId() {
        return mCoverImgId;
    }
}
