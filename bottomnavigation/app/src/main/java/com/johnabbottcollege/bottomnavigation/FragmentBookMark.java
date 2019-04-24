package com.johnabbottcollege.bottomnavigation;


import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentBookMark extends Fragment {

    public static final String CLASS_TAG = "FragmentBookMark";
    private static final String FOOD_LIST = "food_lis" ;
    private static final String FILE_NAME = "myfile";
    public static ArrayList<Item> finalList = new ArrayList<>();
    FloatingActionButton fab;
    View v;
    private RecyclerView myrecyclerView;
    public static int orderNumber;
    private String resultString;
    public static ArrayList <String> strArray = new ArrayList<>();

    public FragmentBookMark() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_fragment_book_mark, container, false);
        myrecyclerView = v.findViewById(R.id.bookmark_recyclerview);
        ComfirmItemAdapter itemAdapter = new ComfirmItemAdapter(finalList);//////////////////////////////
        myrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerView.setAdapter(itemAdapter);
        fab = v.findViewById(R.id.fab);
        // convert finalList to string ,add into strArray and save to SharedPreferences with Gson
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertArrayToString(finalList);
            }
        });
        return  v;
    }

    private void convertArrayToString(ArrayList<Item> finalList) {
        if (finalList.size() != 0) {
            Toast.makeText(getContext(), "Order sent", Toast.LENGTH_SHORT).show();

            Helper helper = new Helper();
            String currentTime = helper.getCurrentTime();
            orderNumber += 1;
            resultString = String.valueOf(orderNumber) + ".\n";
            resultString += currentTime + "\n";
            resultString += helper.converArrayToString(finalList);
            // add to strArray for display in Recents fragment
            strArray.add(resultString);
            // empty finalList
            finalList.clear();
            saveData();
        }else
            Toast.makeText(getContext(),"Nothing to send",Toast.LENGTH_SHORT).show();
    }

    private void saveData() {
        // add Gson dependencies in build gradle
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(FILE_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(strArray);
        editor.putString(FOOD_LIST,json);
        editor.apply();
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(FILE_NAME, Activity.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(FOOD_LIST,null);
        Type type = new TypeToken<ArrayList<String>>(){}.getType();
        strArray = gson.fromJson(json,type);
        if (strArray == null){
            strArray = new ArrayList<>();
        }

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadData();
        Log.i(CLASS_TAG, "onCreate method called");
    }
}









