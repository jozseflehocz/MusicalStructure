package com.example.jlehocz.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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

        // Find the TextView in the layout with the ID artist_text_view
        TextView artistTextView = (TextView) findViewById(R.id.artist_text_view);
        // Get the version name from the current track object and
        // set this text on the artistTextView
        artistTextView.setText(artist);

        // Find the TextView in the list_item.xml layout with the ID album_text_view
        TextView albumTextView = (TextView) findViewById(R.id.album_text_view);
        // Get the album name from the current track object and
        // set this text on the albumTextView
        albumTextView.setText(album);

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView titleTextView = (TextView) findViewById(R.id.track_text_view);
        // Get the version number from the current track object and
        // set this text on the number TextView
        titleTextView.setText(title);

        // Find the TextView in the list_item.xml layout with the ID time_text_view
        TextView timeTextView = (TextView) findViewById(R.id.time_text_view);
        // Get the track time from the current track object and
        // set this text on the timeTextView
        timeTextView.setText(time);

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView coverView = (ImageView) findViewById(R.id.album_cover_image_view);
        // Get the image resource ID from the current track object and
        // set the image to iconView
        coverView.setImageResource(coverImgId);

        // Find the View that shows the colors category
        Button tracklistButton = (Button) findViewById(R.id.tracklist);

        // Set a click listener on that View
        tracklistButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the tracklistButton is clicked on.
            @Override
            public void onClick(View view) {
                Intent tracklistIntent = new Intent(NowPlayingActivity.this, TracklistActivity.class);
                startActivity(tracklistIntent);
            }
        });

    }
}
