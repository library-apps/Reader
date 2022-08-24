package com.books.reader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.books.reader.dto.ReaderDto.*;
import com.books.reader.service.ReaderService;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value =  "/api/v1/reader")

public class ReaderController {
    @Autowired
    private ReaderService readerService;
    
    @SneakyThrows(Exception.class)
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getReader(@PathVariable(value="id") String id){
        log.info("GET http://localhost:8080/api/v1/book/{} is called", id);
		return readerService.getReader(id);
    }

    //POST
    @SneakyThrows(Exception.class)
    @PostMapping(value = "/add")
    public ResponseEntity<Object> createReader(@RequestBody CreateReader dto){
        log.info("POST http://localhost:8080/api/v1/book is called");
        return readerService.createReader(dto);
    }

    //PUT
    @SneakyThrows(Exception.class)
    @PutMapping(value = "/{id_book}")
    public ResponseEntity<Object> updateReader(@PathVariable("id") String id, @RequestBody UpdateReader dto){
        log.info("PUT http://localhost:8080/api/v1/book is called");
        return readerService.updateReader(id, dto);
    }
    //DELETE
    @SneakyThrows(Exception.class)
    @DeleteMapping(value = "/{id_book}")
    public ResponseEntity<Object> deleteReader(@PathVariable(name = "id") String id){
        log.info("DELETE http://localhost:8080/api/v1/book is called");
        return readerService.deleteReader(id);
    }
    //GETALL
    @SneakyThrows(Exception.class)
    @GetMapping(value = "/")
    public ResponseEntity<Object> getReaders(){
        log.info("GET http://localhost:8080/api/v1/book/ is called");
		return readerService.getReaders();
    }
}
