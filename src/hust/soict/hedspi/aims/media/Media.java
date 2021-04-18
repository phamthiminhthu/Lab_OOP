package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;


public abstract class Media implements Comparable<Media> {
    private static List<Media> listMedia = new ArrayList<>();
    private int id;
    private String title;
    private String category;
    private float cost;

    public static List<Media> getListMedia() {
        return listMedia;
    }


    public Media(String title, String category, float cost) {
        Media.listMedia.add(this);
        this.id = Media.listMedia.size();
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }



    public String getCategory() {
        return category;
    }



    public float getCost() {
        return cost;
    }



    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Media media = (Media) o;
        return id == media.id;
    }


    public static Media getMedia(int id) {
        return Media.listMedia.get(id - 1);
    }

    @Override
    public int compareTo(Media o) {
        //return this.title.compareTo(media.getTitle());
        return Float.compare(this.cost,o.getCost());
    }
}
