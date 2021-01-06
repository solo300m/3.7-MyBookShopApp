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
        model.addAttribute("authorsA", bookService.getAuthorsData('A'));
        model.addAttribute("authorsB", bookService.getAuthorsData('B'));
        model.addAttribute("authorsC", bookService.getAuthorsData('C'));
        model.addAttribute("authorsD", bookService.getAuthorsData('D'));
        model.addAttribute("authorsE", bookService.getAuthorsData('E'));
        model.addAttribute("authorsF", bookService.getAuthorsData('F'));
        model.addAttribute("authorsG", bookService.getAuthorsData('G'));
        model.addAttribute("authorsH", bookService.getAuthorsData('H'));
        model.addAttribute("authorsI", bookService.getAuthorsData('I'));
        model.addAttribute("authorsJ", bookService.getAuthorsData('J'));
        model.addAttribute("authorsK", bookService.getAuthorsData('K'));
        model.addAttribute("authorsL", bookService.getAuthorsData('L'));
        model.addAttribute("authorsM", bookService.getAuthorsData('M'));
        model.addAttribute("authorsN", bookService.getAuthorsData('N'));
        model.addAttribute("authorsO", bookService.getAuthorsData('O'));
        model.addAttribute("authorsP", bookService.getAuthorsData('P'));
        model.addAttribute("authorsQ", bookService.getAuthorsData('Q'));
        model.addAttribute("authorsR", bookService.getAuthorsData('R'));
        model.addAttribute("authorsS", bookService.getAuthorsData('S'));
        model.addAttribute("authorsT", bookService.getAuthorsData('T'));
        model.addAttribute("authorsU", bookService.getAuthorsData('U'));
        model.addAttribute("authorsV", bookService.getAuthorsData('V'));
        model.addAttribute("authorsW", bookService.getAuthorsData('W'));
        model.addAttribute("authorsX", bookService.getAuthorsData('X'));
        model.addAttribute("authorsY", bookService.getAuthorsData('Y'));
        model.addAttribute("authorsZ", bookService.getAuthorsData('Z'));
        return "/authors/index.html";
    }
}
