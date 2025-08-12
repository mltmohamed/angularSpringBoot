package com.moh.angularSpring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class Book {
    private Long id;
    private String title;
    private String content;

    // relation with author
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
}
