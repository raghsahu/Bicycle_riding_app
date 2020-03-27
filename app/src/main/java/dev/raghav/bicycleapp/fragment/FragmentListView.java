package dev.raghav.bicycleapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

import dev.raghav.bicycleapp.R;
import dev.raghav.bicycleapp.adapter.BikeStoreListAdapter;
import dev.raghav.bicycleapp.databinding.FragmentHomeBinding;
import dev.raghav.bicycleapp.databinding.FragmentListviewBinding;
import dev.raghav.bicycleapp.model_pojo.ListBikeStoreItem;

public class FragmentListView extends Fragment {
    FragmentListviewBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // View view = inflater.inflate(R.layout.fragment_home, null);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_listview, container, false);
        View view = binding.getRoot();//using data binding

        binding.tvMapView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=new FragmentHome();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame, fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });


        //call_api
        getBikeStore();


        return view;
    }

    private void getBikeStore() {
        ArrayList<ListBikeStoreItem>listBikeStoreItems=new ArrayList<>();
        listBikeStoreItems.add(new ListBikeStoreItem("Mamta bike store", "20 km", "15 bikes"));
        listBikeStoreItems.add(new ListBikeStoreItem("Mamta bike store", "20 km", "15 bikes"));
        listBikeStoreItems.add(new ListBikeStoreItem("Mamta bike store", "20 km", "15 bikes"));


        BikeStoreListAdapter friendsAdapter = new BikeStoreListAdapter(listBikeStoreItems,getActivity());
        binding.setMyAdapter(friendsAdapter);//set databinding adapter
        friendsAdapter.notifyDataSetChanged();


    }
}
