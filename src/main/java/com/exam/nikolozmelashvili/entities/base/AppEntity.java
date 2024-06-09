package com.exam.nikolozmelashvili.entities.base;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AppEntity {

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private RecordState recordState = null;
}
