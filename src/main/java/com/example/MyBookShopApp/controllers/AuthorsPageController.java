package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;

@Controller
@RequestMapping("/authors")
public class AuthorsPageController {

    private BookService bookService;

    @Autowired
    public AuthorsPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String reloadAuthors(Model model){
        model.addAttribute("bookList",bookService.getBookData());
        model.addAttribute("authors",bookService.getMapAuthors(bookService.getAuthorsList()));
        return "/authors/index";
    }

    @GetMapping("/genres")
    public String genresPage(){
        Logger.getLogger(MainPageController.class.getName()).info("Opened page genres");
        return "/genres/index.html";
    }

    @GetMapping("/bookshop")
    public String mainOpen(Model model){
        Logger.getLogger(GenresPageController.class.getName()).info("Back on the main-page");
        model.addAttribute("bookData", bookService.getBookData());
        return "index.html";
    }
    /*@GetMapping("/authors")
    public String authorPage(){
        Logger.getLogger(MainPageController.class.getName()).info("Opened page authors");
        return "/authors/index.html";
    }*/
    @GetMapping("/{id}")
    public String slugPage(@PathVariable("id") int id, Model model){
        //Logger.getLogger(MainPageController.class.getName()).info("Opened page slug");
        model.addAttribute("authors",bookService.getAuthorId(id).getAuthor());
        model.addAttribute("bio",bookService.getAuthorId(id).getBiography());
        model.addAttribute("photo",bookService.getAuthorId(id).getPhoto());
        model.addAttribute("books",bookService.getIdAuthorBook(id));
        Logger.getLogger(MainPageController.class.getName()).info("Opened page slug"/*+model.getAttribute("bio")*/);
        return "/authors/slugs/slug.html";
    }
}
