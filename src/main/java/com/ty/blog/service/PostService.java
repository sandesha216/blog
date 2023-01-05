package com.ty.blog.service;

import com.ty.blog.domain.request.PostSaveRequest;
import com.ty.blog.domain.response.PostDataResponse;

import java.util.List;

public interface PostService {
    boolean savePost(PostSaveRequest request);
    List<PostDataResponse> postsByAuthorId(long authorId) throws Exception;
    void postPublish(Long postId) throws Exception;
}
