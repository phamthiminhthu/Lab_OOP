package hust.soict.hedspi.garbage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GarbageCreator {
    public static void garbage() {
        try {
            FileReader fr = new FileReader("/Users/minhthu/Documents/Intelji/AimsProject/resource/text.txt");
            BufferedReader br = new BufferedReader(fr);
//            StringBuffer str = new StringBuffer();
            String b = " ";
            String a;
            while ((a = br.readLine()) != null) {
//                str.append("\n").append(a);
                b += a;

            }
            System.out.println(b);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void NoGarbage() {
        try {
            FileReader fr = new FileReader("/Users/minhthu/Documents/Intelji/AimsProject/resource/text.txt");
            BufferedReader br = new BufferedReader(fr);
            StringBuffer str = new StringBuffer();
            String a;
            while (( a = br.readLine()) != null) {
                str.append("\n").append(a);
            }
            System.out.println(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        System.out.println("Garbage : ");
        garbage();
        System.out.println("No garbage : ");
        NoGarbage();
    }


}
