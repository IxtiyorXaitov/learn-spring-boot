package dev.ikhtiyor.learn.controller;

import dev.ikhtiyor.learn.payload.ApiResponse;
import dev.ikhtiyor.learn.payload.ReqAuthor;
import dev.ikhtiyor.learn.payload.ResAuthor;
import dev.ikhtiyor.learn.payload.ResPageable;
import dev.ikhtiyor.learn.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public HttpEntity<?> addAuthor(
            @RequestBody ReqAuthor request
    ) {
        ApiResponse apiResponse = authorService.addAuthor(request);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }

    @PutMapping("/edit/{id}")
    public HttpEntity<?> editAuthor(
            @PathVariable Integer id,
            @RequestBody ReqAuthor request
    ) {
        ApiResponse apiResponse = authorService.editAuthor(id, request);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }

    @GetMapping("/all")
    public HttpEntity<?> getAllAuthors(
            @RequestParam(name = "page") Integer page,
            @RequestParam(name = "size") Integer size
    ) {
        ResPageable resPageable = authorService.getAllAuthors(page, size);
        return ResponseEntity.ok(resPageable);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getAuthor(
            @PathVariable Integer id
    ) {
        ResAuthor resAuthor = authorService.getResAuthor(id);
        return ResponseEntity.ok(resAuthor);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteAuthor(
            @PathVariable Integer id
    ) {
        ApiResponse apiResponse = authorService.deleteAuthor(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.NO_CONTENT : HttpStatus.CONFLICT).body(apiResponse);
    }
}
