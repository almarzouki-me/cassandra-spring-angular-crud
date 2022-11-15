package me.nalmarzouki.cassandraspringangularcrud.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;

import lombok.Data;

@Data
@Table
public class Author {
    @Id
    @PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String id;

    @CassandraType(type = Name.TEXT)
    private String name;

    // @CassandraType(type = Name.LIST, typeArguments = Name.TEXT)
    // private List<String> books;

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                // ", books='" + getBooks() + "'" +
                "}";
    }
}