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

import me.nalmarzouki.cassandraspringangularcrud.model.Book;
import me.nalmarzouki.cassandraspringangularcrud.service.BookService;

@RestController
@RequestMapping("/")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/books")
    public ResponseEntity<String> createAuthor(@RequestBody Book book) {
        try {
            Book tempBook = bookService.createBook(book);
            if (tempBook == null) {
                return new ResponseEntity<String>("Book: " + book.toString() + " already exists",
                        HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("Book: " + book.toString() + " created successfully: ",
                        HttpStatus.OK);
            }
        } catch (ServerErrorException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/books")
    public ResponseEntity<String> readBooks() {
        try {
            return new ResponseEntity<String>(bookService.readBooks().toString(), HttpStatus.OK);
        } catch (ServerErrorException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<String> readBook(@PathVariable String id) {
        try {
            Book book = bookService.readBook(id);
            if (book != null) {
                return new ResponseEntity<String>(book.toString(), HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("Book with id: " + id + "  is not found",
                        HttpStatus.OK);
            }
        } catch (ServerErrorException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<String> updateBook(@PathVariable String id, @RequestBody Book book) {
        try {
            Book tempBook = bookService.updateBook(id, book);
            if (tempBook != null) {
                return new ResponseEntity<String>("Book with id: " + id + " updated sccuessfully",
                        HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("Book with id: " + id + " doesn't exist",
                        HttpStatus.OK);
            }
        } catch (ServerErrorException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable String id) {
        try {
            Book book = bookService.deleteBook(id);
            if (book != null) {
                return new ResponseEntity<String>("Book with id: " + id + " deleted sccuessfully",
                        HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("Book with id: " + id + " doesn't exist",
                        HttpStatus.OK);
            }
        } catch (ServerErrorException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/books")
    public ResponseEntity<String> deleteBooks() {
        try {
            bookService.deleteBooks();
            return new ResponseEntity<String>("books deleted successfully ", HttpStatus.OK);
        } catch (ServerErrorException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
