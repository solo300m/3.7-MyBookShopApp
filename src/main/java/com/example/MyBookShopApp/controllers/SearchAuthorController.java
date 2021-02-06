package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.Book;
import com.example.MyBookShopApp.data.BookService;
import com.example.MyBookShopApp.data.FoundAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
public class SearchAuthorController {
    private final BookService bookService;

    @Autowired
    public SearchAuthorController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/search")
    public String openSearchPage(){
        Logger.getLogger(SearchAuthorController.class.getName()).info("Open search page");
//        Map<String, List<Book>> list = bookService.getAuthorName(found);
//        model.addAttribute("books",list);
        return "/books/author.html";
    }

    @GetMapping("/search/{found}")
    public String searchPage(@PathVariable("found") String found, Model model){
        Logger.getLogger(SearchAuthorController.class.getName()).info("Open searchAuthor page");
        Map<String, List<Book>> list = bookService.getAuthorName(found);
        model.addAttribute("books",list);
        return "/books/author.html";
    }
}
