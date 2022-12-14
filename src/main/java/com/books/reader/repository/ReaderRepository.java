package com.books.reader.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.books.reader.model.Reader;

@Repository
public interface ReaderRepository extends MongoRepository<Reader, Integer> {
    
}
