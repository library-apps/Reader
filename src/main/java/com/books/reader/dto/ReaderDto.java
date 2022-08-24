package com.books.reader.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ReaderDto {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateReader{
        private String reader_name;
        private String address;
        private String email;
        private String gender;
        private Integer phone;
        private Integer is_borrower;
        private Integer is_deleted;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdateReader{
        private String _id;
        private String reader_name;
        private String address;
        private String email;
        private String gender;
        private Integer phone;
        private Integer is_borrower;
        private Date deleted_at;
        private Integer is_deleted;
    }
}
