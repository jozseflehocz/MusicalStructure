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

public class ArtistsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.track_list);

        // Create a list of tracks
        ArrayList<Track> tracks = new ArrayList<Track>();

        tracks.add(new Track("The Moon And The Nightspirit","Of Dreams Forgotten and Fables Untold","Egi Taltos","4:48"));
        tracks.add(new Track("The Moon And The Nightspirit","Of Dreams Forgotten and Fables Untold","Lullaby (The Final Gyre of Suns)","3:57"));
        tracks.add(new Track("The Moon And The Nightspirit","Of Dreams Forgotten and Fables Untold","Beloved Enchantress","3:16"));
        tracks.add(new Track("The Moon And The Nightspirit","Of Dreams Forgotten and Fables Untold","The Secret Path","5:53"));
        tracks.add(new Track("The Moon And The Nightspirit","Of Dreams Forgotten and Fables Untold","In Gardens of Worlds Undreamt","4:18"));
        tracks.add(new Track("The Moon And The Nightspirit","Of Dreams Forgotten and Fables Untold","Holdanyank","3:35"));
        tracks.add(new Track("The Moon And The Nightspirit","Of Dreams Forgotten and Fables Untold","Echo of Atlantis","3:31"));
        tracks.add(new Track("The Moon And The Nightspirit","Of Dreams Forgotten and Fables Untold","Pagan","5:02"));
        tracks.add(new Track("The Moon And The Nightspirit","Of Dreams Forgotten and Fables Untold","Of Dreams Forgotten and Fables Untold","3:55"));

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

                Track currentTrack = (Track)listView.getItemAtPosition(i);
                String s=currentTrack.getmArtist()+"\n\n"+currentTrack.getmAlbum();

                //Display toast
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.custom_toast,
                        (ViewGroup) findViewById(R.id.custom_toast_container));
                TextView text = (TextView) layout.findViewById(R.id.text);
                text.setText(s);
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();

                Intent nowPlayingIntent = new Intent(ArtistsActivity.this, NowPlayingActivity.class);

                /**
                 * https://stackoverflow.com/questions/2405120/how-to-start-an-intent-by-passing-some-parameters-to-it
                 */
                nowPlayingIntent.putExtra("artist",currentTrack.getmArtist());
                nowPlayingIntent.putExtra("album",currentTrack.getmAlbum());
                nowPlayingIntent.putExtra("title",currentTrack.getmTitle());
                nowPlayingIntent.putExtra("time",currentTrack.getmTime());

                startActivity(nowPlayingIntent);
            }
        });


    }
}
