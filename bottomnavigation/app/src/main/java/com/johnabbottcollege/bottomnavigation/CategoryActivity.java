package com.johnabbottcollege.bottomnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {
public static final String TAG = "CategoryActivity";

    private CategoryAdapter categoryAdapter;
    private List<Item> itemList = new ArrayList<>();

    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Intent intent = getIntent();

        if (intent != null){

             index   = intent.getIntExtra("int_data",0);
        }
        init(index);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(itemList);
        recyclerView.setAdapter(categoryAdapter);
    }

    private void init(int index) {
        switch (index){
            case 0:
                itemList.add(new Item(R.drawable.img_001, "Miso sopue","1","Appertizers"));
                itemList.add(new Item(R.drawable.img_003, "Kim chi","3","Appertizers"));
                itemList.add(new Item(R.drawable.img_005, "Seaweek salad","5","Appertizers"));
                itemList.add(new Item(R.drawable.img_006, "Green salad","6","Appertizers"));
                itemList.add(new Item(R.drawable.img_007, "House salad","7","Appertizers"));
                itemList.add(new Item(R.drawable.img_008, "Seafood salad","8","Appertizers"));
                itemList.add(new Item(R.drawable.img_009, "Kim chi Tofu salad","9","Appertizers"));
                itemList.add(new Item(R.drawable.img_010, "Cool tofu","10","Appertizers"));
                itemList.add(new Item(R.drawable.img_011, "Soya bean","11","Appertizers"));
                break;

            case 1:
                itemList.add(new Item(R.drawable.img_021, "Ell","21","Sushi"));
                itemList.add(new Item(R.drawable.img_022, "Shrimp","22","Sushi"));
                itemList.add(new Item(R.drawable.img_023, "Crab stick","23","Sushi"));
                itemList.add(new Item(R.drawable.img_024, "Snapper","24","Sushi"));
                itemList.add(new Item(R.drawable.img_025, "Saumon","25","Sushi"));
                itemList.add(new Item(R.drawable.img_026, "White fish","26","Sushi"));
                itemList.add(new Item(R.drawable.img_027, "Saumon rose","27","Sushi"));
                itemList.add(new Item(R.drawable.img_028, "Makel","28","Sushi"));
                itemList.add(new Item(R.drawable.img_029, "Crab stick","29","Sushi"));
                itemList.add(new Item(R.drawable.img_030, "Miso sopue","30","Sushi"));
                itemList.add(new Item(R.drawable.img_031, "Kim chi","31","Sushi"));
                itemList.add(new Item(R.drawable.img_032, "Seaweek salad","32","Sushi"));
                itemList.add(new Item(R.drawable.img_033, "Green salad","33","Sushi"));
                itemList.add(new Item(R.drawable.img_034, "House salad","34","Sushi"));
                itemList.add(new Item(R.drawable.img_035, "Seafood salad","35","Sushi"));
                itemList.add(new Item(R.drawable.img_036, "Kim chi Tofu salad","36","Sushi"));
                itemList.add(new Item(R.drawable.img_037, "Cool tofu","37","Sushi"));
                itemList.add(new Item(R.drawable.img_038, "Soya bean","38","Sushi"));
                itemList.add(new Item(R.drawable.img_039, "Soya bean","39","Sushi"));
                break;

            case 2:
                itemList.add(new Item(R.drawable.img_021, "Ell","21","Sushi"));
                itemList.add(new Item(R.drawable.img_022, "Shrimp","22","Sushi"));
                itemList.add(new Item(R.drawable.img_023, "Crab stick","23","Sushi"));
                itemList.add(new Item(R.drawable.img_024, "Snapper","24","Sushi"));
                itemList.add(new Item(R.drawable.img_025, "Saumon","25","Sushi"));
                itemList.add(new Item(R.drawable.img_026, "White fish","26","Sushi"));
                itemList.add(new Item(R.drawable.img_027, "Saumon rose","27","Sushi"));
                itemList.add(new Item(R.drawable.img_028, "Makel","28","Sushi"));
                itemList.add(new Item(R.drawable.img_029, "Crab stick","29","Sushi"));
                itemList.add(new Item(R.drawable.img_030, "Miso sopue","30","Sushi"));
                itemList.add(new Item(R.drawable.img_031, "Kim chi","31","Sushi"));
                itemList.add(new Item(R.drawable.img_032, "Seaweek salad","32","Sushi"));
                itemList.add(new Item(R.drawable.img_033, "Green salad","33","Sushi"));
                itemList.add(new Item(R.drawable.img_034, "House salad","34","Sushi"));
                itemList.add(new Item(R.drawable.img_035, "Seafood salad","35","Sushi"));
                itemList.add(new Item(R.drawable.img_036, "Kim chi Tofu salad","36","Sushi"));
                itemList.add(new Item(R.drawable.img_037, "Cool tofu","37","Sushi"));
                itemList.add(new Item(R.drawable.img_038, "Soya bean","38","Sushi"));
                itemList.add(new Item(R.drawable.img_039, "Soya bean","39","Sushi"));
                break;

            case 3:
                itemList.add(new Item(R.drawable.img_021, "Ell","21","Sushi"));
                itemList.add(new Item(R.drawable.img_022, "Shrimp","22","Sushi"));
                itemList.add(new Item(R.drawable.img_023, "Crab stick","23","Sushi"));
                itemList.add(new Item(R.drawable.img_024, "Snapper","24","Sushi"));
                itemList.add(new Item(R.drawable.img_025, "Saumon","25","Sushi"));
                itemList.add(new Item(R.drawable.img_026, "White fish","26","Sushi"));
                itemList.add(new Item(R.drawable.img_027, "Saumon rose","27","Sushi"));
                itemList.add(new Item(R.drawable.img_028, "Makel","28","Sushi"));
                itemList.add(new Item(R.drawable.img_029, "Crab stick","29","Sushi"));
                itemList.add(new Item(R.drawable.img_030, "Miso sopue","30","Sushi"));
                itemList.add(new Item(R.drawable.img_031, "Kim chi","31","Sushi"));
                itemList.add(new Item(R.drawable.img_032, "Seaweek salad","32","Sushi"));
                itemList.add(new Item(R.drawable.img_033, "Green salad","33","Sushi"));
                itemList.add(new Item(R.drawable.img_034, "House salad","34","Sushi"));
                itemList.add(new Item(R.drawable.img_035, "Seafood salad","35","Sushi"));
                itemList.add(new Item(R.drawable.img_036, "Kim chi Tofu salad","36","Sushi"));
                itemList.add(new Item(R.drawable.img_037, "Cool tofu","37","Sushi"));
                itemList.add(new Item(R.drawable.img_038, "Soya bean","38","Sushi"));
                itemList.add(new Item(R.drawable.img_039, "Soya bean","39","Sushi"));
                break;

            case 4:
                itemList.add(new Item(R.drawable.img_021, "Ell","21","Sushi"));
                itemList.add(new Item(R.drawable.img_022, "Shrimp","22","Sushi"));
                itemList.add(new Item(R.drawable.img_023, "Crab stick","23","Sushi"));
                itemList.add(new Item(R.drawable.img_024, "Snapper","24","Sushi"));
                itemList.add(new Item(R.drawable.img_025, "Saumon","25","Sushi"));
                itemList.add(new Item(R.drawable.img_026, "White fish","26","Sushi"));
                itemList.add(new Item(R.drawable.img_027, "Saumon rose","27","Sushi"));
                itemList.add(new Item(R.drawable.img_028, "Makel","28","Sushi"));
                itemList.add(new Item(R.drawable.img_029, "Crab stick","29","Sushi"));
                itemList.add(new Item(R.drawable.img_030, "Miso sopue","30","Sushi"));
                itemList.add(new Item(R.drawable.img_031, "Kim chi","31","Sushi"));
                itemList.add(new Item(R.drawable.img_032, "Seaweek salad","32","Sushi"));
                itemList.add(new Item(R.drawable.img_033, "Green salad","33","Sushi"));
                itemList.add(new Item(R.drawable.img_034, "House salad","34","Sushi"));
                itemList.add(new Item(R.drawable.img_035, "Seafood salad","35","Sushi"));
                itemList.add(new Item(R.drawable.img_036, "Kim chi Tofu salad","36","Sushi"));
                itemList.add(new Item(R.drawable.img_037, "Cool tofu","37","Sushi"));
                itemList.add(new Item(R.drawable.img_038, "Soya bean","38","Sushi"));
                itemList.add(new Item(R.drawable.img_039, "Soya bean","39","Sushi"));
                break;

            case 5:
                itemList.add(new Item(R.drawable.img_021, "Ell","21","Sushi"));
                itemList.add(new Item(R.drawable.img_022, "Shrimp","22","Sushi"));
                itemList.add(new Item(R.drawable.img_023, "Crab stick","23","Sushi"));
                itemList.add(new Item(R.drawable.img_024, "Snapper","24","Sushi"));
                itemList.add(new Item(R.drawable.img_025, "Saumon","25","Sushi"));
                itemList.add(new Item(R.drawable.img_026, "White fish","26","Sushi"));
                itemList.add(new Item(R.drawable.img_027, "Saumon rose","27","Sushi"));
                itemList.add(new Item(R.drawable.img_028, "Makel","28","Sushi"));
                itemList.add(new Item(R.drawable.img_029, "Crab stick","29","Sushi"));
                itemList.add(new Item(R.drawable.img_030, "Miso sopue","30","Sushi"));
                itemList.add(new Item(R.drawable.img_031, "Kim chi","31","Sushi"));
                itemList.add(new Item(R.drawable.img_032, "Seaweek salad","32","Sushi"));
                itemList.add(new Item(R.drawable.img_033, "Green salad","33","Sushi"));
                itemList.add(new Item(R.drawable.img_034, "House salad","34","Sushi"));
                itemList.add(new Item(R.drawable.img_035, "Seafood salad","35","Sushi"));
                itemList.add(new Item(R.drawable.img_036, "Kim chi Tofu salad","36","Sushi"));
                itemList.add(new Item(R.drawable.img_037, "Cool tofu","37","Sushi"));
                itemList.add(new Item(R.drawable.img_038, "Soya bean","38","Sushi"));
                itemList.add(new Item(R.drawable.img_039, "Soya bean","39","Sushi"));
                break;

            case 6:
                itemList.add(new Item(R.drawable.img_021, "Ell","21","Sushi"));
                itemList.add(new Item(R.drawable.img_022, "Shrimp","22","Sushi"));
                itemList.add(new Item(R.drawable.img_023, "Crab stick","23","Sushi"));
                itemList.add(new Item(R.drawable.img_024, "Snapper","24","Sushi"));
                itemList.add(new Item(R.drawable.img_025, "Saumon","25","Sushi"));
                itemList.add(new Item(R.drawable.img_026, "White fish","26","Sushi"));
                itemList.add(new Item(R.drawable.img_027, "Saumon rose","27","Sushi"));
                itemList.add(new Item(R.drawable.img_028, "Makel","28","Sushi"));
                itemList.add(new Item(R.drawable.img_029, "Crab stick","29","Sushi"));
                itemList.add(new Item(R.drawable.img_030, "Miso sopue","30","Sushi"));
                itemList.add(new Item(R.drawable.img_031, "Kim chi","31","Sushi"));
                itemList.add(new Item(R.drawable.img_032, "Seaweek salad","32","Sushi"));
                itemList.add(new Item(R.drawable.img_033, "Green salad","33","Sushi"));
                itemList.add(new Item(R.drawable.img_034, "House salad","34","Sushi"));
                itemList.add(new Item(R.drawable.img_035, "Seafood salad","35","Sushi"));
                itemList.add(new Item(R.drawable.img_036, "Kim chi Tofu salad","36","Sushi"));
                itemList.add(new Item(R.drawable.img_037, "Cool tofu","37","Sushi"));
                itemList.add(new Item(R.drawable.img_038, "Soya bean","38","Sushi"));
                itemList.add(new Item(R.drawable.img_039, "Soya bean","39","Sushi"));
                break;

            case 7:
                itemList.add(new Item(R.drawable.img_021, "Ell","21","Sushi"));
                itemList.add(new Item(R.drawable.img_022, "Shrimp","22","Sushi"));
                itemList.add(new Item(R.drawable.img_023, "Crab stick","23","Sushi"));
                itemList.add(new Item(R.drawable.img_024, "Snapper","24","Sushi"));
                itemList.add(new Item(R.drawable.img_025, "Saumon","25","Sushi"));
                itemList.add(new Item(R.drawable.img_026, "White fish","26","Sushi"));
                itemList.add(new Item(R.drawable.img_027, "Saumon rose","27","Sushi"));
                itemList.add(new Item(R.drawable.img_028, "Makel","28","Sushi"));
                itemList.add(new Item(R.drawable.img_029, "Crab stick","29","Sushi"));
                itemList.add(new Item(R.drawable.img_030, "Miso sopue","30","Sushi"));
                itemList.add(new Item(R.drawable.img_031, "Kim chi","31","Sushi"));
                itemList.add(new Item(R.drawable.img_032, "Seaweek salad","32","Sushi"));
                itemList.add(new Item(R.drawable.img_033, "Green salad","33","Sushi"));
                itemList.add(new Item(R.drawable.img_034, "House salad","34","Sushi"));
                itemList.add(new Item(R.drawable.img_035, "Seafood salad","35","Sushi"));
                itemList.add(new Item(R.drawable.img_036, "Kim chi Tofu salad","36","Sushi"));
                itemList.add(new Item(R.drawable.img_037, "Cool tofu","37","Sushi"));
                itemList.add(new Item(R.drawable.img_038, "Soya bean","38","Sushi"));
                itemList.add(new Item(R.drawable.img_039, "Soya bean","39","Sushi"));
                break;

            case 8:
                itemList.add(new Item(R.drawable.img_021, "Ell","21","Sushi"));
                itemList.add(new Item(R.drawable.img_022, "Shrimp","22","Sushi"));
                itemList.add(new Item(R.drawable.img_023, "Crab stick","23","Sushi"));
                itemList.add(new Item(R.drawable.img_024, "Snapper","24","Sushi"));
                itemList.add(new Item(R.drawable.img_025, "Saumon","25","Sushi"));
                itemList.add(new Item(R.drawable.img_026, "White fish","26","Sushi"));
                itemList.add(new Item(R.drawable.img_027, "Saumon rose","27","Sushi"));
                itemList.add(new Item(R.drawable.img_028, "Makel","28","Sushi"));
                itemList.add(new Item(R.drawable.img_029, "Crab stick","29","Sushi"));
                itemList.add(new Item(R.drawable.img_030, "Miso sopue","30","Sushi"));
                itemList.add(new Item(R.drawable.img_031, "Kim chi","31","Sushi"));
                itemList.add(new Item(R.drawable.img_032, "Seaweek salad","32","Sushi"));
                itemList.add(new Item(R.drawable.img_033, "Green salad","33","Sushi"));
                itemList.add(new Item(R.drawable.img_034, "House salad","34","Sushi"));
                itemList.add(new Item(R.drawable.img_035, "Seafood salad","35","Sushi"));
                itemList.add(new Item(R.drawable.img_036, "Kim chi Tofu salad","36","Sushi"));
                itemList.add(new Item(R.drawable.img_037, "Cool tofu","37","Sushi"));
                itemList.add(new Item(R.drawable.img_038, "Soya bean","38","Sushi"));
                itemList.add(new Item(R.drawable.img_039, "Soya bean","39","Sushi"));
                break;

            case 9:
                itemList.add(new Item(R.drawable.img_021, "Ell","21","Sushi"));
                itemList.add(new Item(R.drawable.img_022, "Shrimp","22","Sushi"));
                itemList.add(new Item(R.drawable.img_023, "Crab stick","23","Sushi"));
                itemList.add(new Item(R.drawable.img_024, "Snapper","24","Sushi"));
                itemList.add(new Item(R.drawable.img_025, "Saumon","25","Sushi"));
                itemList.add(new Item(R.drawable.img_026, "White fish","26","Sushi"));
                itemList.add(new Item(R.drawable.img_027, "Saumon rose","27","Sushi"));
                itemList.add(new Item(R.drawable.img_028, "Makel","28","Sushi"));
                itemList.add(new Item(R.drawable.img_029, "Crab stick","29","Sushi"));
                itemList.add(new Item(R.drawable.img_030, "Miso sopue","30","Sushi"));
                itemList.add(new Item(R.drawable.img_031, "Kim chi","31","Sushi"));
                itemList.add(new Item(R.drawable.img_032, "Seaweek salad","32","Sushi"));
                itemList.add(new Item(R.drawable.img_033, "Green salad","33","Sushi"));
                itemList.add(new Item(R.drawable.img_034, "House salad","34","Sushi"));
                itemList.add(new Item(R.drawable.img_035, "Seafood salad","35","Sushi"));
                itemList.add(new Item(R.drawable.img_036, "Kim chi Tofu salad","36","Sushi"));
                itemList.add(new Item(R.drawable.img_037, "Cool tofu","37","Sushi"));
                itemList.add(new Item(R.drawable.img_038, "Soya bean","38","Sushi"));
                itemList.add(new Item(R.drawable.img_039, "Soya bean","39","Sushi"));
                break;

            case 10:
                itemList.add(new Item(R.drawable.img_021, "Ell","21","Sushi"));
                itemList.add(new Item(R.drawable.img_022, "Shrimp","22","Sushi"));
                itemList.add(new Item(R.drawable.img_023, "Crab stick","23","Sushi"));
                itemList.add(new Item(R.drawable.img_024, "Snapper","24","Sushi"));
                itemList.add(new Item(R.drawable.img_025, "Saumon","25","Sushi"));
                itemList.add(new Item(R.drawable.img_026, "White fish","26","Sushi"));
                itemList.add(new Item(R.drawable.img_027, "Saumon rose","27","Sushi"));
                itemList.add(new Item(R.drawable.img_028, "Makel","28","Sushi"));
                itemList.add(new Item(R.drawable.img_029, "Crab stick","29","Sushi"));
                itemList.add(new Item(R.drawable.img_030, "Miso sopue","30","Sushi"));
                itemList.add(new Item(R.drawable.img_031, "Kim chi","31","Sushi"));
                itemList.add(new Item(R.drawable.img_032, "Seaweek salad","32","Sushi"));
                itemList.add(new Item(R.drawable.img_033, "Green salad","33","Sushi"));
                itemList.add(new Item(R.drawable.img_034, "House salad","34","Sushi"));
                itemList.add(new Item(R.drawable.img_035, "Seafood salad","35","Sushi"));
                itemList.add(new Item(R.drawable.img_036, "Kim chi Tofu salad","36","Sushi"));
                itemList.add(new Item(R.drawable.img_037, "Cool tofu","37","Sushi"));
                itemList.add(new Item(R.drawable.img_038, "Soya bean","38","Sushi"));
                itemList.add(new Item(R.drawable.img_039, "Soya bean","39","Sushi"));
                break;

            case 11:
                itemList.add(new Item(R.drawable.img_021, "Ell","21","Sushi"));
                itemList.add(new Item(R.drawable.img_022, "Shrimp","22","Sushi"));
                itemList.add(new Item(R.drawable.img_023, "Crab stick","23","Sushi"));
                itemList.add(new Item(R.drawable.img_024, "Snapper","24","Sushi"));
                itemList.add(new Item(R.drawable.img_025, "Saumon","25","Sushi"));
                itemList.add(new Item(R.drawable.img_026, "White fish","26","Sushi"));
                itemList.add(new Item(R.drawable.img_027, "Saumon rose","27","Sushi"));
                itemList.add(new Item(R.drawable.img_028, "Makel","28","Sushi"));
                itemList.add(new Item(R.drawable.img_029, "Crab stick","29","Sushi"));
                itemList.add(new Item(R.drawable.img_030, "Miso sopue","30","Sushi"));
                itemList.add(new Item(R.drawable.img_031, "Kim chi","31","Sushi"));
                itemList.add(new Item(R.drawable.img_032, "Seaweek salad","32","Sushi"));
                itemList.add(new Item(R.drawable.img_033, "Green salad","33","Sushi"));
                itemList.add(new Item(R.drawable.img_034, "House salad","34","Sushi"));
                itemList.add(new Item(R.drawable.img_035, "Seafood salad","35","Sushi"));
                itemList.add(new Item(R.drawable.img_036, "Kim chi Tofu salad","36","Sushi"));
                itemList.add(new Item(R.drawable.img_037, "Cool tofu","37","Sushi"));
                itemList.add(new Item(R.drawable.img_038, "Soya bean","38","Sushi"));
                itemList.add(new Item(R.drawable.img_039, "Soya bean","39","Sushi"));
                break;
                default:

        }
    }
}
