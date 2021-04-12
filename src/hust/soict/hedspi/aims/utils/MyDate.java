package hust.soict.hedspi.aims.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class MyDate {
    private int day
            ;
    private int month;
    private int year;

    public MyDate() {
        LocalDate currentdate = LocalDate.now();
        this.day = currentdate.getDayOfMonth();
        this.month = currentdate.getMonthValue();
        this.year = currentdate.getYear();
    }

    public MyDate(int date, int month, int year) {
        this.day = date;
        this.month = month;
        this.year = year;
    }

    public MyDate(String my_date) {
        String[] mydate = my_date.split(" ");
        mydate[1] = mydate[1].substring(0, mydate[1].length() - 2);
        my_date = (mydate[0] + " ").concat(mydate[1] + " ").concat(mydate[2]);
        try {
            //parse string to date
            Date date = new SimpleDateFormat("MMMM dd yyyy").parse(my_date);
            //lay tung truong
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            //set gia tri
            this.day = calendar.get(Calendar.DAY_OF_MONTH);
            this.month = calendar.get(Calendar.MONTH) + 1;
            this.year = calendar.get(Calendar.YEAR);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int convert_date_to_int(String date) {
        String[] day_string = {"first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth",
                "tenth", "eleventh", "twelve", "thirteenth", "fourteenth", "fifteenth", "sixteenth", "seventeenth",
                "eighteenth", "nineteenth", "twenty", "twenty-first", "twenty-second", "twenty-third", "twenty-fourth",
                "twenty-fifth", "twenty-sixth", "twenty-seventh", "twenty-eighth", "twenty-ninth", "thirty", "thirty-first"
        };
        for (int i = 0; i < day_string.length; i++) {
            if (date.equals(day_string[i])) {
                return (i + 1);
            }
        }

        return 0;
    }

    public int convert_month_to_int(String month) {
        try {
            Date date = new SimpleDateFormat("MMMM").parse(month);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.get(Calendar.MONTH);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;

    }

    public int convert_year_to_int(String year) {
        String[] array_number = year.split(" ");
        String number_year = " ";
        String unitsArray[] = {"zero", "one", "two", "three", "four", "five", "six",
                "seven", "eight", "nine", "ten", "eleven", "twelve",
                "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen"};
        String tensArray[] = {"zero", "ten", "twenty", "thirty", "forty", "fifty",
                "sixty", "seventy", "eighty", "ninety"};

        for (int i = 0; i < array_number.length; i++) {
            for (int j = 0; j < unitsArray.length; j++) {
                if (array_number[i].equals(unitsArray[j])) {
                    String r = String.valueOf(j);
                    number_year = number_year.concat(r);
                }
            }
            for (int k = 0; k < tensArray.length; k++) {
                if (array_number[i].equals(tensArray[k])) {
                    String h = String.valueOf(k * 10);
                    number_year = number_year.concat(h);
                }
            }
        }
        return Integer.parseInt(number_year.trim());


    }

    public MyDate(String date, String month, String year) {
        this.day = convert_date_to_int(date);
        this.month = convert_month_to_int(month);
        this.year = convert_year_to_int(year);


    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day > 0 && day <= 31) {
            this.day = day;
        } else {
            System.out.println("Invalid");
        }

    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month > 0 && month <= 12) {
            this.month = month;
        } else {
            System.out.println("Invalid");
        }

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > 0) {
            this.year = year;
        } else {
            System.out.println("Invalid");
        }

    }

    public void accept() {
        String input;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter input date : (eg : February 18th 2019,..)");
        input = sc.nextLine();
        MyDate myDate = new MyDate(input);
        this.day = myDate.getDay();
        this.month = myDate.getMonth();
        this.year = myDate.getYear();

    }

    public void print() {
//        MyDate myDate = new MyDate();
//        System.out.println(myDate.getDate() + " " + myDate.getMonth() + " " + myDate.getYear());
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd yyyy");
        String string_date = dateFormat.format(date);
        String[] array_date = string_date.split(" ");
        int a = Character.getNumericValue(array_date[1].charAt(array_date[1].length() - 1));
        for (int i = 1; i < 32; i++) {
            if (a == i && a != 1 && a != 3 && a != 2) {
                array_date[1] = array_date[1].concat("th");
            }
            if (a == i && a == 1) {
                array_date[1] = array_date[1].concat("st");
            }
            if (a == i && a == 2) {
                array_date[1] = array_date[1].concat("nd");
            }
            if (a == i && a == 3) {
                array_date[1] = array_date[1].concat("rd");
            }
        }
        string_date = array_date[0].concat(" ").concat(array_date[1]).concat(" ").concat(array_date[2]);
        System.out.println(string_date);
    }

    public void choice_print_date(Date date) {
        int choice;
        SimpleDateFormat dateFormat;
        do {
            System.out.println("                Format               |           Example             ");
            System.out.println("1. yyyy-MM-dd                           |  1930-02-03                   ");
            System.out.println("2. d/M/yyyy                             |  3/2/1930                     ");
            System.out.println("3. dd-MMMM-yyyy                         |  03/Feb/1930                  ");
            System.out.println("4. MMMM d yyyy                          |  Feb 3 1930                   ");
            System.out.println("5. mm-dd-yyyy                           |  02-03-1930                   ");
            System.out.println("6. Exit");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter input choice : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    System.out.println(dateFormat.format(date));
                    break;
                case 2:
                    dateFormat = new SimpleDateFormat("d/M/yyyy");
                    System.out.println(dateFormat.format(date));
                    break;
                case 3:
                    dateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
                    System.out.println(dateFormat.format(date));
                    break;
                case 4:
                    dateFormat = new SimpleDateFormat("MMMM d yyyy");
                    System.out.println(dateFormat.format(date));
                    break;
                case 5:
                    dateFormat = new SimpleDateFormat("MM-dd-yyyy");
                    System.out.println(dateFormat.format(date));
                    break;
                case 6 :
                    System.exit(0);
                    break;

            }

        } while (choice != 6);
    }
}

