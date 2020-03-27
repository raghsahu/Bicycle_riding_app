package dev.raghav.bicycleapp.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import dev.raghav.bicycleapp.fragment.Fragment_welcome1;
import dev.raghav.bicycleapp.fragment.Fragment_welcome2;

/**
 * Created by Raghvendra Sahu on 23-Mar-20.
 */
public class Fragment_Pager extends FragmentPagerAdapter {
    final int PAGE_COUNT = 2;

    public Fragment_Pager(@NonNull FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                // Your current main fragment showing how to send arguments to fragment
                Fragment_welcome1 myFragment = new Fragment_welcome1();

                return myFragment;
            case 1:
                // Calling a Fragment without sending arguments
                return new Fragment_welcome2();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
