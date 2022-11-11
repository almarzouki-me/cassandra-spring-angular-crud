package me.nalmarzouki.cassandraspringangularcrud.controller;

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
import org.springframework.web.server.ServerErrorException;

import me.nalmarzouki.cassandraspringangularcrud.model.Author;
import me.nalmarzouki.cassandraspringangularcrud.service.AuthorService;

@RestController
@RequestMapping("/")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping("/authors")
    public ResponseEntity<String> createAuthor(@RequestBody Author author) {
        try {
            Author tempAuthor = authorService.createAuthor(author);
            if (tempAuthor == null) {
                return new ResponseEntity<String>("Author: " + author.toString() + " already exists",
                        HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("Author: " + author.toString() + " created successfully: ",
                        HttpStatus.OK);
            }
        } catch (ServerErrorException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/authors")
    public ResponseEntity<String> readAuthors() {
        try {
            return new ResponseEntity<String>(authorService.readAuthors().toString(), HttpStatus.OK);
        } catch (ServerErrorException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
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
    public ResponseEntity<String> deleteAuthor(@PathVariable String id) {
        try {
            Author author = authorService.deleteAuthor(id);
            if (author != null) {
                return new ResponseEntity<String>("Author with id: " + id + " deleted sccuessfully",
                        HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("Author with id: " + id + " doesn't exist",
                        HttpStatus.OK);
            }
        } catch (ServerErrorException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
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
