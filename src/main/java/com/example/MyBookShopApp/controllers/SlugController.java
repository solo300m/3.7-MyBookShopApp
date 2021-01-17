package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;

@Controller

public class SlugController {
    private BookService bookService;

    @Autowired
    public SlugController(BookService bookService) {
        this.bookService = bookService;
    }

    //    @GetMapping
//    public String getSlugPage(Model model){
//        model.addAttribute("authors",bookService.getMapId(bookService.getAuthorsList()));
//        return "authors/slug.html";
//    }
    @GetMapping("/slug/authors")
    public String getAuthorsSlug(Model model){
        Logger.getLogger(MainPageController.class.getName()).info("Opened page authors from slug");
        model.addAttribute("authors",bookService.getMapAuthors(bookService.getAuthorsList()));
        return "/authors/index.html";
    }
    @GetMapping("/slug/bookshop")
    public String getSlugMain(Model model){
        Logger.getLogger(MainPageController.class.getName()).info("Opened page main from slug");
        model.addAttribute("bookData",bookService.getBookData());
        return "index.html";
    }
    @GetMapping("/slug/genres")
    public String genresPage(){
        Logger.getLogger(MainPageController.class.getName()).info("Opened page genres from slug");
        return "/genres/index.html";
    }
}
