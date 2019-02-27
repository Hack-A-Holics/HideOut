package com.hackoholics.hideout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PropertyAdapter extends ArrayAdapter<Property> {

    public PropertyAdapter(Context context, ArrayList<Property> locations) {
        super(context, 0, locations);
    }

    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.property, parent, false);
        }
        Property currentLocation = getItem(position);

        TextView nameTextView = listItemView.findViewById(R.id.name_text_View);
        nameTextView.setText(currentLocation.getName());
        TextView addressTextView = listItemView.findViewById(R.id.address_text_view);
        addressTextView.setText(currentLocation.getAddress());
        TextView priceTextView = listItemView.findViewById(R.id.price_text_view);
        priceTextView.setText("\u20B9 " + currentLocation.getPrice());
        TextView distanceTextView = listItemView.findViewById(R.id.distance_text_view);
        distanceTextView.setText(currentLocation.getDistance());

        ImageView imageView = listItemView.findViewById(R.id.image);

        if (currentLocation.hasImage()) {
            imageView.setImageResource(currentLocation.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }
        return listItemView;
    }
}