package com.rtisas.facade.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class CourseEmployee {

    private Employee employee;
    private Course course;
    private File file;
    private Date certificateStartDate;
    private Date certificateEndDate;
}
