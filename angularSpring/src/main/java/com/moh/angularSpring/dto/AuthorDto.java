package com.moh.angularSpring.dto;

import com.moh.angularSpring.model.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;
@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class AuthorDto {
    private String name;
    private String address;
    private List<Book> books;
}
