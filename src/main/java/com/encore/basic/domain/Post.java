package com.encore.basic.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class Post {
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String author;
    @Column(nullable = false, length = 50) // name 옵션을 통해 DB의 컬럼명 별도 지정 가능
    private String contents;
    @Setter
    @Column(name="create_time")
    @CreationTimestamp
    private LocalDateTime create_time;

    public Post(String title, String author, String contents) {
        this.title = title;
        this.author = author;
        this.contents = contents;
    }

    public void UpdateTitleContents(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
