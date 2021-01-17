package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.Book;
import com.example.MyBookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping("/genres")
public class GenresPageController {
    private BookService bookService;

    @Autowired
    public GenresPageController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping
    public String rederectGenres(){
        Logger.getLogger(GenresPageController.class.getName()).info("Reload genres page");
        return "/genres/index";
    }
    @GetMapping("/bookshop")
    public String mainOpen(Model model){
        Logger.getLogger(GenresPageController.class.getName()).info("Back on the main-page");
        model.addAttribute("bookData", bookService.getBookData());
        return "index.html";
    }
    @GetMapping("/authors")
    public String authorPage(Model model){
        Logger.getLogger(MainPageController.class.getName()).info("Opened page authors from Genres_Page");
        model.addAttribute("authors",bookService.getMapAuthors(bookService.getAuthorsList()));
        return "/authors/index.html";
    }
}
