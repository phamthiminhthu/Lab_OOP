package hust.soict.hedspi.aims.utils;

import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class DateUtils {
    public static void compareDate(Date date1, Date date2){
        if(date1.compareTo(date2) > 0){
            System.out.println("Date1 comes after date2");
        }
        else if(date1.compareTo(date2) < 0){
            System.out.println("Date2 comes after date1");
        }else {
            System.out.println("Both date are equals");
        }
    }

    public static void sortDate(ArrayList<LocalDate> list_date){
        DateTimeFormatter dateFormat=DateTimeFormatter.ofPattern("dd-MM-yyyy");

        Collections.sort(list_date);
        for(LocalDate localDate : list_date){
            System.out.println(dateFormat.format(localDate));

        }
    }

    public static void main(String[] args) {

        ArrayList<LocalDate> datelist = new ArrayList<LocalDate>();
        datelist.add(LocalDate.of(2002, 2, 22));
        datelist.add(LocalDate.of(2017, 9, 30));
        datelist.add(LocalDate.of(2000, 1, 1));
        datelist.add(LocalDate.of(2000, 1, 3));
        datelist.add(LocalDate.of(2015, 8, 27));
        datelist.add(LocalDate.of(2015, 8, 28));
        sortDate(datelist);
    }
}
