package com.johnabbottcollege.bottomnavigation;




import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    public static final String TAG = "ItemAdapter";
    private List<Item> itemList;
    public ArrayList<String>list;

    Context context;
    String category;


    public ItemAdapter(Context context, List<Item> itemList) {
        this.itemList = itemList;
        this.context = context;
    }
    public ItemAdapter(ArrayList<String> list){
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // parent.getContext() can replace by context (Context context)
        // food_item = cell

        // parent.getContext() replace by context
        View view = LayoutInflater.from(context).inflate(R.layout.food_item,parent, false);
         final ViewHolder holder = new ViewHolder(view);


        holder.item_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = holder.getAdapterPosition();
                Intent intent = new Intent(v.getContext(),CategoryActivity.class);
                intent.putExtra("int_data", index);
                v.getContext().startActivity(intent);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Item item = itemList.get(position);
        viewHolder.itemImage.setImageResource(item.getItemImageId());
        viewHolder.itemCategory.setText(item.getCategory());
        category = item.getCategory();
       }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView itemImage;
        private TextView itemCategory;

        private TextView itemNumber;
        private TextView itemName;

        private ConstraintLayout item_contact;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // the id store in the cell
            // home menu activity properties
            itemImage = itemView.findViewById(R.id.item_image_iv);
            itemCategory = itemView.findViewById(R.id.item_category_tv);

            // cell parent layout id ***************************************
            item_contact = itemView.findViewById(R.id.home_item_recylecell_id);

            // category activity properties
            itemName = itemView.findViewById(R.id.tv_itemName);
            itemNumber = itemView.findViewById(R.id.tv_itemNumber);

        }
    }
}
