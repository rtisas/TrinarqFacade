package com.rtisas.facade.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class File {

    private Long id;
    private String nameFile;
    private FileType typeFile;
    private String pathFile;
    Long datetime = System.currentTimeMillis();
    private Timestamp timestamp = new Timestamp(datetime);
    private boolean statusFile;

}
