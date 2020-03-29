package dev.raghav.bicycleapp.adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.InsetDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dev.raghav.bicycleapp.BR;
import dev.raghav.bicycleapp.R;
import dev.raghav.bicycleapp.databinding.BikeCenterListBinding;
import dev.raghav.bicycleapp.fragment.FragmentBookNow;
import dev.raghav.bicycleapp.model_pojo.ListBikeStoreItem;

public class BikeStoreListAdapter extends RecyclerView.Adapter<BikeStoreListAdapter.ViewHolder> {

    private List<ListBikeStoreItem> dataModelList;
    Context context;
    private Dialog successDialog;
   // SessionManager sessionManager;


    public BikeStoreListAdapter(ArrayList<ListBikeStoreItem> dataModelList, Context ctx) {
        this.dataModelList = dataModelList;
        context = ctx;
       // sessionManager=new SessionManager(context);

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BikeCenterListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.bike_center_list, parent, false);

        return new ViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListBikeStoreItem dataModel = dataModelList.get(position);
        holder.bind(dataModel);
        holder.itemRowBinding.setModel(dataModel);
       // holder.itemRowBinding.setItemClickListener(this);

        holder.itemRowBinding.llBookNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                OpenBooknowDialog();

            }
        });


    }

    private void OpenBooknowDialog() {
        successDialog = new Dialog(context,R.style.DialogTheme);
        successDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        successDialog.setCancelable(true);
        successDialog.setContentView(R.layout.booknow_dialog);
        //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
       //////// successDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(successDialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.BOTTOM;
        successDialog.getWindow().setAttributes(lp);

        CardView card_booknow = successDialog.findViewById(R.id.card_booknow);

        card_booknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentBookNow fragment2 = new FragmentBookNow();
                FragmentManager manager = ((AppCompatActivity) context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = manager.beginTransaction();
                fragmentTransaction.replace(R.id.frame, fragment2);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                successDialog.dismiss();
            }
        });


        try {
            if (!((AppCompatActivity)context).isFinishing()) {
                successDialog.show();
            }
        } catch (WindowManager.BadTokenException e) {
            //use a log message
        }

    }


    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public BikeCenterListBinding itemRowBinding;

        public ViewHolder(BikeCenterListBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
        }

        public void bind(Object obj) {
            itemRowBinding.setVariable(BR.model, obj);
            itemRowBinding.executePendingBindings();
        }
    }

//    public void cardClicked(HomeArtistFollowLists f) {
////        SendRequestFragment fragment2 = new SendRequestFragment();
////        FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();
////        FragmentTransaction fragmentTransaction = manager.beginTransaction();
////        fragmentTransaction.replace(R.id.frame, fragment2);
////        fragmentTransaction.addToBackStack(null);
////        fragmentTransaction.commit();
//
//
//    }

}
