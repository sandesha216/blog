package com.ty.blog.domain.entity;

import javax.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;


@Entity
@Data
@Table(name = "post_comment")
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;
    private String ParentId;
    private String title;
    private Boolean published;
    private LocalDateTime createdAt;
    private LocalDateTime publishedAt;
    private String content;

}
