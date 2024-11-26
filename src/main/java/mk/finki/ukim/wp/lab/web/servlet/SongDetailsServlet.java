package mk.finki.ukim.wp.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.wp.lab.model.Artist;
import mk.finki.ukim.wp.lab.model.Song;
import mk.finki.ukim.wp.lab.service.ArtistSerivce;
import mk.finki.ukim.wp.lab.service.SongService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "SongDetailsServlet", urlPatterns = "/songDetails")
public class SongDetailsServlet extends HttpServlet {
    public final SpringTemplateEngine springTemplateEngine;
    public final SongService songService;
    public final ArtistSerivce artistService;

    public SongDetailsServlet(SpringTemplateEngine springTemplateEngine, SongService songService, ArtistSerivce artistSerivce) {
        this.springTemplateEngine = springTemplateEngine;
        this.songService = songService;
        this.artistService = artistSerivce;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);

        String trackId = req.getParameter("trackId");
        Song song = songService.findByTrackId(trackId);

        context.setVariable("song", song);
        springTemplateEngine.process("songDetails.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long artistId = Long.parseLong(req.getParameter("artistId"));
        String trackId = req.getParameter("trackId");

        Artist artist = artistService.ArtistfindById(artistId);
        Song song = songService.findByTrackId(trackId);

        songService.addArtistToSong(artist, song);
        resp.sendRedirect("/songDetails?trackId=" + trackId);
    }
}
