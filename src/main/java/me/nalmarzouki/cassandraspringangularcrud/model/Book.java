package me.nalmarzouki.cassandraspringangularcrud.model;

import java.time.LocalDate;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;

@Table
public class Book {

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private String id;

    @CassandraType(type = Name.TEXT)
    private String name;

    @CassandraType(type = Name.TEXT)
    private String bookDescription;

    @CassandraType(type = Name.DATE)
    private LocalDate publishedDate;

    @CassandraType(type = Name.TEXT)
    private String authorName;

    public Book() {
    }

    public Book(String id, String name, String bookDescription, LocalDate publishedDate, String authorName) {
        this.id = id;
        this.name = name;
        this.bookDescription = bookDescription;
        this.publishedDate = publishedDate;
        this.authorName = authorName;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBookDescription() {
        return this.bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public LocalDate getPublishedDate() {
        return this.publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
