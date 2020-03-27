package dev.raghav.bicycleapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import dev.raghav.bicycleapp.R;

/**
 * Created by Raghvendra Sahu on 23-Mar-20.
 */
public class Fragment_welcome2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome_two, null);
        return view;
    }
}
