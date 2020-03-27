package dev.raghav.bicycleapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import dev.raghav.bicycleapp.R;
import dev.raghav.bicycleapp.databinding.FragmentNavigationBinding;
import dev.raghav.bicycleapp.databinding.FragmentStartRidingBinding;

public class FragmentStartRiding extends Fragment {
    FragmentStartRidingBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // View view = inflater.inflate(R.layout.fragment_home, null);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_start_riding, container, false);
        View view = binding.getRoot();//using data binding

        binding.llEngage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new FragmentEngage();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame, fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });


        binding.llCheckCondition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new FragmentCheck_Condition();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame, fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        binding.cardRenew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Fragment_Renew_Condition();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame, fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });


        return view;
    }

}
