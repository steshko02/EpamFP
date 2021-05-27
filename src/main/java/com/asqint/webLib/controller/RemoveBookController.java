package com.asqint.webLib.controller;

import com.asqint.webLib.domain.Book;
import com.asqint.webLib.repos.BookRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class RemoveBookController {

    private final BookRepo bookRepo;

    public RemoveBookController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

//    @PostMapping("bookPage/{id}")
//    public String addBook(@PathVariable("id") Long id) {
//
//        bookRepo.deleteById(id);
//        return "redirect:/bookList";
//    }
}
