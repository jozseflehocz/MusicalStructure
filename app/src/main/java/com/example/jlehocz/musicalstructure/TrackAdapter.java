package com.example.jlehocz.musicalstructure;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/* source reused
* https://github.com/udacity/ud839_CustomAdapter_Example/blob/master/app/src/main/java/com/example/android/flavor/trackAdapter.java
* 
* */

public class TrackAdapter extends ArrayAdapter<Track> {

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param tracks A List of track objects to display in a list
     */
    public TrackAdapter(Activity context, ArrayList<Track> tracks) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, tracks);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the currentTrack object located at this position in the list
        Track currentTrack = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID artist_text_view
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artist_text_view);
        // Get the artist from the current track object and
        // set this text on the name TextView
        artistTextView.setText(currentTrack.getmArtist());

        // Find the TextView in the list_item.xml layout with the ID album_text_view
        TextView albumTextView = (TextView) listItemView.findViewById(R.id.album_text_view);
        // Get the album from the current track object and
        // set this text on the number TextView
        albumTextView.setText(currentTrack.getmAlbum());

        // Find the TextView in the list_item.xml layout with the ID track_text_view
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.track_text_view);
        // Get the track from the current track object and
        // set this text on the number TextView
        titleTextView.setText(currentTrack.getmTitle());

        // Find the TextView in the list_item.xml layout with the ID time_text_view
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time_text_view);
        // Get the vtime from the current track object and
        // set this text on the number TextView
        timeTextView.setText(currentTrack.getmTime());

        // Find the ImageView in the list_item.xml layout with the ID album_cover_image_view
        ImageView coverView = (ImageView) listItemView.findViewById(R.id.album_cover_image_view);
        // Get the image resource ID from the current track object and
        // set the image to track cover image
        coverView.setImageResource(currentTrack.getmCoverImgId());
        return listItemView;
    }
}
