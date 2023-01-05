package com.ty.blog.helper;

import com.ty.blog.domain.entity.Category;
import com.ty.blog.domain.entity.Post;
import com.ty.blog.domain.entity.Tag;
import com.ty.blog.domain.request.PostSaveRequest;
import com.ty.blog.domain.response.PostDataResponse;
import com.ty.blog.repository.CategoryRepository;
import com.ty.blog.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service
public class PostHelper {

    public static Post PostEntityConverter(PostSaveRequest request, List<Tag> tags, List<Category> categories) {
        Post post = new Post();
        post.setAuthorId(request.authorId());
        if(request.parentId() != null) {
            post.setParentId(request.parentId());
        }
        post.setMyParentId(setMyParentId());
        post.setTitle(request.title());
        post.setMetaTitle(request.metaTitle());
        post.setSlug(request.slug());
        post.setSummary(request.summary());
        post.setPublished(request.published());
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());
        if(request.published()) {
            post.setPublishedAt(LocalDateTime.now());
        }
        post.setContent(request.content());
        post.setTags(tags);
        post.setCategories(categories);
        return post;
    }

    public static String setMyParentId() {
        String parentId = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        return parentId;
    }

    public static List<PostDataResponse> postDataResponseConverter(List<Post> post) {
      return  post.stream().map(post1 -> new PostDataResponse(post1.getId(), post1.getAuthorId(), post1.getMyParentId(), post1.getParentId(), post1.getTitle(),
                post1.getMetaTitle(), post1.getSlug(), post1.getSummary(), post1.getPublished(), post1.getCreatedAt(),
                post1.getUpdatedAt(), post1.getPublishedAt(), post1.getContent(), post1.getCategories(), post1.getTags())).toList();
    }
}
