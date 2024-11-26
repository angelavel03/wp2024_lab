package mk.finki.ukim.wp.lab.repository;

import mk.finki.ukim.wp.lab.model.Artist;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ArtistRepository {
    List<Artist> artists;

    public ArtistRepository() {
        artists = new ArrayList<>();
        artists.add(new Artist(1L,"a","b","c"));
        artists.add(new Artist(2L,"b","b","c"));
        artists.add(new Artist(3L,"c","a","c"));
        artists.add(new Artist(4L,"d","b","c"));
        artists.add(new Artist(5L,"da","bc","c"));

    }
    public List<Artist> findAll(){
        return artists;
    }
    public Optional<Artist> findById(Long id){
       return artists.stream().filter(artist -> artist.getId() == id).findFirst();
    }

}
