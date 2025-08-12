package com.moh.angularSpring.dao;

import com.moh.angularSpring.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDao extends JpaRepository<Author,Long> {
}
