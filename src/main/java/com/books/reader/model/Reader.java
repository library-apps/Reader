package com.books.reader.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

//Annotations
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Reader")

public class Reader{
    @Id private int id;
    private String reader_name;
    private String address;
    private String email;
    private String gender;
    private Integer phone;
    private Integer is_borrower;
    private Date deleted_at;
    private Integer is_deleted;
}