package com.moh.angularSpring.controller;

import com.moh.angularSpring.dto.AuthorDto;
import com.moh.angularSpring.dto.BookDto;
import com.moh.angularSpring.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthorController {
    private final AuthorService authorService;
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    //create author
    @PostMapping("createAuthor")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto){
        try{
            AuthorDto createdAuthor = authorService.createAuthor(authorDto);
            return new ResponseEntity<>(createdAuthor, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    //get author by id
    @GetMapping("{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable Long id){
        try{
            AuthorDto authorDto = authorService.getAuthorById(id);
            return new ResponseEntity<>(authorDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("l'auteur non trouvé ", HttpStatus.NOT_FOUND);
        }
    }
    //get all authors
    @GetMapping("all")
    public ResponseEntity<?> getAllAuthors() {
        try {
            return new ResponseEntity<>(authorService.getAllAuthors(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //get author books
    @GetMapping("{authorId}/books")
    public ResponseEntity<?> getAuthorBooks(@PathVariable Long authorId) {
        try {
            return new ResponseEntity<>(authorService.getAuthorBooks(authorId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    //create book for author
    @PostMapping("{authorId}/books")
    public ResponseEntity<?> createBookForAuthor(@PathVariable Long authorId, @RequestBody BookDto bookDto) {
        try {
            authorService.createBookForAuthor(authorId, bookDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
