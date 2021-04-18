package hust.soict.hedspi.aims.media;

import java.util.*;

public class TestMediaCompareTo {

    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("dvd1", "abc1", 30, 40,"xyz1");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("dvd2", "abc2", 32,50, "xyz2");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("dvd3", "abc3", 31,60, "xyz3");

       ArrayList<Media> itemsOrdered = new ArrayList();
        itemsOrdered.add(dvd1);
        itemsOrdered.add(dvd2);
        itemsOrdered.add(dvd3);

        Iterator iterator = itemsOrdered.iterator();
        System.out.println("------------------------------");
        System.out.println("The DVDs currently in the order : ");

        while (iterator.hasNext()){
            System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
        }

        Collections.sort((List)itemsOrdered);

        iterator = itemsOrdered.iterator();
        System.out.println("------------------------------");
        System.out.println("The DVDs currently in the order : ");

        while (iterator.hasNext()){
            System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
        }

    }
}
