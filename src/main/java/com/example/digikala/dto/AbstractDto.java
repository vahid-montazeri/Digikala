package com.example.digikala.dto;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
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
