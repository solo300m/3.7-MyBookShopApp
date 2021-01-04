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
        return "/authors/index.html";
    }
}
