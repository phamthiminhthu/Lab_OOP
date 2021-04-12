package hust.soict.hedspi.aims.media;

public class Disc extends Media{
    private int length;
    private String director;

    public Disc(String title, String category, int length, String director) {
        super(title, category);
        this.length = length;
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }
}
