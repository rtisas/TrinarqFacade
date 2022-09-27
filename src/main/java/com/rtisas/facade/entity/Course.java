package com.rtisas.facade.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Course {

    private Long id;
    private String nameCourse;
    private boolean statusCourse;
}
