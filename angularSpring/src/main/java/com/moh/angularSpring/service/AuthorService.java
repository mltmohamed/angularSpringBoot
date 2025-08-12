package com.moh.angularSpring.service;

import com.moh.angularSpring.dao.AuthorDao;
import com.moh.angularSpring.dto.AuthorDto;
import com.moh.angularSpring.dto.BookDto;
import com.moh.angularSpring.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    private final AuthorDao authorDao;
    @Autowired
    public AuthorService(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }
    // method for create author
    public AuthorDto createAuthor(AuthorDto authorDto){
        Author author = new Author();
        author.setName(authorDto.getName());
        author.setAddress(authorDto.getAddress());
        author.setBooks(authorDto.getBooks());
        authorDao.save(author);
        return authorDto;
    }
    // method for get author by id
    public AuthorDto getAuthorById(Long id){
        Author author = authorDao.findById(id)
                .orElseThrow(()-> new RuntimeException("Author non trouvé"));
        AuthorDto authorDto = new AuthorDto();
        return new AuthorDto(
                author.getName(),
                author.getAddress(),
                author.getBooks());
    }
    // method for get all authors
    public List<AuthorDto> getAllAuthors() {
        return authorDao.findAll().stream()
                .map(author  -> new AuthorDto(
                        author.getName(),
                        author.getAddress(),
                        author.getBooks()))
                .collect(Collectors.toList());
    }
    // method to get author books
    public List<BookDto> getAuthorBooks(Long authorId){
        Author author = authorDao.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        return author.getBooks().stream()
                .map(book -> new BookDto(
                        book.getTitle(),
                        book.getContent()
                )).collect(Collectors.toList());
    }
}
