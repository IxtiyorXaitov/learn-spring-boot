package dev.ikhtiyor.learn.service;

import dev.ikhtiyor.learn.entity.Author;
import dev.ikhtiyor.learn.entity.Book;
import dev.ikhtiyor.learn.payload.*;
import dev.ikhtiyor.learn.repository.AuthorRepository;
import dev.ikhtiyor.learn.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;

    public ApiResponse addBook(ReqBook request) {
        try {
            if (request.getAuthorId() != null) {
                Book book = new Book();
                book.setName(request.getName());
                book.setPageCount(request.getPageCount());
                book.setPublishedDate(request.getPublishedDate());

                Optional<Author> optionalAuthor = authorRepository.findById(request.getAuthorId());
                if (optionalAuthor.isPresent()) {
                    Author author = optionalAuthor.get();
                    book.setAuthor(author);
                } else {
                    return new ApiResponse("Author not found", false);
                }

                bookRepository.save(book);
                return new ApiResponse("Successfully saved", true);
            } else {
                return new ApiResponse("Author is optional", false);
            }
        } catch (Exception e) {
            return new ApiResponse("Server error", false);
        }
    }

    public ApiResponse editBook(Integer id, ReqBook request) {
        try {
            Optional<Book> optionalBook = bookRepository.findById(id);
            if (optionalBook.isPresent()) {
                Book book = optionalBook.get();

                book.setName(request.getName());
                book.setPageCount(request.getPageCount());
                book.setPublishedDate(request.getPublishedDate());

                if (request.getAuthorId() != null) {
                    Optional<Author> optionalAuthor = authorRepository.findById(request.getAuthorId());
                    if (optionalAuthor.isPresent()) {
                        Author author = optionalAuthor.get();
                        book.setAuthor(author);
                    } else {
                        return new ApiResponse("Author not found", false);
                    }
                }
                bookRepository.save(book);
                return new ApiResponse("Successfully saved", true);
            } else {
                return new ApiResponse("Book not found", false);
            }
        } catch (Exception e) {
            return new ApiResponse("Server error", false);
        }
    }

    public ResBook getResBook(Integer id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            return getResBook(book);
        }
        return new ResBook();
    }

    public ResPageable getAllBooks(Integer page, Integer size) {
        try {
            PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id"));

            Page<Book> bookPage = bookRepository.findAll(pageRequest);

            return new ResPageable(
                    page,
                    size,
                    bookPage.getTotalPages(),
                    bookPage.getTotalElements(),
                    getAllResBook(bookPage.getContent())
            );
        } catch (Exception e) {
            return new ResPageable();
        }
    }

    public List<ResBook> getAllResBook(List<Book> bookPage) {
        List<ResBook> resBooks = new ArrayList<>();
        if (!bookPage.isEmpty()) {
            for (Book book : bookPage) {
                resBooks.add(
                        getResBook(book)
                );
            }
        }
        return resBooks;
    }

    public ResBook getResBook(Book book) {
        return new ResBook(
                book.getId(),
                book.getName(),
                book.getPublishedDate(),
                book.getPageCount(),
                new ResAuthor(
                        book.getAuthor().getId(),
                        book.getAuthor().getFistName(),
                        book.getAuthor().getLastName()
                )
        );
    }

    public ApiResponse deleteBook(Integer id) {
        try {
            bookRepository.deleteById(id);
            return new ApiResponse("Successfully deleted", true);
        } catch (Exception e) {
            return new ApiResponse("Book did not deleted", false);

        }
    }
}
