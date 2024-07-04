package com.example.milkman;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class listFragment extends Fragment implements RecyclerModelAdapter.OnAmountChangeListener {

    ArrayList<list_Model> arrayList = new ArrayList<>();

    public listFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



        arrayList.add(new list_Model(R.drawable.face , "Vanshaj" , "7"));
        arrayList.add(new list_Model(R.drawable.face , "Vidisha" , "8"));
        arrayList.add(new list_Model(R.drawable.face , "Shrija" , "74"));
        arrayList.add(new list_Model(R.drawable.face , "Mitali" , "84"));
        arrayList.add(new list_Model(R.drawable.face , "Keshav" , "4"));
        arrayList.add(new list_Model(R.drawable.face , "Vanshaj" , "74"));
        arrayList.add(new list_Model(R.drawable.face , "Vidisha" , "774"));
        arrayList.add(new list_Model(R.drawable.face , "Shrija" , "84"));
        arrayList.add(new list_Model(R.drawable.face , "Mitali" , "874"));

        RecyclerModelAdapter recyclerModelAdapter = new RecyclerModelAdapter(getContext() , arrayList , this);

        recyclerView.setAdapter(recyclerModelAdapter);


        return view;
    }

    @Override
    public void onAmountChanged(int amount) {
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity != null) {
            mainActivity.updateAmount(amount);
        }
    }

    @Override
    public void onAmountChangedOff(int amount) {
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity != null) {
            mainActivity.updateAmountOff(amount);
        }
    }


}