package mk.finki.ukim.wp.lab.web.controller;

import mk.finki.ukim.wp.lab.model.Artist;
import mk.finki.ukim.wp.lab.model.Song;
import mk.finki.ukim.wp.lab.service.ArtistSerivce;
import mk.finki.ukim.wp.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/songDetails")
public class SongDetailsController {
    private final SongService songService;
    private final ArtistSerivce artistService;

    public SongDetailsController(SongService songService, ArtistSerivce artistService) {
        this.songService = songService;
        this.artistService = artistService;
    }

    @GetMapping
    public String getSongDetails(@RequestParam(name = "id") Long id, Model model) {
        songService.findSongById(id).ifPresent(song -> model.addAttribute("song", song));
        return "songDetails";
    }

    @PostMapping("/ratesong")
    public String songDetails(
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "rating") float rating,
            Model model) {
        Song song = songService.findSongById(id).orElse(null);
        songService.rateSong(id, rating);
        model.addAttribute("song", song);
        return "redirect:/songDetails?id=" + id;
    }

    @PostMapping
    public String addArtistToSong(@RequestParam(name = "id") Long id,
                                  @RequestParam(name = "artistId") Long artistId,
                                  Model model) {
        Song song = songService.findSongById(id).orElse(null);
        Artist artist = artistService.findById(artistId);
        if(song != null) {
            if(song.getPerformers().contains(artist)) {
                model.addAttribute("error",
                        String.format("Artist %s is already reserved!", artist.getFirstName() + " " + artist.getLastName()));
                return "redirect:/artist?songId=" + song.getId();
            }
            else {
                song.addArtist(artist);
                songService.editSong(song);
                model.addAttribute("song", song);
            }
        }
        return "songDetails";
    }
}