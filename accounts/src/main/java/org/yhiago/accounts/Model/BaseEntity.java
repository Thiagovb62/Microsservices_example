package org.yhiago.accounts.Model;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jdk.jfr.Timestamp;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter @Setter @ToString
public class BaseEntity {

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column(updatable = false)
    private String CreatedBy;

    @Column(insertable  = false)
    private LocalDateTime updatedAt;

    @Column(insertable  = false)
    private String updatedBy;
}
