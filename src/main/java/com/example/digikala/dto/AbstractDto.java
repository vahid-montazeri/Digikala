package com.example.digikala.dto;


import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@MappedSuperclass
@Getter
@Setter

public class AbstractDto {
    private String id;
    private Date createDate;
    private Date modifiedDate;
    private String createdBy;
    private String modifiedBy;
}
