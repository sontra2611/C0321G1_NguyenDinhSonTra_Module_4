package com.codegym.controller;

import com.codegym.exception.BorrowBookException;
import com.codegym.model.bean.Book;
import com.codegym.model.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    IBookService iBookService;

    @GetMapping("/list")
    public String list(Model model){
        List<Book> bookList = iBookService.findAll();
        model.addAttribute("bookList", bookList);
        return "list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) throws BorrowBookException {
        Book book = iBookService.findById(id);
        if (book.getQuantity() == 0){
            throw new BorrowBookException();
        }else {
            model.addAttribute("book", book);
            return "view-borrow";
        }
    }

    @PostMapping("/borrow")
    public String borrow(@ModelAttribute Book book) {
        book.setQuantity(book.getQuantity() - 1);
        iBookService.save(book);
        return "redirect:/book/list";
    }

    @GetMapping("/giveBookBack")
    public String formGiveBookBack(){
        return "view-give-back-book";
    }

    @PostMapping("/giveBookBack")
    public String giveBookBack(@RequestParam int idBook) {
        Book book = iBookService.findById(idBook);
        book.setQuantity(book.getQuantity() + 1);
        iBookService.save(book);
        return "redirect:/book/list";
    }

    @ExceptionHandler(BorrowBookException.class)
    public String showErrorPage() {
        return "error";
    }
}
