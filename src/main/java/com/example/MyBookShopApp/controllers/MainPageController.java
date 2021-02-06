package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.Book;
import com.example.MyBookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
//@RequestMapping("/bookshop")
public class MainPageController {

    private final BookService bookService;

    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("recommendedBooks")
    public List<Book> recommendedBooks(){
        bookService.setAuthorsData(bookService.getBookData());
        bookService.updateBookIdAuthors();
        return bookService.getBookData();
    }

    @GetMapping("/")
    public String reloadMainPage(){
        Logger.getLogger(MainPageController.class.getName()).info("Reload great page!");
        return "index";
    }

    @GetMapping("/bookshop")
    public String mainPage(){
        Logger.getLogger(MainPageController.class.getName()).info("Hy, it is great page!");
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
        model.addAttribute("authors",bookService.getMapAuthors(bookService.getAuthorsList()));
        return "/authors/index.html";
    }
    @GetMapping("/bookshop/recent")
    public String recentPage(){
        Logger.getLogger(MainPageController.class.getName()).info("Opened page recent from main_page");
        return "/recent.html";
    }

}
