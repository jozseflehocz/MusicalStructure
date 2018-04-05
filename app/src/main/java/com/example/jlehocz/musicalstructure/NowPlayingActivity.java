package com.example.jlehocz.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing);

        Intent thisIntent = getIntent(); // gets the previously created intent

        //Setting track attributes from intent parameters
        String artist = thisIntent.getStringExtra("artist");
        String album= thisIntent.getStringExtra("album");
        String title = thisIntent.getStringExtra("title");
        String time= thisIntent.getStringExtra("time");
        int coverImgId=thisIntent.getIntExtra("coverImgId",R.drawable.the_moon_and_the_nightspirit_metanoia);

        //replace android label "Now playing" to the title of the track
        setTitle(title);

        // Find the TextView in the layout with the ID version_name
        TextView artistTextView = (TextView) findViewById(R.id.artist_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        artistTextView.setText(artist);

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView albumTextView = (TextView) findViewById(R.id.album_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        albumTextView.setText(album);

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView titleTextView = (TextView) findViewById(R.id.track_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        titleTextView.setText(title);

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView timeTextView = (TextView) findViewById(R.id.time_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        timeTextView.setText(time);

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView coverView = (ImageView) findViewById(R.id.album_cover_image_view);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        coverView.setImageResource(coverImgId);

    }
}
