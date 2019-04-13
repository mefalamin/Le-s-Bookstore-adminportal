package com.adminportal.controller;

import com.adminportal.domain.Book;
import com.adminportal.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * created by saikat on 4/13/19
 */
@Controller
@RequestMapping("/book")
public class BookController {


    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addBook(Model model){
        Book book = new Book();
        model.addAttribute("book",book);
        return "addBook";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addBookPost(
            @ModelAttribute("book") Book book
    ){

        bookService.save(book);
        MultipartFile bookImage = book.getBookImage();

        try{
            byte[] bytes = bookImage.getBytes();
            String name = book.getId()+".png";
            BufferedOutputStream stream = new BufferedOutputStream
                    (new FileOutputStream(new File("src/main/resources/static/images/book/"+name)));
            stream.write(bytes);
            stream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:bookList";
    }

    @RequestMapping("/bookList")
    public String bookList(Model model){


        return "bookList";
    }



}
