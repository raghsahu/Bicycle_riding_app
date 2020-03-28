package dev.raghav.bicycleapp.activity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import dev.raghav.bicycleapp.R;
import dev.raghav.bicycleapp.adapter.LeftDrawerAdapter;
import dev.raghav.bicycleapp.fragment.Booking_History_Fragment;
import dev.raghav.bicycleapp.fragment.FragmentHome;
import dev.raghav.bicycleapp.fragment.FragmentListView;
import dev.raghav.bicycleapp.fragment.Fragment_Payment;
import dev.raghav.bicycleapp.fragment.Notification_Fragment;
import dev.raghav.bicycleapp.fragment.Profile_Fragment;
import dev.raghav.bicycleapp.fragment.TermsCondition_Fragment;
import dev.raghav.bicycleapp.model_pojo.DrawerItem;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ListView mDrawerList;
    LeftDrawerAdapter leftDrawerAdapter;
    public ArrayList<DrawerItem> List_Item = new ArrayList<>();
    public int ScreenPos = 0;
    DrawerItem drawerItem;
    DrawerLayout mDrawerLayout;
    ImageView iv_drawer, nav_img_profile;
    public LinearLayout ll_nav_header;
    Toolbar toolbar;
    TextView tv_main_header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerList = findViewById(R.id.left_drawer);
        iv_drawer = findViewById(R.id.iv_drawer);
        tv_main_header = findViewById(R.id.tv_main_header);

        View header = getLayoutInflater().inflate(R.layout.nav_header_activity_navigation, null);
        ll_nav_header = header.findViewById(R.id.ll_nav_header);
        nav_img_profile = header.findViewById(R.id.nav_img_profile);
        // nav_tv_name = header.findViewById(R.id.nav_tv_name);

        mDrawerList.addHeaderView(header);
        // nav_tv_name.setText(SharedPreference.getName(MainActivity.this));
        clickListner();
        DrawerItem();
        SetupDrawer();

        //***set default open fragment
        setDefaultFragment();
    }

    private void setDefaultFragment() {

        Fragment fragment_home=new FragmentHome();
        FragmentTransaction ft_home = getSupportFragmentManager().beginTransaction();
        ft_home.replace(R.id.frame, fragment_home,"HOME_FRAGMENT");
        //ft_home.addToBackStack(null);
        ft_home.commit();
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    private void SetupDrawer() {
        //Drawer Adapter
        leftDrawerAdapter = new LeftDrawerAdapter(MainActivity.this, List_Item);
        //Set Adapter
        mDrawerList.setAdapter(leftDrawerAdapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                int position = pos - 1;
                if (position >= 0) {
                    //Call open Fragment
                    SelectOption(position);
                }
            }
        });
    }

    private void SelectOption(int pos) {
        ScreenPos = pos;
        //Selected Value Highlighted
        leftDrawerAdapter.setSelectedIndex(pos);
        //Get List Item
        drawerItem = List_Item.get(pos);
        Log.e("Position......", String.valueOf(pos));
        String Item_Name = drawerItem.getItemName();
        Log.e("Position......", Item_Name);
        //-********************************

        //Call Fragment on a listview click listner
        if (Item_Name.equals("Home")) {
            //titletxt.setText("Home");
            setDefaultFragment();

        }
        else if (Item_Name.equals("Terms of use")) {
            Fragment  fragment2 = new TermsCondition_Fragment();
//               tv_title.setText("");
            Bundle bundle = new Bundle();
            // bundle.putString("Title", "");
            FragmentTransaction ft =getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame, fragment2);
            ft.addToBackStack(null);
            ft.commit();
            fragment2.setArguments(bundle);
            mDrawerLayout.closeDrawer(mDrawerList);

        }
        else if (Item_Name.equals("Notification")) {
            Fragment  fragment2 = new Notification_Fragment();
//            tv_title.setText("");
            Bundle bundle = new Bundle();
            // bundle.putString("Title", "");
            FragmentTransaction ft =getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame, fragment2);
            ft.addToBackStack(null);
            ft.commit();
            fragment2.setArguments(bundle);
            mDrawerLayout.closeDrawer(mDrawerList);

        } else if (Item_Name.equals("Payment")) {
            Fragment  fragment2 = new Fragment_Payment();
//            tv_title.setText("");
            Bundle bundle = new Bundle();
            // bundle.putString("Title", "");
            FragmentTransaction ft =getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame, fragment2);
            ft.addToBackStack(null);
            ft.commit();
            fragment2.setArguments(bundle);
            mDrawerLayout.closeDrawer(mDrawerList);

        }else if (Item_Name.equals("Privacy policy")) {
            Fragment  fragment2 = new TermsCondition_Fragment();
//            tv_title.setText("");
            Bundle bundle = new Bundle();
            // bundle.putString("Title", "");
            FragmentTransaction ft =getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame, fragment2);
            ft.addToBackStack(null);
            ft.commit();
            fragment2.setArguments(bundle);
            mDrawerLayout.closeDrawer(mDrawerList);

        }else if (Item_Name.equals("Booking history")) {
            Fragment  fragment2 = new Booking_History_Fragment();
//            tv_title.setText("");
            Bundle bundle = new Bundle();
            // bundle.putString("Title", "");
            FragmentTransaction ft =getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame, fragment2);
            ft.addToBackStack(null);
            ft.commit();
            fragment2.setArguments(bundle);
            mDrawerLayout.closeDrawer(mDrawerList);

        }else if (Item_Name.equals("Profile")) {
            Fragment  fragment2 = new Profile_Fragment();
//            tv_title.setText("");
            Bundle bundle = new Bundle();
            // bundle.putString("Title", "");
            FragmentTransaction ft =getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame, fragment2);
            ft.addToBackStack(null);
            ft.commit();
            fragment2.setArguments(bundle);
            mDrawerLayout.closeDrawer(mDrawerList);

        }
    }

    private void clickListner() {

        iv_drawer.setOnClickListener(this);
        ll_nav_header.setOnClickListener(this);
        nav_img_profile.setOnClickListener(this);

    }

    //Drawer Item Array
    public void DrawerItem() {

        List_Item.clear();

        List_Item.add(new DrawerItem(R.drawable.home_icon, getResources().getString(R.string.home)));
        List_Item.add(new DrawerItem(R.drawable.notification_black, getResources().getString(R.string.Notification)));
        List_Item.add(new DrawerItem(R.drawable.payment, getResources().getString(R.string.payment)));
        List_Item.add(new DrawerItem(R.drawable.history_booking, getResources().getString(R.string.booking_history)));
        List_Item.add(new DrawerItem(R.drawable.user_profile, getResources().getString(R.string.Profile)));
        List_Item.add(new DrawerItem(R.drawable.contact_us, getResources().getString(R.string.contact_us)));
        List_Item.add(new DrawerItem(R.drawable.ic_explore_black_24dp, getResources().getString(R.string.explore_new_spot)));
        List_Item.add(new DrawerItem(R.drawable.share, getResources().getString(R.string.refer_friend)));
        List_Item.add(new DrawerItem(R.drawable.help_icon, getResources().getString(R.string.help)));
        List_Item.add(new DrawerItem(R.drawable.bike, getResources().getString(R.string.how_to_ride)));
        List_Item.add(new DrawerItem(R.drawable.ic_assignment_turned_in_black, getResources().getString(R.string.safety)));
        List_Item.add(new DrawerItem(R.drawable.privacy_icon, getResources().getString(R.string.privacy_policy)));
        List_Item.add(new DrawerItem(R.drawable.terms_notbook, getResources().getString(R.string.terms_of_use)));
        List_Item.add(new DrawerItem(R.drawable.about_us, getResources().getString(R.string.about_us)));
        List_Item.add(new DrawerItem(R.drawable.ic_info_logout, getResources().getString(R.string.logout)));


    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.iv_drawer:
                if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {

                    mDrawerLayout.closeDrawer(GravityCompat.START);
                } else {

                    mDrawerLayout.openDrawer(GravityCompat.START);
                }
                break;

//            case R.id.iv_search:
//                intent = new Intent(MainActivity.this, SearchActivity.class);
//                startActivity(intent);
//
//                break;
//
//            case R.id.iv_setting:
//                intent = new Intent(MainActivity.this, SettingsActivity.class);
//                startActivity(intent);
//
//                break;

        }
    }


    @Override
    public void onBackPressed() {
//        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav_view);
//        int seletedItemId = bottomNavigationView.getSelectedItemId();
//        if (R.id.navigation_home != seletedItemId) {
//            setHomeItem(MainActivity.this);
//        } else {
//            super.onBackPressed();
//        }

        FragmentHome myFragment = (FragmentHome)getSupportFragmentManager().findFragmentByTag("HOME_FRAGMENT");
        if (myFragment != null && myFragment.isVisible()) {
            // add your code here
            finish();
        }else {
            super.onBackPressed();
        }


    }


    public void Update_header(String title){

        tv_main_header.setText(title);

    }


}
