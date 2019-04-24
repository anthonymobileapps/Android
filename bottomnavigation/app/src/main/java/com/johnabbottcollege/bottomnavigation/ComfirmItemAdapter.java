package com.johnabbottcollege.bottomnavigation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ComfirmItemAdapter extends RecyclerView.Adapter<ComfirmItemAdapter.ViewHolder> {

    Item item;

    private List<Item>itemList = new ArrayList<>();

    public ComfirmItemAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item_confirm,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        item = itemList.get(position);
        viewHolder.itemImage.setImageResource(item.getItemImageId());
        String number = item.getItemNumber();
        String name = item.getItemName();

        viewHolder.itemNumberAndNameTextView.setText(number + ". " + name);
        viewHolder.itemQuantity.setText(String.valueOf(item.getQuantity()));
    }

    @Override
    public int getItemCount() {
        if (itemList.size() != 0)
        return itemList.size();
        else
            return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemNumberAndNameTextView;
        TextView itemQuantity;
        ImageView addButton;
        ImageView minusButton;
        private String strQuantity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.imgv_confirm_id);
            itemNumberAndNameTextView = itemView.findViewById(R.id.tv_confirm_item_number_name);
            itemQuantity = itemView.findViewById(R.id.tv_confirm_quantity);
            addButton = itemView.findViewById(R.id.imageView_add_btn_confirm);
            minusButton = itemView.findViewById(R.id.imageView_minus_btn_confirm);


            addButton.setOnClickListener(new View.OnClickListener() {
                int quantity;
                @Override
                public void onClick(View v) {

                    quantity = Integer.parseInt((String) itemQuantity.getText());
                    quantity += 1;
                    itemQuantity.setText(String.valueOf(quantity));
                }
            });
            minusButton.setOnClickListener(new View.OnClickListener() {
                int quantity;
                @Override
                public void onClick(View v) {
                    quantity = Integer.parseInt((String) itemQuantity.getText());

                    if (quantity >0) {
                        quantity -= 1;
                        itemQuantity.setText(String.valueOf(quantity));
                    }

                }
            });
        }
    }

}
