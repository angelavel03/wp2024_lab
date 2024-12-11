package mk.finki.ukim.wp.lab.repository;

import mk.finki.ukim.wp.lab.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    Song findByTrackId(String trackId);
}
