package mk.finki.ukim.wp.lab.service;

import mk.finki.ukim.wp.lab.model.Artist;
import mk.finki.ukim.wp.lab.model.Song;

import java.util.List;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
     Song findByTrackId(String trackId);
     List<Song>search(String text);
    void addSong(String title, String trackId, String genre, Integer releaseYear, Long albumId);
    Song findSongById(Long id);
}
