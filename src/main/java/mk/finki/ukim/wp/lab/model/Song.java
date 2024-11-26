package mk.finki.ukim.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter

public class Song {
    private String trackId;
    private String title;
    private String genre;
    private int releaseYear;
    private Long id;
    private Album album;

    public Song(String trackId, String title, String genre, int releaseYear, Album album) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = new ArrayList<>();
        this.id = (long) (Math.random() * 1000);
        this.album = album;
    }

    public List<Artist> performers;

    @Override
    public String toString() {
        return String.format("Title: <%s>, Genre:<%s>, Release Year: <%d>, Album:<%s>", title, genre, releaseYear, album.getName());
    }
}
