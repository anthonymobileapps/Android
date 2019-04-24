package com.johnabbottcollege.bottomnavigation;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static com.johnabbottcollege.bottomnavigation.CategoryActivity.TAG;
import static com.johnabbottcollege.bottomnavigation.FragmentBookMark.orderNumber;
import static com.johnabbottcollege.bottomnavigation.FragmentBookMark.strArray;


public class FragmentRecents extends Fragment {

    private static final String FOOD_LIST = "fragment recents food list" ;
    private static final String FILE_NAME = "myfile";
    View v;
    RecyclerView myrecyclerView;
    private ArrayList<String>itemList;

    ItemRecentsAdapter itemAdapter;
    public FragmentRecents() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView:  Fragment recents called***********************");
        // Inflate the layout for this fragment
        itemList = strArray;
        v =  inflater.inflate(R.layout.fragment_fragment_recents, container, false);
        myrecyclerView = v.findViewById(R.id.recents_recyclerview);
        //staggered (grid view) recylerView
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        myrecyclerView.setLayoutManager(layoutManager);
        itemAdapter = new ItemRecentsAdapter(itemList);
        myrecyclerView.setAdapter(itemAdapter);
        return  v;

    }
    public void loadData(){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("My preferences", Activity.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(FOOD_LIST,null);
        Type type = new TypeToken<ArrayList<String>>(){}.getType();
        itemList = gson.fromJson(json,type);
        if (itemList == null){
            itemList = new ArrayList<>();
        }

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemList = new ArrayList<>();
        loadData();
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
       inflater.inflate(R.menu.nav_recents,menu);
    }

    // trush can selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_trash) {
            Log.i(TAG, "onOptionsItemSelected: *************************");

            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setMessage("Are you sure to close the table?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    removePrefValues();
                    itemAdapter.notifyDataSetChanged();
                }
            }).setNegativeButton("Cancel", null);
            AlertDialog alertDialog = builder.create();
            alertDialog.show();


            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void removePrefValues() {
        SharedPreferences.Editor editor = getActivity().getSharedPreferences(FILE_NAME, Activity.MODE_PRIVATE).edit();
        editor.clear();
        editor.apply();
        strArray.clear();
        itemList.clear();
        orderNumber = 0;
    }
}
