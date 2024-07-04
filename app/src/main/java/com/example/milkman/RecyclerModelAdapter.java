package com.example.milkman;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class RecyclerModelAdapter extends RecyclerView.Adapter<RecyclerModelAdapter.ViewHolder> {


    public interface OnAmountChangeListener {
        void onAmountChanged(int amount);

        void onAmountChangedOff(int amount);
    }

    private OnAmountChangeListener amountChangeListener;
    private Context context;
    private ArrayList<list_Model> arrayList;

    RecyclerModelAdapter(Context context , ArrayList<list_Model> arrayList , OnAmountChangeListener listener){
        this.context = context;
        this.arrayList = arrayList;
        this.amountChangeListener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_recycler_model , parent , false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.img_Model.setImageResource(arrayList.get(position).img);
        holder.txt_Name_Model.setText(arrayList.get(position).name);
        holder.txt_Contact_Model.setText(arrayList.get(position).number);

        holder.switch_Model.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    int amount = Integer.parseInt(arrayList.get(position).number);

                    if (amountChangeListener != null) {
                        amountChangeListener.onAmountChanged(amount);
                    }

                }else {
                    int amount = Integer.parseInt(arrayList.get(position).number);

                    if (amountChangeListener != null) {
                        amountChangeListener.onAmountChangedOff(amount);
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txt_Name_Model , txt_Contact_Model;
        ImageView img_Model;
        SwitchCompat switch_Model;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_Name_Model = itemView.findViewById(R.id.txt_Name_Model);
            txt_Contact_Model = itemView.findViewById(R.id.txt_Contact_Model);
            img_Model = itemView.findViewById(R.id.img_Model);
            switch_Model = itemView.findViewById(R.id.switch_Model);
        }
    }
}
