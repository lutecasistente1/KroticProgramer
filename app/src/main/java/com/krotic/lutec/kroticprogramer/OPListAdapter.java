package com.krotic.lutec.kroticprogramer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Andres on 12/15/2015.
 * Custom and generic adapter for the {@link android.widget.ListView}
 */
public abstract class OPListAdapter<T> extends BaseAdapter {

/*-------------------------------------Class variable---------------------------------------------*/
    private ArrayList<T> items;

    private int layout_id;

    private Context context;

/*-------------------------------------Methods----------------------------------------------------*/

    /**
     * Contructor
     * @param items {@link android.widget.ListView} items
     * @param layout_id Layout of each item
     * @param context activity where the {@link android.widget.ListView} will be make it
     */
    public OPListAdapter(ArrayList<T> items, int layout_id, Context context) {
        this.items = items;
        this.layout_id = layout_id;
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout_id, null);
        }

        return fillViewPerItem(convertView);
    }

    /**
     * Fill the {@link View} for each item
     * @param view {View} tha is going to be filled
     * @return the final {@link View}
     */
    public abstract View fillViewPerItem(View view);
}
