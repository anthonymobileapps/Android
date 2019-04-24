package com.johnabbottcollege.bottomnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

// add back button on menu bar.
/*
    In manifest add
    <activity android:name=".DetailActivity"
    android:parentActivityName=".CategoryActivity"/>

 */
public class DetailActivity extends AppCompatActivity {
    public static  String TAG = "com.johnabbottcollege.bottomnavigation.DetailActivity";
    public static List<Item> totalOrderList ;
    private List<Item> orderList ;
    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;
    private FragmentHome fragmentHome;
    private FragmentBookMark fragmentBookMark;
    private FragmentRecents fragmentRecents;



    Item item;

    TextView tvQuantity;
    String strQuantity;
    int quantity;
    public static int orderTimes = 0;
    private boolean ivShoppingCartClickable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        orderList  = new ArrayList<>();
        totalOrderList = new ArrayList<>();

        ivShoppingCartClickable = true;

        Log.d(TAG, "Detail Activity onCreate called &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&: ");

        fragmentHome = new FragmentHome();
        fragmentBookMark = new FragmentBookMark();
        fragmentRecents = new FragmentRecents();
        // set default page
        //setFragment(fragmentHome);
         mMainNav = findViewById(R.id.bottom_nav_bar_detail);
         mMainFrame = findViewById(R.id.layout_detail_frame);
        //*********************************************************************************************************
        //set up action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Category");

        tvQuantity = findViewById(R.id.tv_detail_quantity);
        ImageView imageView = findViewById(R.id.iv_detail);
        ImageView ivAddButton = findViewById(R.id.btn_detail_plus);
        ImageView ivMinusButton = findViewById(R.id.btn_detail_minus);
        TextView itemNumberAndName = findViewById(R.id.tv_detail_number_name);
        final ImageView ivShoppingCart = findViewById(R.id.iv_btn_detail_shopping);


        //*********************************************************************************************************


        Intent intent = getIntent();
        item = intent.getParcelableExtra("item_object");

        int imageRes = item.getItemImageId();
        String number = item.getItemNumber();
        String name = item.getItemName();

        imageView.setImageResource(imageRes);
        itemNumberAndName.setText(number + ". " + name);

        //*********************************************************************************************************



        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.nav_main:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(fragmentHome);
                        return true;
                    case R.id.nav_bookmark:
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(fragmentBookMark);
                        return true;
                    case R.id.nav_recents:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimaryDark);
                        setFragment(fragmentRecents);
                        return true;
                    default:
                        return false;
                }
            }
        });

        ivAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                quantity += 1;
                strQuantity = String.valueOf(quantity);
                tvQuantity.setText(strQuantity);
            }
        });
        ivMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity > 0) {
                    quantity -= 1;
                    strQuantity = String.valueOf(quantity);
                    tvQuantity.setText(strQuantity);
                }
            }
        });

            ivShoppingCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (ivShoppingCartClickable) {
                        ivShoppingCart.setClickable(true);
                        int quantity = Integer.valueOf(String.valueOf(tvQuantity.getText()));
                        if (quantity > 0) {
                            item.setQuantity(quantity);
                            orderList.add(item);
                            Log.i(TAG, "orderList in DetailActivity****************************: " + orderList);
                            FragmentBookMark.finalList.add(item);
                            //empty orderList
                            orderList.clear();
                            Toast.makeText(getApplicationContext(),"Added!",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(),"Nothing to add!",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(),"Item already add!",Toast.LENGTH_SHORT).show();
                    }
                    ivShoppingCart.setClickable(false);
                    ivShoppingCartClickable = false;
                }
            });

    }

    @Override

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("list_key", (ArrayList<? extends Parcelable>) orderList);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        orderList = savedInstanceState.getParcelableArrayList("list_key");
    }

    @Override
    public void onStart(){
        super.onStart();
        ivShoppingCartClickable = true;
        Log.d(TAG, "onStart: ******************************* is called");

    }
    private void setFragment(android.support.v4.app.Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        // replace the current fragment page by the fragment pass by here
        fragmentTransaction.replace(R.id.layout_detail_frame, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

}
