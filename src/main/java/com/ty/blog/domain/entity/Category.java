package com.ty.blog.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String MyParentId;
    private String parentId;
    private String title;
    private String metaTitle;
    private String slug;
    private String content;

}
