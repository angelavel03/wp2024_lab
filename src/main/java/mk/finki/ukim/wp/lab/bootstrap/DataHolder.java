package mk.finki.ukim.wp.lab.bootstrap;;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.wp.lab.model.Album;
import mk.finki.ukim.wp.lab.model.Artist;
import mk.finki.ukim.wp.lab.model.Song;
import mk.finki.ukim.wp.lab.repository.AlbumRepository;
import mk.finki.ukim.wp.lab.repository.ArtistRepository;
import mk.finki.ukim.wp.lab.repository.SongRepository;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataHolder {
    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;

    public DataHolder(SongRepository songRepository, ArtistRepository artistRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
    }

    @PostConstruct
    public void init() {
        for (int i = 0; i < 5; i++) {
            artistRepository.save(new Artist("Firstname" + i,
                    "Lastname" + i, "Bio" + i));
        }
        for (int i = 0; i < 5; i++) {
            int randomYear = 1999 + (int)(Math.random() * 2024 - 1999) + 1;
            albumRepository.save(new Album("Album" + i, "Genre" + i, Integer.toString(randomYear)));
        }
        for (int i = 0; i < 5; i++) {
            int randomYear = 1999 + (int)(Math.random() * 2024 - 1999) + 1;
            long randomAlbumId = (int)(Math.random() * 5) + 1;
            songRepository.save(new Song("TrackId" + i, "SongTitle" + i,
                    "Genre" + i, randomYear, albumRepository.findById(randomAlbumId).orElse(null)));
        }
//        List<Song> songs = songRepository.findAll();
//        List<Artist> artists = artistRepository.findAll();
//        List<Album> albums = albumRepository.findAll();
    }
}
