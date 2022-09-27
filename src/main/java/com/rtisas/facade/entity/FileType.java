package com.rtisas.facade.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FileType {
    private Long id;
    private String nameFileType;
    private String mimeFileType;
    private FileCategory categoryFileType;
}
