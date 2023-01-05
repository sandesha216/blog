package com.ty.blog.contraller;

import com.ty.blog.domain.request.PostSaveRequest;
import com.ty.blog.domain.response.PostDataResponse;
import com.ty.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/save")
    public ResponseEntity<Boolean> savePost(@RequestBody PostSaveRequest request) {
        boolean post = postService.savePost(request);
        return ResponseEntity.ok(post);
    }
    @GetMapping("/data/by-author-id")
    public List<PostDataResponse> getDataByAuthorId(@RequestParam long authorId) throws Exception {
       return postService.postsByAuthorId(authorId);
    }
    @PostMapping("/publish")
    public void PostPublish(@RequestParam Long postId) throws Exception {
       postService.postPublish(postId);
    }
}
