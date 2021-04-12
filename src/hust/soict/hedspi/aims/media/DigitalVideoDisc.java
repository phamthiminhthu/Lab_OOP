package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.media.Media;

import java.util.Locale;

public class DigitalVideoDisc extends Disc implements Playable{

    public DigitalVideoDisc(String title, String category, int length, String director) {
        super(title, category, length, director);
    }

    public boolean search(String title) {
        title = title.toLowerCase().trim();
        String thisTitle = this.getTitle().toLowerCase().trim();
        String[] titleSplitted = title.split(" ");
        String[] thisTitleSplitted = thisTitle.split(" ");
        for(String t: titleSplitted) {
            boolean check = false;
            for(String thisT: thisTitleSplitted) {
                if (thisT.equals(t)) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void play() {
        System.out.println("Playing DVD : " + this.getTitle());
        System.out.println("DVD length : " + this.getLength());
    }
}
