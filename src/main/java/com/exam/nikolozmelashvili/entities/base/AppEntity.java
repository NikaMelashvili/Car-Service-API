package com.exam.nikolozmelashvili.entities.base;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AppEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @Column
    private Integer recordState;

    public RecordState getRecordStateEnum() {
        return RecordState.fromValue(recordState);
    }

    public void setRecordStateEnum(RecordState recordState) {
        this.recordState = recordState.getValue();
    }
}
