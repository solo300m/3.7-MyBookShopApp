package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
//@RequestMapping("/bookshop")
public class MainPageController {

    private final BookService bookService;

    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String reloadMainPage(Model model){
        Logger.getLogger(MainPageController.class.getName()).info("Reload great page!");
        model.addAttribute("bookData", bookService.getBookData());
        bookService.setAuthorsData(bookService.getBookData());
        return "index";
    }

    @GetMapping("/bookshop")
    public String mainPage(Model model){
        Logger.getLogger(MainPageController.class.getName()).info("Hy, it is great page!");
        model.addAttribute("bookData", bookService.getBookData());
        bookService.setAuthorsData(bookService.getBookData());
        return "index";
    }
    @GetMapping("/bookshop/genres")
    public String genresPage(){
        Logger.getLogger(MainPageController.class.getName()).info("Opened page genres");
        return "/genres/index.html";
    }
    @GetMapping("/bookshop/authors")
    public String authorPage(Model model){
        Logger.getLogger(MainPageController.class.getName()).info("Opened page authors from main_page");
        model.addAttribute("authors",bookService);
        return "/authors/index.html";
    }
}
