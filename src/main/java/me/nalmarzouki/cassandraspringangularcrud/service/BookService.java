package me.nalmarzouki.cassandraspringangularcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.nalmarzouki.cassandraspringangularcrud.model.Book;
import me.nalmarzouki.cassandraspringangularcrud.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Book createBook(Book book) {
        Optional<Book> tempBook = bookRepository.findById(book.getId());
        if (!tempBook.isPresent()) {
            bookRepository.save(book);
            return book;
        } else {
            return null;
        }
    }

    public Book readBook(String id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            return book.get();
        } else {
            return null;
        }
    }

    public List<Book> readBooks() {
        return bookRepository.findAll();
    }

    public Book updateBook(String id, Book book) {
        Optional<Book> tempBook = bookRepository.findById(id);
        if (tempBook.isPresent()) {
            tempBook.get().setName(book.getName());
            tempBook.get().setAuthorName(book.getAuthorName());
            tempBook.get().setBookDescription(book.getBookDescription());
            tempBook.get().setPublishedDate(book.getPublishedDate());
            tempBook.get().setBookCover(book.getBookCover());
            bookRepository.save(tempBook.get());

            return tempBook.get();
        } else {
            return null;
        }
    }

    public Book deleteBook(String id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            bookRepository.delete(book.get());
            return book.get();
        } else {
            return null;
        }

    }

    public void deleteBooks() {
        bookRepository.deleteAll();
    }
}
