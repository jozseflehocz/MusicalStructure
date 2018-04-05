package com.example.jlehocz.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class TracklistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.track_list);

        // Tracks stored in ArrayList
        ArrayList<Track> tracks = new ArrayList<>();

        //The repeated albuminfo stored in variables
        int coverImageId;
        String artistName;
        String albumTitle;

        //Setting track info variables
        coverImageId=R.drawable.the_moon_and_the_nightspirit_metanoia;
        artistName="The Moon And The Nightspirit";
        albumTitle="Of Dreams Forgotten and Fables Untold";

        // adding track to ArrayList using the variables
        tracks.add(new Track(artistName,albumTitle,"Egi Taltos","4:48",coverImageId));
        tracks.add(new Track(artistName,albumTitle,"Lullaby (The Final Gyre of Suns)","3:57",coverImageId));
        tracks.add(new Track(artistName,albumTitle,"Beloved Enchantress","3:16",coverImageId));
        tracks.add(new Track(artistName,albumTitle,"The Secret Path","5:53",coverImageId));
        tracks.add(new Track(artistName,albumTitle,"In Gardens of Worlds Undreamt","4:18",coverImageId));
        tracks.add(new Track(artistName,albumTitle,"Holdanyank","3:35",coverImageId));
        tracks.add(new Track(artistName,albumTitle,"Echo of Atlantis","3:31",coverImageId));
        tracks.add(new Track(artistName,albumTitle,"Pagan","5:02",coverImageId));
        tracks.add(new Track(artistName,albumTitle,"Of Dreams Forgotten and Fables Untold","3:55",coverImageId));

        // Create an {@link TrackAdapter}, whose data source is a list of {@link Track}s. The
        // adapter knows how to create list items for each item in the list.
        final TrackAdapter adapter = new TrackAdapter(this, tracks);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml file.
        final ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link TrackAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Track} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //The track to be played
                Track currentTrack = (Track)listView.getItemAtPosition(i);

                //Creating intent for now playing activity

                Intent nowPlayingIntent = new Intent(TracklistActivity.this, NowPlayingActivity.class);

                /**
                 * https://stackoverflow.com/questions/2405120/how-to-start-an-intent-by-passing-some-parameters-to-it
                 * adding track info as parameters to the intent
                 */
                nowPlayingIntent.putExtra("artist",currentTrack.getmArtist());
                nowPlayingIntent.putExtra("album",currentTrack.getmAlbum());
                nowPlayingIntent.putExtra("title",currentTrack.getmTitle());
                nowPlayingIntent.putExtra("time",currentTrack.getmTime());
                nowPlayingIntent.putExtra("coverImgId",currentTrack.getmCoverImgId());
                startActivity(nowPlayingIntent);
            }
        });
    }
}
