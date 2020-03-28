package dev.raghav.bicycleapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import dev.raghav.bicycleapp.R;
import dev.raghav.bicycleapp.activity.MainActivity;
import dev.raghav.bicycleapp.databinding.FragmentCheckConditionBinding;

public class FragmentCheck_Condition extends Fragment {
    FragmentCheckConditionBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // View view = inflater.inflate(R.layout.fragment_home, null);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_check_condition, container, false);
        View view = binding.getRoot();//using data binding

        try {
            ((MainActivity)getActivity()).Update_header("booking history");
        }catch (Exception e){

        }



        return view;
    }

    }
