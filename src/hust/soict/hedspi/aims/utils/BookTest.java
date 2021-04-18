package hust.soict.hedspi.aims.utils;

import hust.soict.hedspi.aims.media.Book;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BookTest {
    public static void main(String[] args) {
        ArrayList<String> list_author = new ArrayList<>();
        list_author.add("minh thu 1");
        list_author.add("minh thu 2");

        Book book1 = new Book("minh thu1", "minh thu1", 30, list_author );
        book1.setContent("Long cho long heo long thu beo cho long heo beo con heo minh thu dep");
        System.out.println(book1);

    }
}
