package com.books.reader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.books.reader.dto.ReaderDto.*;
import com.books.reader.service.ReaderService;
import javax.servlet.http.HttpServletRequest;
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
    public ResponseEntity<Object> getReader(@PathVariable(value="id") Integer id){
        log.info("GET http://localhost:8099/api/v1/reader/{} is called", id);
        
		return readerService.getReader(id);
    }

    //POST
    @SneakyThrows(Exception.class)
    @PostMapping(value = "/add")
    // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> createReader(HttpServletRequest request, @RequestBody CreateReader dto){
        log.info("POST http://localhost:8099/api/v1/reader is called");
        boolean result = CheckToken.checkAuthorization(request, "SUPER_ADMIN");
        return readerService.createReader(result, dto);
    }

    //PUT
    @SneakyThrows(Exception.class)
    @PutMapping(value = "/{id_reader}")
    // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> updateReader(HttpServletRequest request, @RequestBody UpdateReader dto){
        log.info("PUT http://localhost:8099/api/v1/reader is called");
        boolean result = CheckToken.checkAuthorization(request, "SUPER_ADMIN");
        return readerService.updateReader(result, dto);
    }
    //DELETE
    @SneakyThrows(Exception.class)
    @DeleteMapping(value = "/{id_reader}")
    // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> deleteReader(HttpServletRequest request, @PathVariable(name = "id") Integer id){
        log.info("DELETE http://localhost:8099/api/v1/reader is called");
        boolean result = CheckToken.checkAuthorization(request, "SUPER_ADMIN");
        return readerService.deleteReader(result, id);
    }
    //GETALL
    @SneakyThrows(Exception.class)
    @GetMapping(value = "/")
    // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> getReaders(){
        log.info("GET http://localhost:8099/api/v1/reader/ is called");
		return readerService.getReaders();
    }
}
