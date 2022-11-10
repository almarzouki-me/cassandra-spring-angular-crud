package me.nalmarzouki.cassandraspringangularcrud.model;

import java.util.List;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;

@Table
public class Author {
    @PrimaryKeyColumn (type = PrimaryKeyType.PARTITIONED)
    private String id;

    @CassandraType(type = Name.TEXT)
    private String name;

    @CassandraType(type = Name.LIST, typeArguments = Name.TEXT)
    private List<String> books;

    public Author() {
    }

    public Author(String id, String name, List<String> books) {
        this.id = id;
        this.name = name;
        this.books = books;
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

    public List<String> getBooks() {
        return this.books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }
}
