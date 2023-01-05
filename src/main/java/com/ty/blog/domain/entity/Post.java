package com.ty.blog.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private Long authorId;
    private String myParentId;
    private String parentId;
    private String title;
    private String metaTitle;
    private String slug;
    private String summary;
    private Boolean published;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime publishedAt;
    private String content;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "post_Category", joinColumns = {@JoinColumn(name = "postId")}, inverseJoinColumns = {@JoinColumn(name = "categoryId")})
    private List<Category> categories;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "post_tag", joinColumns = {@JoinColumn(name = "postId")}, inverseJoinColumns = {@JoinColumn(name = "tagId")})
    private List<Tag> tags;

}
