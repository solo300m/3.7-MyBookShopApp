package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("authors",bookService);
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
    @GetMapping("/authors")
    public String authorPage(){
        Logger.getLogger(MainPageController.class.getName()).info("Opened page authors");
        return "/authors/index.html";
    }
}
