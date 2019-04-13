package com.adminportal.controller;

import com.adminportal.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * created by saikat on 4/13/19
 */
@Controller
@RequestMapping("/book")
public class BookController {


    @RequestMapping("/add")
    public String addBook(Model model){
        Book book = new Book();
        model.addAttribute("book",book);
        return "addBook";
    }

}
