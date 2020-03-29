package dev.raghav.bicycleapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import dev.raghav.bicycleapp.R;
import dev.raghav.bicycleapp.model_pojo.DrawerItem;

/**
 * Created by Raghvendra Sahu on 23-Mar-20.
 */
public class LeftDrawerAdapter extends BaseAdapter {


    ArrayList<DrawerItem> Drawerlist = new ArrayList<>();
    Context mContext;
    private int selectedIndex;
    DrawerItem drawerItem;
    ImageView iconimg;
    ImageView icon_profile;

    public LeftDrawerAdapter(Context context, ArrayList<DrawerItem> listArray) {
        mContext = context;
        Drawerlist = listArray;
        //fragmentManager = fm;

    }

    @Override
    public int getCount() {
        return Drawerlist.size();    // total number of elements in the list
    }

    @Override
    public Object getItem(int i) {
        return Drawerlist.get(i);    // single item in the list
    }

    @Override
    public long getItemId(int i) {
        return i;                   // index number
    }

    @Override
    public View getView(int index, View view, final ViewGroup parent) {

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());

            view = inflater.inflate(R.layout.list_item_drawer, parent, false);
        }

        drawerItem = Drawerlist.get(index);

        TextView itemtxt = view.findViewById(R.id.list_item_id);
        icon_profile = view.findViewById(R.id.icon_profile);
        LinearLayout linearLayout = view.findViewById(R.id.layout_id);
        View view_line = view.findViewById(R.id.view_line);


        if (index==7 ){
            view_line.setVisibility(View.VISIBLE);
        } if (index==11 ){
            view_line.setVisibility(View.VISIBLE);
        }



        //set name and icon on listview
        itemtxt.setText(drawerItem.getItemName());
        icon_profile.setImageResource((int) drawerItem.getIconImg());

//        Glide.with(mContext)
//                .load(drawerItem.getIconImg())
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(icon_profile);

        //Selected Item  Highlighted
        if (selectedIndex != -1 && index == selectedIndex) {

            //PP call selectedIcon method
            //setSelectedIconImage();

            linearLayout.setBackgroundResource(R.drawable.listselection_bg);
            itemtxt.setTextColor(Color.parseColor("#FFFFFF"));
            //TextStyle Bold
            itemtxt.setTypeface(Typeface.DEFAULT_BOLD);

        } else {

            itemtxt.setTextColor(Color.parseColor("#000000"));
            //linearLayout.setBackground(null);
            linearLayout.setBackgroundResource(R.drawable.listdeselection_bg);
            itemtxt.setTypeface(Typeface.DEFAULT);

        }


        return view;
    }


    //PP method to make selected icon white
    public void setSelectedIconImage() {


//        switch (drawerItem.getItemName()) {
//            case "Home":
//                icon_profile.setImageResource(R.drawable.ic_home_black_24dp);
//                break;
//
//        }
    }

    public void setSelectedIndex(int ind) {
        selectedIndex = ind;
        notifyDataSetChanged();
    }
}
