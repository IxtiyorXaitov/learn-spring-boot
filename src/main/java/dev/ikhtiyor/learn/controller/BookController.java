package dev.ikhtiyor.learn.controller;

import dev.ikhtiyor.learn.payload.ApiResponse;
import dev.ikhtiyor.learn.payload.ReqBook;
import dev.ikhtiyor.learn.payload.ResBook;
import dev.ikhtiyor.learn.payload.ResPageable;
import dev.ikhtiyor.learn.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public HttpEntity<?> addBook(
            @RequestBody ReqBook request
    ) {
        ApiResponse apiResponse = bookService.addBook(request);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }

    @PutMapping("/edit/{id}")
    public HttpEntity<?> editBook(
            @PathVariable Integer id,
            @RequestBody ReqBook request
    ) {
        ApiResponse apiResponse = bookService.editBook(id, request);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }

    @GetMapping("/all")
    public HttpEntity<?> getAllBooks(
            @RequestParam(name = "page") Integer page,
            @RequestParam(name = "size") Integer size
    ) {
        ResPageable resPageable = bookService.getAllBooks(page, size);
        return ResponseEntity.ok(resPageable);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getBook(
            @PathVariable Integer id
    ) {
        ResBook resBook = bookService.getResBook(id);
        return ResponseEntity.ok(resBook);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteBook(
            @PathVariable Integer id
    ) {
        ApiResponse apiResponse = bookService.deleteBook(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.NO_CONTENT : HttpStatus.CONFLICT).body(apiResponse);
    }
}
