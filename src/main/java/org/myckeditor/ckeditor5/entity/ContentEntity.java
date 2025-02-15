package org.myckeditor.ckeditor5.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ContentEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @Column(columnDefinition = "LONGTEXT")
    private String content;
}
