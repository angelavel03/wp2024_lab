package mk.finki.ukim.wp.lab.service;

import mk.finki.ukim.wp.lab.model.Artist;
import mk.finki.ukim.wp.lab.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {
    List<Song> listSongs();
    Song findByTrackId(String trackId);
    Optional<Song> findSongById(Long id);
    List<Song> search(String text);
    void addSong(String title, String trackId, String genre, Integer releaseYear, Long albumId);
    void editSong(Song song);
    void deleteSong(Long songId);
    void rateSong(Long songId, float rating);
}
