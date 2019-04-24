package com.johnabbottcollege.bottomnavigation;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;



public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    public static final String TAG = "CategoryAdapter.TAG";
    private List<Item> itemList;

    Context context;

    public CategoryAdapter(Context context, List<Item> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    public CategoryAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (context == null){

            context = parent.getContext();
        }
        // parent.getContext() can replace by context (Context context)
        // food_item = cell
        // parent.getContext() replace by context
        // if u don't have context, use parent.getContext()
        View view = LayoutInflater.from(context).inflate(R.layout.food_item_category,parent, false);

        final ViewHolder holder = new ViewHolder(view);

        holder.item_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = holder.getAdapterPosition();
                Item item = itemList.get(index);
                Intent intent = new Intent(v.getContext(),DetailActivity.class);
                intent.putExtra("item_object", item);
                v.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Item item = itemList.get(position);
        viewHolder.itemImage.setImageResource(item.getItemImageId());
        String itemName = (item.getItemName());
        String itemNumber= (item.getItemNumber());
        viewHolder.itemNumberAndName.setText(itemNumber + ". " + itemName);
        Glide.with(context).load(item.getItemImageId()).into(viewHolder.itemImage);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        private ImageView itemImage;
        private TextView itemNumberAndName;


        // when onclick event. Blinding cell parent layout  to the viewholder
        private CardView item_contact;

        public ViewHolder(@NonNull View view) {
            super(view);
            // the id store in the cell


            // home menu activity properties
            cardView = (CardView) view;
            itemImage = view.findViewById(R.id.img_item_category);
            // cell parent layout id
            item_contact = view.findViewById(R.id.item_category_cardviewlayout);

            // category activity properties
            itemNumberAndName = view.findViewById(R.id.tv_item_number_name_category);



        }
    }
}
