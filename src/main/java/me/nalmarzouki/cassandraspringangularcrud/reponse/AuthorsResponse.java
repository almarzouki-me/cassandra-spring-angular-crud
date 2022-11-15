package me.nalmarzouki.cassandraspringangularcrud.reponse;

import java.util.List;

import lombok.Data;
import me.nalmarzouki.cassandraspringangularcrud.model.Author;

@Data
public class AuthorsResponse {
    private String responseMessage;
    private List<Author> authors;
}
