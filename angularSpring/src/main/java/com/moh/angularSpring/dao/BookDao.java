package com.moh.angularSpring.dao;

import com.moh.angularSpring.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book, Long> {
}
