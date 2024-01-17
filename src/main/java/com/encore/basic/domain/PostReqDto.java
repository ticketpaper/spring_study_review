package com.encore.basic.domain;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
@Data
public class PostReqDto {
    private int id;
    private String title;
    private String author;
    private String contents;
}
