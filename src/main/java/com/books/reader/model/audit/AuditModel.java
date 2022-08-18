package com.books.reader.model.audit;

import java.time.LocalDateTime;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.index.Indexed;
// import java.util.Date;
import lombok.Data;

@Data
// @MappedSuperclass
// @EntityListeners(AuditingEntityListener.class);
public abstract class AuditModel<T> {
    @Indexed
    @CreatedDate
    protected LocalDateTime created_at;

    @LastModifiedDate
    protected LocalDateTime updated_at;

    @CreatedBy
    private String created_by;

    @LastModifiedBy
    private String updated_by;
}
