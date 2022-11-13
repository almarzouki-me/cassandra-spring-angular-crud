package me.nalmarzouki.cassandraspringangularcrud.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;

import lombok.Data;

@Data
@Table
public class Book {

    @Id
    @PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String id;

    @CassandraType(type = Name.TEXT)
    private String name;

    @CassandraType(type = Name.TEXT)
    private String bookDescription;

    @CassandraType(type = Name.DATE)
    private LocalDate publishedDate;

    @CassandraType(type = Name.TEXT)
    private String authorName;

    @CassandraType(type = Name.BLOB)
    private Byte[] bookCover;

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", bookDescription='" + getBookDescription() + "'" +
                ", publishedDate='" + getPublishedDate() + "'" +
                ", authorName='" + getAuthorName() + "'" +
                "}";
    }

}