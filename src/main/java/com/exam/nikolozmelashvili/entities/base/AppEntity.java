package com.exam.nikolozmelashvili.entities.base;

import com.exam.nikolozmelashvili.validation.ValidRecordState;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
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

    @Column
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @Column
    @ValidRecordState
    private Integer recordState;

    public void setRecordStateEnum(RecordState recordState) {
        this.recordState = recordState.getValue();
    }
}
