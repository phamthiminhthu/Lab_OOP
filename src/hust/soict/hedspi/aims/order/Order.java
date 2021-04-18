package hust.soict.hedspi.aims.order;


import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Order {
    public static final int MAX_NUMBERS_ORDER = 10;
    public static final int MAX_LIMITED_ORDERS = 5;
    private static int nbOrders = 0;
    private Date dateOrdered;
    private DigitalVideoDisc luckyItems;
    ArrayList<Media> itemsOrdered = new ArrayList<>();
    // order : hoa don
    // digitalVideoDict : thong tin cua 1 dia

    public Order() {
        Order.nbOrders += 1;
        this.dateOrdered = new Date();
        this.luckyItems = null;
    }

    public static boolean available() {
        return Order.nbOrders < Order.MAX_LIMITED_ORDERS;
    }

    public Date getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(Date dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public float totalCost() {
        float total = 0;
        for (Media media : this.itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void addMedia(Media media){
        if(itemsOrdered.size() < MAX_NUMBERS_ORDER) {
            itemsOrdered.add(media);
            System.out.println("add successfully");
        }else{
            System.out.println("Order limited ! Can not add ");
        }

    }

    public void removeMedia(Media media){
        int count = 0;
        while(this.itemsOrdered.remove(media)){
            ++count;
        };
        if(count == 0){
            System.out.println("media don't exist");
        }else {
            System.out.println("DELETE SUCCESSFULLY " + count + "items");
        }
    }

    public void showListOrder(){
        for(Media item : itemsOrdered){
            System.out.println(item.getTitle());
        }
    }
}
