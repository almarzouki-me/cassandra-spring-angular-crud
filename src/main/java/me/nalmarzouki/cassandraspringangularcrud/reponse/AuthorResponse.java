package me.nalmarzouki.cassandraspringangularcrud.reponse;

import lombok.Data;
import me.nalmarzouki.cassandraspringangularcrud.model.Author;

@Data
public class AuthorResponse {
    private String responseMessage;
    private Author author;
}
