package com.test.service;

import com.test.entity.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookService {
    Book getBookById(int bid);
}
