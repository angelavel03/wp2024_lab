package mk.finki.ukim.wp.lab.web.controller;

import mk.finki.ukim.wp.lab.model.Artist;
import mk.finki.ukim.wp.lab.model.Song;
import mk.finki.ukim.wp.lab.service.ArtistSerivce;
import mk.finki.ukim.wp.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/artist")
public class ArtistController {
    private final ArtistSerivce artistService;
    private final SongService songService;

    public ArtistController(ArtistSerivce artistService, SongService songService) {
        this.artistService = artistService;
        this.songService = songService;
    }

    @GetMapping
    public String getArtists(@RequestParam(name = "songId") Long songId, Model model) {
        Song song = songService.findSongById(songId).orElse(null);
        List<Artist> artists = artistService.listArtists();
        model.addAttribute("song", song);
        model.addAttribute("artists", artists);
        return "artistsList";
    }
}