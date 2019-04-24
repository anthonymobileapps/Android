package com.johnabbottcollege.bottomnavigation;


import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {

    private int itemImageId;
    private  String itemImage;
    private String itemName;
    private String itemNumber;
    private String category;
    private int quantity = 0;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item(int itemImageId, String itemImage, String itemName, String itemNumber, String category) {
        this.itemImageId = itemImageId;
        this.itemImage = itemImage;
        this.itemName = itemName;
        this.itemNumber = itemNumber;
        this.category = category;
    }

    public Item(int itemImageId, String itemName, String itemNumber, int quantity) {
        this.itemImageId = itemImageId;
        this.itemName = itemName;
        this.itemNumber = itemNumber;
        this.quantity = quantity;
    }

    // itemImageId is the image id that image store in drawable folder
    public Item(int itemImageId, String category) {
        this.itemImageId = itemImageId;
        this.category = category;
    }

    public Item(int itemImageId, String itemName, String itemNumber) {
        this.itemImageId = itemImageId;
        this.itemName = itemName;
        this.itemNumber = itemNumber;
    }

    public Item(int itemImageId, String itemName, String itemNumber, String category) {
        this.itemImageId = itemImageId;
        this.itemName = itemName;
        this.itemNumber = itemNumber;
        this.category = category;
    }

    public Item() {
    }

    protected Item(Parcel in) {
        itemImageId = in.readInt();
        itemImage = in.readString();
        itemName = in.readString();
        itemNumber = in.readString();
        category = in.readString();
        quantity = in.readInt();

    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public int getItemImageId() {
        return itemImageId;
    }

    public void setItemImageId(int itemImageId) {
        this.itemImageId = itemImageId;
    }

    public Item(String itemImage, String itemName, String itemNumber, String category) {
        this.itemImage = itemImage;
        this.itemName = itemName;
        this.itemNumber = itemNumber;
        this.category = category;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(itemImageId);
        dest.writeString(itemImage);
        dest.writeString(itemName);
        dest.writeString(itemNumber);
        dest.writeString(category);
        dest.writeInt(quantity);
    }
    @Override
    public String toString() {
        return "Item{" +
                "itemImageId=" + itemImageId +
                ", itemImage='" + itemImage + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemNumber='" + itemNumber + '\'' +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                '}';
    }

}
