package com.ty.blog.domain.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "post_meta")
public class PostMeta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private Long postId;
    private String key;
    private String content;
}
