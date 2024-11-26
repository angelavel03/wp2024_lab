package mk.finki.ukim.wp.lab.repository;

import mk.finki.ukim.wp.lab.model.Album;
import mk.finki.ukim.wp.lab.model.Artist;
import mk.finki.ukim.wp.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class SongRepository {
    List<Song> songs;

    public SongRepository() {
        songs = new ArrayList<>();
        songs.add(new Song("a","stitle1","rock",2002,
                new Album(1L, "Album11", "Genre11", "2003")));
        songs.add(new Song("b","title2","pop",2012,
                new Album(2L, "Album12", "Genre12", "2011")));
        songs.add(new Song("c","stitle3","jazz",1987,
                new Album(3L, "Album13", "Genre13", "1987")));
        songs.add(new Song("d","title4","pop",2020,
                new Album(4L, "Album14", "Genre14", "2021")));
        songs.add(new Song("e","title5","rock",1998,
                new Album(5L, "Album15", "Genre15", "1998")));
    }
    public List<Song> findAll(){
        return songs;
    }
    public Song findByTrackId(String trackId){
         return songs.stream().filter(song -> song.getTrackId().equals(trackId)).findFirst().orElse(null);
    }

    public Artist addArtistToSong(Artist artist, Song song){
        song.getPerformers().add(artist);
        return artist;

    }
    public List <Song> searchText(String text){
        return songs.stream().filter(song -> song.getTitle().toUpperCase().contains(text.toUpperCase())).collect(Collectors.toList());
    }

    public void save(Song song) {
        songs.add(song);
    }
    public Song findById(Long id) {
        return songs
                .stream()
                .filter(song -> Objects.equals(song.getId(), id))
                .findFirst()
                .orElse(null);
    }
}
