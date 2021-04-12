package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.order.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Aims {
    public static void showMenu() {
        Scanner sc = new Scanner(System.in);
        int choose;
        Order order = null;
        do {
            System.out.println("Order Management Application: ");
            System.out.println("--------------------------------");
            System.out.println("1. Create new order");
            System.out.println("2. Add item to the order");
            System.out.println("3. Delete item by id");
            System.out.println("4. Display the items list of order");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");
            choose = sc.nextInt();

            switch (choose) {
                case 0:
                    break;
                case 1:
                    if (Order.available()) {
                        order = new Order();
                    } else {
                        System.out.println("Full order!");
                    }
                    break;
                case 2:
                    int idMedia;
                    int choose1;
                    sc = new Scanner(System.in);
                    do {
                        System.out.println("TYPE: ");
                        System.out.println("1. Book");
                        System.out.println("2. Digital video disc ");
                        System.out.println("3. Compact disc");
                        System.out.println("0. Exit");
                        System.out.println(" Input item to add : ");
                        choose1 = sc.nextInt();
                        switch (choose1) {
                            case 1:
                                int idBook;
                                do {
                                    System.out.println("Input ID book : ");
                                    idBook = sc.nextInt();
                                    if (!Book.class.isAssignableFrom(Media.getMedia(idBook).getClass())) {
                                        System.out.println("This is not book");
                                    }
                                    if (idBook <= 0 || idBook > Media.getListMedia().size()) {
                                        System.out.println("Don't existed ID");
                                    }

                                } while (idBook <= 0 || idBook > Media.getListMedia().size() || (!Book.class.isAssignableFrom(Media.getMedia(idBook).getClass())));
                                order.addMedia(Media.getMedia(idBook));
                                break;
                            case 2:
                                int idDisc;
                                do {
                                    System.out.println("Input ID digital video disc : ");
                                    idDisc = sc.nextInt();
                                    if (!DigitalVideoDisc.class.isAssignableFrom(Media.getMedia(idDisc).getClass())) {
                                        System.out.println("This is not dvd");
                                    }
                                    if (idDisc <= 0 || idDisc > Media.getListMedia().size()) {
                                        System.out.println("Don't existed ID");
                                    }

                                } while (idDisc <= 0 || idDisc > Media.getListMedia().size() || (!DigitalVideoDisc.class.isAssignableFrom(Media.getMedia(idDisc).getClass())));
                                int choosePlay;
                                order.addMedia(Media.getMedia(idDisc));
                                System.out.println("Do you play DVD ?");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                System.out.print("Input your choose: ");
                                choosePlay = sc.nextInt();
                                switch (choosePlay) {
                                    case 1:
                                        ((DigitalVideoDisc) Media.getMedia(idDisc)).play();
                                        break;
                                    case 2:
                                        break;
                                }
                                break;
                            case 3:
                                int idCompactDisc;
                                do {
                                    System.out.println("Input ID Compact Disc : ");
                                    idCompactDisc = sc.nextInt();
                                    if (!CompactDisc.class.isAssignableFrom(Media.getMedia(idCompactDisc).getClass())) {
                                        System.out.println("This is not Compact Disc");
                                    }
                                    if (idCompactDisc <= 0 || idCompactDisc > Media.getListMedia().size()) {
                                        System.out.println("Don't existed ID");
                                    }

                                } while (idCompactDisc <= 0 || idCompactDisc > Media.getListMedia().size() || (!CompactDisc.class.isAssignableFrom(Media.getMedia(idCompactDisc).getClass())));
                                order.addMedia(Media.getMedia(idCompactDisc));
                                System.out.println("Do you play DVD ?");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                System.out.print("Input your choose: ");
                                choosePlay = sc.nextInt();
                                switch (choosePlay) {
                                    case 1:
                                        ((CompactDisc) Media.getMedia(idCompactDisc)).play();
                                        break;
                                    case 2:
                                        break;
                                }

                                break;
                            case 0:
                                break;
                        }

                    } while (choose1 != 0);
                    break;
                case 3:
                    int idRemove;
                    do {
                        System.out.println("Input id of media : ");
                        idRemove = sc.nextInt();
                        if (0 >= idRemove || idRemove > Media.getListMedia().size()) {
                            System.out.println("Media doesn't exist to delete!");
                        }
                    } while (0 >= idRemove || idRemove > Media.getListMedia().size());
                    Media media1 = null;
                    order.removeMedia(media1.getMedia(idRemove));
                    break;

                case 4:
                    order.showListOrder();
                    break;

            }


        } while (choose != 0);


    }

    public static void main(String[] args) {
        MemoryDaemon memoryDaemon = new MemoryDaemon();
        Thread thread = new Thread(memoryDaemon);
        thread.setDaemon(true);
        thread.start();

        Book book1 = new Book("minh thu1", "abc1", new ArrayList<>(Arrays.asList("Minh1", " Hai Long1")));
        Book book2 = new Book("minh thu2", "abc2", new ArrayList<>(Arrays.asList("Minh2", " Hai Long2")));
        Book book3 = new Book("minh thu3", "abc3", new ArrayList<>(Arrays.asList("Minh3", " Hai Long3")));
        Book book4 = new Book("minh thu4", "abc4", new ArrayList<>(Arrays.asList("Minh4", " Hai Long4")));
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("dvd1", "abc1", 30, "xyz1");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("dvd2", "abc2", 30, "xyz2");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("dvd3", "abc3", 30, "xyz3");
        CompactDisc cd1 = new CompactDisc("cd1", "abc1", 40, "xyz1", "ght1", new ArrayList<Track>(Arrays.asList(new Track("123", 30), new Track("789", 56))));
        CompactDisc cd2 = new CompactDisc("cd2", "abc2", 40, "xyz2", "ght2", new ArrayList<Track>(Arrays.asList(new Track("123", 30), new Track("789", 56))));
        CompactDisc cd3 = new CompactDisc("cd3", "abc3", 40, "xyz3", "ght3", new ArrayList<Track>(Arrays.asList(new Track("123", 30), new Track("789", 56))));
        showMenu();


    }

}