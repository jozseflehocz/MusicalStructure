package com.example.jlehocz.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing);

        Intent thisIntent = getIntent(); // gets the previously created intent
        String artist = thisIntent.getStringExtra("artist");
        String album= thisIntent.getStringExtra("album");
        String title = thisIntent.getStringExtra("title");
        String time= thisIntent.getStringExtra("time");

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

    }
}
