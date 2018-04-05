package com.example.jlehocz.musicalstructure;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/*
* https://github.com/udacity/ud839_CustomAdapter_Example/blob/master/app/src/main/java/com/example/android/flavor/AndroidFlavorAdapter.java
* {@link AndroidFlavorAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
* based on a data source, which is a list of {@link AndroidFlavor} objects.
* */

public class TrackAdapter extends ArrayAdapter<Track> {

    //private static final String LOG_TAG = WordAdapter.class.getSimpleName();

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param tracks A List of word objects to display in a list
     */
    public TrackAdapter(Activity context, ArrayList<Track> tracks) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
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

        // Get the {@link AndroidFlavor} object located at this position in the list
        Track currentTrack = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artist_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        artistTextView.setText(currentTrack.getmArtist());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView albumTextView = (TextView) listItemView.findViewById(R.id.album_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        albumTextView.setText(currentTrack.getmAlbum());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.track_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        titleTextView.setText(currentTrack.getmTitle());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        timeTextView.setText(currentTrack.getmTime());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView coverView = (ImageView) listItemView.findViewById(R.id.album_cover_image_view);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        coverView.setImageResource(currentTrack.getmCoverImgId());
        return listItemView;
    }
}
