package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.Book;
import com.example.MyBookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.logging.Logger;

@Controller
//@RequestMapping("/recent")
public class RecentController {

    private final BookService bookService;

    @Autowired
    public RecentController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("recommendedBooks")
    public List<Book> recommendedBooks(){
        bookService.setAuthorsData(bookService.getBookData());
        bookService.updateBookIdAuthors();
        return bookService.getBookData();
    }

    @GetMapping("/recent")
    public String recentPage(){
        Logger.getLogger(RecentController.class.getName()).info("Opened page recent");
        return "/recent.html";
    }
    @GetMapping("/recent/bookshop")
    public String mainPageReturn(){
        Logger.getLogger(RecentController.class.getName()).info("Reload great page!");
        return "index";
    }
}
