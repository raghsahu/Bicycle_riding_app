package dev.raghav.bicycleapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import dev.raghav.bicycleapp.R;
import dev.raghav.bicycleapp.activity.MainActivity;
import dev.raghav.bicycleapp.databinding.FragmentFeedbackBinding;

public class FragmentFeedback extends Fragment {
    FragmentFeedbackBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // View view = inflater.inflate(R.layout.fragment_home, null);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_feedback, container, false);
        View view = binding.getRoot();//using data binding
        try {
            ((MainActivity) getActivity()).Update_header("bikes");
        } catch (Exception e) {

        }

        binding.tvSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });



        return view;
    }

}
