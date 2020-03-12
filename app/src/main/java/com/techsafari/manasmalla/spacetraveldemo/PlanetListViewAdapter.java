package com.techsafari.manasmalla.spacetraveldemo;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.techsafari.manasmalla.spacetraveldemo.R;

public class PlanetListViewAdapter extends BaseAdapter {

    Context context;
    private final String[] planet_name;
    private final String[] planet_description;
    private final int[] planet_image;



    public PlanetListViewAdapter(Context context, String[] planet_name, String[] planet_description, int[] planet_image) {
        this.context = context;
        this.planet_name = planet_name;
        this.planet_description = planet_description;
        this.planet_image = planet_image;
    }

    @Override
    public int getCount() {
        return planet_name.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;
        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.planet_listview_item, parent, false);
            viewHolder.planet_textView = convertView.findViewById(R.id.planet_name);
            viewHolder.planet_description_txtView = convertView.findViewById(R.id.planet_description_txtView);
            viewHolder.planet_imgView = convertView.findViewById(R.id.planet_imgView);
            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        viewHolder.planet_textView.setText(planet_name[position]);
        viewHolder.planet_description_txtView.setText(planet_description[position]);
        viewHolder.planet_imgView.setImageResource(planet_image[position]);
        return convertView;
    }

    private static class ViewHolder {

        TextView planet_textView;
        TextView planet_description_txtView;
        ImageView planet_imgView;

    }
}
