package com.ty.blog.service.impl;

import com.ty.blog.domain.entity.Category;
import com.ty.blog.domain.entity.Post;
import com.ty.blog.domain.entity.Tag;
import com.ty.blog.domain.entity.User;
import com.ty.blog.domain.request.PostSaveRequest;
import com.ty.blog.domain.response.PostDataResponse;
import com.ty.blog.helper.PostHelper;
import com.ty.blog.helper.UserHelper;
import com.ty.blog.repository.CategoryRepository;
import com.ty.blog.repository.PostRepository;
import com.ty.blog.repository.TagRepository;
import com.ty.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static com.ty.blog.constant.ErrorMassage.EXCEPTION_WHILE_RETRIEVING_THE_POST_DETAILS;
import static com.ty.blog.constant.ErrorMassage.EXCEPTION_WHILE_RETRIEVING_THE_USER_DETAILS;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PostRepository  postRepository;
    @Override
    public boolean savePost(PostSaveRequest request) {
        Post post = PostHelper.PostEntityConverter(request, getTags(request.tagId()), getCategories(request.categoryId()));
        return postRepository.save(post) != null ? Boolean.TRUE : Boolean.FALSE;
    }

    private List<Category> getCategories(HashSet<Long> categoryId) {
        return categoryRepository.findAllById(categoryId);
    }

    private List<Tag> getTags(HashSet<Long> tagId) {
        return tagRepository.findAllById(tagId);
    }

    @Override
    public List<PostDataResponse> postsByAuthorId(long authorId) throws Exception {
        Optional<List<Post>> post;
        try {
            post = postRepository.findByAuthorId(authorId);
        } catch (Exception e) {
            throw new Exception(EXCEPTION_WHILE_RETRIEVING_THE_POST_DETAILS);
        }
        return post.isPresent() == true ? PostHelper.postDataResponseConverter(post.get()) : null;

    }

    @Override
    public void postPublish(Long postId) throws Exception {
        Optional<Post> post;
        try {
            post = postRepository.findById(postId);
        } catch (Exception e) {
            throw new Exception(EXCEPTION_WHILE_RETRIEVING_THE_POST_DETAILS);
        }
        if(post.isPresent()) {
            post.get().setPublished(Boolean.TRUE);
            post.get().setPublishedAt(LocalDateTime.now());
            post.get().setUpdatedAt(LocalDateTime.now());
            postRepository.save(post.get());
        }
    }
}
