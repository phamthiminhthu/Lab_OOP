package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks;

    @Override
    public void play() {
        System.out.println("Artist: " + this.artist);
        System.out.println("Director: " + this.getDirector());
        System.out.println("Number of tracks: " + this.tracks.size());
        System.out.println("Length: " + this.getLength());
        for (Track track: tracks){
            track.play();
        }
    }

    public CompactDisc(String title, String category, float cost, int length, String director, String artist, ArrayList<Track> tracks) {
        super(title, category, cost, length, director);
        this.artist = artist;
        this.tracks = tracks;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (this.tracks.contains(track)) {
            System.out.println("Track existed!");
            return;
        }
        this.tracks.add(track);
    }

    public void removeTrack(Track track) {
        if (this.tracks.contains(track)) {
            this.tracks.remove(track);
            return;
        }
        System.out.println("Don't exist!");
    }

    public int getLength(){
        int length = 0;
        for(int i = 0; i < this.tracks.size(); i++){
            length += this.tracks.get(i).getLength();
        }
        return length;

    }
}
