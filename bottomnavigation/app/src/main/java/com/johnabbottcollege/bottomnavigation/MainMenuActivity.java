package com.johnabbottcollege.bottomnavigation;

import android.support.annotation.NonNull;
import android.support.design.bottomappbar.BottomAppBar;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;


// First thing first, add that depentencies in build.gradle(Module.app)
//  implementation 'com.android.support:design:28.0.0'
//  add directory: drawable-hdpi,drawable-mdpi,drawable-xhdpi,drawable-xxhdpi,drawable-xxxhdpi
// add directory: menu
// create navigation bottom button :  name it nav_items
// create fragment file: go to package, new, fragment, fragment(blank)
// add some color to colors.xml under values
// add some color to nav_item_colors.xml(self create) uner res/color(resourse directory)
// give a id to nav_items name it main_nav
// add a fram layout to activity_main。xml give it ID. name it main_frame
// give all menu item a id in nav_items.xml under menu resource directory

public class MainMenuActivity extends AppCompatActivity {


    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private FragmentHome fragmentHome;
    private FragmentBookMark fragmentBookMark;
    private FragmentRecents fragmentRecents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // bottomNavigation bar id
        mMainNav = findViewById(R.id.main_nav);
        // activity layout frame id
        mMainFrame = findViewById(R.id.main_frame);

        //constructor for all fragment page

        fragmentHome = new FragmentHome();
        fragmentBookMark = new FragmentBookMark();
        fragmentRecents = new FragmentRecents();
        // set default page
        setFragment(fragmentHome);

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
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        // replace the current fragment page by the fragment pass by here
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();

    }
}
