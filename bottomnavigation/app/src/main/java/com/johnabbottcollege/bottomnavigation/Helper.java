package com.johnabbottcollege.bottomnavigation;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Helper {


    public  String getCurrentTime(){

        Date date = new Date();
        String strDateFormat = "dd/MM/yy HH:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate= dateFormat.format(date);
        System.out.println("Current time of the day using Date - 12 hour format: " + formattedDate);
        return formattedDate;
    }

    public String converArrayToString(ArrayList<Item> list){

        String tempString = "";

        for (Item temp : list) {
            String itemNum = temp.getItemNumber();
            String itemName = temp.getItemName();
            String itemQuantity = String.valueOf(temp.getQuantity());
            tempString += itemNum + ". " + itemName + " x " + itemQuantity + "\n";
        }
        return tempString ;

    }
}
