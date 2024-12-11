package mk.finki.ukim.wp.lab.service;

import mk.finki.ukim.wp.lab.model.Artist;
import mk.finki.ukim.wp.lab.repository.ArtistRepository;

import java.util.List;

public interface ArtistSerivce {
    List<Artist> listArtists();
    Artist findById(Long id);
}
