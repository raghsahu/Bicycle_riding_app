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
import dev.raghav.bicycleapp.activity.MainActivity;
import dev.raghav.bicycleapp.adapter.BikeStoreListAdapter;
import dev.raghav.bicycleapp.adapter.PreviousPaymentAdapter;
import dev.raghav.bicycleapp.databinding.FragmentPaymentBinding;
import dev.raghav.bicycleapp.model_pojo.ListBikeStoreItem;

public class Fragment_Payment extends Fragment {
    FragmentPaymentBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // View view = inflater.inflate(R.layout.fragment_home, null);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_payment, container, false);
        View view = binding.getRoot();//using data binding
        try {
            ((MainActivity)getActivity()).Update_header("Payment");
        }catch (Exception e){

        }

        //call_api
        getPreviousPaymentList();

        binding.tvRefundMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Fragment_Refund_Mode();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame, fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });



        return view;
    }

    private void getPreviousPaymentList() {
        ArrayList<ListBikeStoreItem> listBikeStoreItems=new ArrayList<>();
        listBikeStoreItems.add(new ListBikeStoreItem("Mamta bike store", "20 km", "15 bikes"));
        listBikeStoreItems.add(new ListBikeStoreItem("Mamta bike store", "20 km", "15 bikes"));
        listBikeStoreItems.add(new ListBikeStoreItem("Mamta bike store", "20 km", "15 bikes"));


        PreviousPaymentAdapter friendsAdapter = new PreviousPaymentAdapter(listBikeStoreItems,getActivity());
        binding.setMyAdapter(friendsAdapter);//set databinding adapter
        friendsAdapter.notifyDataSetChanged();

    }

}
