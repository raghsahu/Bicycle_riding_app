package dev.raghav.bicycleapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import dev.raghav.bicycleapp.R;
import dev.raghav.bicycleapp.databinding.FragmentProfileBinding;
import dev.raghav.bicycleapp.databinding.FragmentRefundmodeBinding;

public class Profile_Fragment extends Fragment {
    FragmentProfileBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // View view = inflater.inflate(R.layout.fragment_home, null);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false);
        View view = binding.getRoot();//using data binding




        return view;
    }
}
