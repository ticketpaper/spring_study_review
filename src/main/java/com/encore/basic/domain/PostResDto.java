package com.encore.basic.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostResDto {
    private int id;
    private String title;
    private String author;
    private String contents;
    private LocalDateTime create_time;
}
