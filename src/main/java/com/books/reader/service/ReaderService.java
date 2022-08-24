package com.books.reader.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.SneakyThrows;
import lombok.val;

import com.books.reader.dto.ReaderDto.*;
import com.books.reader.model.*;
import com.books.reader.repository.ReaderRepository;

@Service
public class ReaderService {
    @Autowired
    private ReaderRepository readerRepository;

    //create reader
    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> createReader(CreateReader dto){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> res = new HashMap<String, Object>();

        Reader reader = new Reader();
        
        reader.setReader_name(dto.getReader_name());
        reader.setAddress(dto.getAddress());
        reader.setEmail(dto.getEmail());
        reader.setGender(dto.getGender());
        reader.setPhone(dto.getPhone());
        reader.setIs_borrower(dto.getIs_borrower());
        reader.setIs_deleted(0);

        readerRepository.save(reader);

        res.put("code", HttpStatus.CREATED.value());
        res.put("message", "success");
		res.put("data", reader);

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
    }
    //update reader
    public ResponseEntity<Object> updateReader(String id, UpdateReader dto){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> res = new HashMap<String, Object>();

        val reader = readerRepository.findById(dto.get_id()).orElse(null);
        
        if(Optional.ofNullable(reader).isPresent()){
            reader.setReader_name(dto.getReader_name());
            reader.setAddress(dto.getAddress());
            reader.setEmail(dto.getEmail());
            reader.setGender(dto.getGender());
            reader.setPhone(dto.getPhone());
            reader.setIs_borrower(dto.getIs_borrower());
            reader.setIs_deleted(0);

            readerRepository.save(reader);

            res.put("message", "success");
            res.put("data", reader);
        } else {
            res.put("message", "failed");
            res.put("data", null);
        }
        res.put("code", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
    }
    //delete reader
    public ResponseEntity<Object> deleteReader(String id){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> res = new HashMap<String, Object>();

        val reader = readerRepository.findById(id).orElse(null);
        
        if(Optional.ofNullable(reader).isPresent()){
            reader.setIs_deleted(1);
            reader.setDeleted_at(new Date());

            readerRepository.save(reader);

            res.put("message", "success");
            res.put("data", reader);
        } else {
            res.put("message", "failed");
            res.put("data", null);
        }
        res.put("code", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
    }
    //get a reader
    //get all reader
    @SneakyThrows(Exception.class)
	public ResponseEntity<Object> getReaders() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		Map<String, Object> res = new HashMap<String, Object>();

		val readers = readerRepository.findAll();

		res.put("code", HttpStatus.OK.value());
		res.put("message", "success");
		res.put("data", readers);

		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
	}

    @SneakyThrows(Exception.class)
	public ResponseEntity<Object> getReader(@PathVariable("id") String id) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, Object> res = new HashMap<String, Object>();
		Optional<Reader> reader = readerRepository.findById(id);

		

		res.put("code", HttpStatus.OK.value());
		res.put("message", "success");
		res.put("data", reader);

		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
	}
}
