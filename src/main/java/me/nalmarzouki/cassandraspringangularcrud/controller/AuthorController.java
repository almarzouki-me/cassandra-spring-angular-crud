package me.nalmarzouki.cassandraspringangularcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.server.ServerErrorException;

import me.nalmarzouki.cassandraspringangularcrud.model.Author;
import me.nalmarzouki.cassandraspringangularcrud.service.AuthorService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping("/authors")
    public Author createAuthor(@RequestBody Author author) {
        try {
            Author tempAuthor = authorService.createAuthor(author);
            if (tempAuthor == null) {
                return author;
            } else {
                return null;
            }
        } catch (ServerErrorException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/authors")
    public List<Author> readAuthors() {
        try {
            return authorService.readAuthors();
        } catch (ServerErrorException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<String> readAuthor(@PathVariable String id) {
        try {
            Author author = authorService.readAuthor(id);
            if (author != null) {
                return new ResponseEntity<String>(author.toString(), HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("Author with id: " + id + "  is not found",
                        HttpStatus.OK);
            }
        } catch (ServerErrorException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/authors/{id}")
    public ResponseEntity<String> updateAuthor(@PathVariable String id, @RequestBody Author author) {
        try {
            Author tempAuthor = authorService.updateAuthor(id, author);
            if (tempAuthor != null) {
                return new ResponseEntity<String>("Author with id: " + id + " updated sccuessfully",
                        HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("Author with id: " + id + " doesn't exist",
                        HttpStatus.OK);
            }
        } catch (ServerErrorException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/authors/{id}")
    public Author deleteAuthor(@PathVariable String id) {
        try {
            Author author = authorService.deleteAuthor(id);
            if (author != null) {
                return author;
            } else {
                return null;
            }
        } catch (ServerErrorException e) {
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping("/authors")
    public ResponseEntity<String> deleteAuthors() {
        try {
            authorService.deleteAuthors();
            return new ResponseEntity<String>("authors deleted successfully ", HttpStatus.OK);
        } catch (ServerErrorException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
