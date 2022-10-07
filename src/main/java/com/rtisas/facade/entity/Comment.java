package com.rtisas.facade.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class Comment {

    private Long id;
    private String contentComment;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-CO", timezone = "America/Bogota")
    private Date createdComment;
    private boolean statusComment;
    private Services serviceComment;
    private User userId;
    private Long type;
}
