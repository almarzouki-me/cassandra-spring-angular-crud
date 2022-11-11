package me.nalmarzouki.cassandraspringangularcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.nalmarzouki.cassandraspringangularcrud.model.Author;
import me.nalmarzouki.cassandraspringangularcrud.repository.AuthorRepository;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public Author createAuthor(Author author) {
        Optional<Author> tempAuthor = authorRepository.findById(author.getId());
        if (!tempAuthor.isPresent()) {
            authorRepository.save(author);
            return author;
        }

        return null;
    }

    public List<Author> readAuthors() {
        return authorRepository.findAll();
    }

    public Author readAuthor(String id) {
        Optional<Author> author = authorRepository.findById(id);
        if (author.isPresent()) {
            return author.get();
        } else {
            return null;
        }
    }

    public Author updateAuthor(String id, Author author) {
        Optional<Author> tempAuthor = authorRepository.findById(id);

        if (tempAuthor.isPresent()) {
            tempAuthor.get().setName(author.getName());
            tempAuthor.get().setBooks(author.getBooks());
            authorRepository.save(tempAuthor.get());

            return tempAuthor.get();
        } else {
            return null;
        }
    }

    public Author deleteAuthor(String id) {
        Optional<Author> author = authorRepository.findById(id);
        if (author.isPresent()) {
            authorRepository.delete(author.get());
            return author.get();
        } else {
            return null;
        }
    }

    public void deleteAuthors() {
        authorRepository.deleteAll();
    }
}
