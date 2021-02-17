package dev.ikhtiyor.learn.service;

import dev.ikhtiyor.learn.entity.Author;
import dev.ikhtiyor.learn.payload.*;
import dev.ikhtiyor.learn.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public ApiResponse addAuthor(ReqAuthor request) {
        try {
            Author author = new Author();
            author.setFistName(request.getFistName());
            author.setLastName(request.getLastName());

            authorRepository.save(author);
            return new ApiResponse("Successfully saved", true);

        } catch (Exception e) {
            return new ApiResponse("Server error", false);
        }
    }

    public ApiResponse editAuthor(Integer id, ReqAuthor request) {
        try {
            Optional<Author> optionalAuthor = authorRepository.findById(id);
            if (optionalAuthor.isPresent()) {
                Author author = optionalAuthor.get();

                author.setFistName(request.getFistName());
                author.setLastName(request.getLastName());

                authorRepository.save(author);
                return new ApiResponse("Successfully saved", true);
            } else {
                return new ApiResponse("Author not found", false);
            }
        } catch (Exception e) {
            return new ApiResponse("Server error", false);
        }
    }

    public ResAuthor getResAuthor(Integer id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (optionalAuthor.isPresent()) {
            Author author = optionalAuthor.get();
            return getResAuthor(author);
        }
        return new ResAuthor();
    }

    public ResPageable getAllAuthors(Integer page, Integer size) {
        try {
            PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id"));

            Page<Author> authorPage = authorRepository.findAll(pageRequest);

            return new ResPageable(
                    page,
                    size,
                    authorPage.getTotalPages(),
                    authorPage.getTotalElements(),
                    getAllResAuthor(authorPage.getContent())
            );
        } catch (Exception e) {
            return new ResPageable();
        }
    }

    public List<ResAuthor> getAllResAuthor(List<Author> authorPage) {
        List<ResAuthor> resAuthors = new ArrayList<>();
        if (!authorPage.isEmpty()) {
            for (Author author : authorPage) {
                resAuthors.add(
                        getResAuthor(author)
                );
            }
        }
        return resAuthors;
    }

    public ResAuthor getResAuthor(Author author) {
        return new ResAuthor(
                author.getId(),
                author.getFistName(),
                author.getFistName()
        );
    }

    public ApiResponse deleteAuthor(Integer id) {
        try {
            authorRepository.deleteById(id);
            return new ApiResponse("Successfully deleted", true);
        } catch (Exception e) {
            return new ApiResponse("Author did not deleted", false);

        }
    }
}
