package com.johnabbottcollege.bottomnavigation;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemRecentsAdapter extends RecyclerView.Adapter<ItemRecentsAdapter.ViewHolder> {

    public static final String TAG = "ItemAdapter";
    public ArrayList<String>list;

    String stringItem;


    public ItemRecentsAdapter(ArrayList<String> list){
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // parent.getContext() can replace by context (Context context)
        // food_item = cell

        View view = LayoutInflater.from( parent.getContext()).inflate(R.layout.food_item_recents,parent, false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        stringItem = list.get(position);

        viewHolder.eachOrderSummary.setText(stringItem);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        private TextView eachOrderSummary;
        private LinearLayout item_contact;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // the id store in the cell
            // cell parent layout id
            item_contact = itemView.findViewById(R.id.recents_item_recylecell_id);

            eachOrderSummary = itemView.findViewById(R.id.tv_recents_cell);


        }
    }
}


