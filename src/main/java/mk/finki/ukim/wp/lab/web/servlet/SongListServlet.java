//package mk.finki.ukim.wp.lab.web.servlet;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.wp.lab.model.Song;
//import mk.finki.ukim.wp.lab.service.SongService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.util.*;
//
//@WebServlet(name = "SongListServlet",urlPatterns = "/listSongs")
//public class SongListServlet extends HttpServlet {
//    public final SpringTemplateEngine springTemplateEngine;
//    private final SongService serviceSong;
//
//    public SongListServlet(SongService serviceSong, SpringTemplateEngine springTemplateEngine) {
//        this.springTemplateEngine = springTemplateEngine;
//        this.serviceSong = serviceSong;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//
//        WebContext context = new WebContext(webExchange);
//        context.setVariable("songs",serviceSong.listSongs());
//        springTemplateEngine.process("listSongs.html",context,resp.getWriter());
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//
//        WebContext context = new WebContext(webExchange);
//
//        String text = req.getParameter("text");
//        List<Song> searchedSongs = serviceSong.search(text);
//
//        context.setVariable("songs", searchedSongs);
//        springTemplateEngine.process("listSongs.html",context,resp.getWriter());
//    }
//}
