package me.nalmarzouki.cassandraspringangularcrud.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import me.nalmarzouki.cassandraspringangularcrud.model.Author;

@Repository
public interface AuthorRepository extends CassandraRepository<Author, String> {

}
