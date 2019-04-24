package com.johnabbottcollege.bottomnavigation;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class FragmentHome extends Fragment {
    public static final String CLASS_TAG = "FragmentHome";
    View v;
    private RecyclerView myrecyclerView;
    private List<Item> itemList ;


    public FragmentHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(CLASS_TAG, "onCreateView method called");
        // Inflate the layout for this fragment
         v = inflater.inflate(R.layout.fragment_fragment_home, container, false);
         myrecyclerView = v.findViewById(R.id.home_recyclerview);
         ItemAdapter itemAdapter = new ItemAdapter(getContext(),itemList);
         myrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
         myrecyclerView.setAdapter(itemAdapter);
         return  v;

    }

    // manuel add onCreate method
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(CLASS_TAG, "onCreate method called");
        itemList  = new ArrayList<>();
        itemList.add(new Item(R.drawable.img_001, "Appertizer"));
        itemList.add(new Item(R.drawable.img_012, "Sushi"));
        itemList.add(new Item(R.drawable.img_050, "Sushi Pizzer"));
        itemList.add(new Item(R.drawable.img_061, "Futo Maki"));
        itemList.add(new Item(R.drawable.img_050, "Hoso Make"));
        itemList.add(new Item(R.drawable.img_150, "Noodle"));
        itemList.add(new Item(R.drawable.img_001, "Appertizer"));
        itemList.add(new Item(R.drawable.img_012, "Sushi"));
        itemList.add(new Item(R.drawable.img_050, "Sushi Pizzer"));
        itemList.add(new Item(R.drawable.img_061, "Futo Maki"));
        itemList.add(new Item(R.drawable.img_050, "Hoso Make"));
        itemList.add(new Item(R.drawable.img_150, "Noodle"));


    }
}
