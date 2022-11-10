package me.nalmarzouki.cassandraspringangularcrud.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import me.nalmarzouki.cassandraspringangularcrud.model.Book;

public interface BookRepository extends CassandraRepository<Book, String> {

}
