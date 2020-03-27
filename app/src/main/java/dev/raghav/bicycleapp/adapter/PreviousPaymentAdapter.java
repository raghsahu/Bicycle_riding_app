package dev.raghav.bicycleapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dev.raghav.bicycleapp.BR;
import dev.raghav.bicycleapp.R;
import dev.raghav.bicycleapp.databinding.BikeCenterListBinding;
import dev.raghav.bicycleapp.databinding.PreviousPaymentListBinding;
import dev.raghav.bicycleapp.fragment.FragmentBookNow;
import dev.raghav.bicycleapp.model_pojo.ListBikeStoreItem;

public class PreviousPaymentAdapter extends RecyclerView.Adapter<PreviousPaymentAdapter.ViewHolder> {

    private List<ListBikeStoreItem> dataModelList;
    Context context;
    // SessionManager sessionManager;


    public PreviousPaymentAdapter(ArrayList<ListBikeStoreItem> dataModelList, Context ctx) {
        this.dataModelList = dataModelList;
        context = ctx;
        // sessionManager=new SessionManager(context);

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        PreviousPaymentListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.previous_payment_list, parent, false);

        return new ViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListBikeStoreItem dataModel = dataModelList.get(position);
        holder.bind(dataModel);
        holder.itemRowBinding.setModel(dataModel);
        // holder.itemRowBinding.setItemClickListener(this);




    }


    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public PreviousPaymentListBinding itemRowBinding;

        public ViewHolder(PreviousPaymentListBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
        }

        public void bind(Object obj) {
            itemRowBinding.setVariable(BR.model, obj);
            itemRowBinding.executePendingBindings();
        }
    }



}
