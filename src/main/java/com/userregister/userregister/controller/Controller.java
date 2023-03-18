package com.userregister.userregister.controller;

import com.userregister.userregister.model.Comment;
import com.userregister.userregister.model.CommentDTO;
import com.userregister.userregister.model.Post;
import com.userregister.userregister.model.PostDTO;
import com.userregister.userregister.model.Report;
import com.userregister.userregister.model.User;
import com.userregister.userregister.model.UserLogin;
import com.userregister.userregister.service.ICommentService;
import com.userregister.userregister.service.IFileStorageService;
import com.userregister.userregister.service.IPostService;
import com.userregister.userregister.service.IReportService;
import com.userregister.userregister.service.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@AllArgsConstructor
public class Controller {
    @Autowired
    public IUserService userService;
    @Autowired 
    public IPostService postService;
    @Autowired
    public ICommentService commentService;
    @Autowired 
    public IFileStorageService fileStorageService;
    public HttpServletRequest request;
    @Autowired
    public IReportService reportService;
    
    @PostMapping ("/new/user")
    public void saveUser (@RequestBody User user) {
        userService.saveUser(user);
    }
    @PutMapping ("/update/user")
    public void updateUser (@RequestBody User user) {
        userService.saveUser(user);
    }
    @DeleteMapping ("/delete/user")
    public void deleteUser (@RequestParam int id) {
        userService.deleteUser(id);
    }
    @GetMapping ("/get/all-users")
    public List<User> getAllUsers () {
        System.out.println(userService.usersList());
        return userService.usersList();
    }
    @GetMapping ("/get/user-by-id")
    public User getUserById (@RequestParam int id) {
        return userService.findById(id);
    }
    @PostMapping ("/login")
    public User login(@RequestBody UserLogin user) {
        return userService.login(user.getUsername(), user.getPassword());
    }
    @PostMapping ("/new/post")
    public void savePost (@RequestBody Post post) {
        postService.savePost(post);
    }
    @DeleteMapping ("/delete/post")
    public void deletePost (@RequestParam int id) {
        postService.deletePost(id);
    }
    @GetMapping ("/get/all-posts")
    public List<PostDTO> getPosts () {
        List<PostDTO> postsList = new ArrayList();
        for (Post item : postService.getPosts()) {
            PostDTO postCustom = new PostDTO();
            postCustom.setId(item.getId());
            postCustom.setTitle(item.getTitle());
            postCustom.setBody(item.getBody());
            postCustom.setImage(item.getImage());
            postCustom.setDate(item.getDate());
            postCustom.setIdUserOwner(item.getUserOwner().getId());
            //
            List<CommentDTO> commentsList = new ArrayList();
            for (Comment comment : item.getPostComments()) {
                CommentDTO commentCustom = new CommentDTO();
                commentCustom.setId(comment.getId());
                commentCustom.setText(comment.getText());
                commentCustom.setIdPostFk(comment.getPost().getId());
                commentCustom.setIdUserFk(comment.getUser().getId());
                commentCustom.setUsername(comment.getUser().getUsername());
                commentsList.add(commentCustom);
            }
            postCustom.setPostComments(commentsList);
            postsList.add(postCustom);
        }
        return postsList;
    }
    @GetMapping ("/get/all-posts-by-owner")
    public List<PostDTO> findByOwnerId (@RequestParam int id) {
        List<PostDTO> postsList = new ArrayList();
        for (Post item : postService.findByUserOwner(id)) {
            PostDTO postCustom = new PostDTO();
            postCustom.setId(item.getId());
            postCustom.setTitle(item.getTitle());
            postCustom.setBody(item.getBody());
            postCustom.setImage(item.getImage());
            postCustom.setDate(item.getDate());
            postCustom.setIdUserOwner(item.getUserOwner().getId());
            //
            List<CommentDTO> commentsList = new ArrayList();
            for (Comment comment : item.getPostComments()) {
                CommentDTO commentCustom = new CommentDTO();
                commentCustom.setId(comment.getId());
                commentCustom.setText(comment.getText());
                commentCustom.setIdPostFk(comment.getPost().getId());
                commentCustom.setIdUserFk(comment.getUser().getId());
                commentCustom.setUsername(comment.getUser().getUsername());
                commentsList.add(commentCustom);
            }
            postCustom.setPostComments(commentsList);
            postsList.add(postCustom);
        }
        return postsList;
    }
    @PostMapping ("/new/comment")
    public void saveComment (@RequestBody Comment comment) {
        commentService.saveComment(comment);
    }
    @DeleteMapping ("/delete/comment")
    public void deleteComment (@RequestParam int id) {
        commentService.deleteComment(id);
    }
    @GetMapping ("/get/all-comments")
    public List<CommentDTO> getAllComments () {
        List<CommentDTO> commentsList = new ArrayList();
        for (Comment item : commentService.getComments()) {
            CommentDTO commentCustom = new CommentDTO();
            commentCustom.setId(item.getId());
            commentCustom.setText(item.getText());
            commentCustom.setIdPostFk(item.getPost().getId());
            commentCustom.setIdUserFk(item.getUser().getId());
            commentCustom.setUsername(item.getUser().getUsername());
            commentsList.add(commentCustom);
        }
        return commentsList;
    }
    @GetMapping ("/get/all-comments-by-post-id")
    public List<CommentDTO> getAllCommentsByPostId (@RequestParam int id) {
        List<CommentDTO> commentsList = new ArrayList();
        for (Comment item : commentService.getCommentsByPostId(id)) {
            CommentDTO commentCustom = new CommentDTO();
            commentCustom.setId(item.getId());
            commentCustom.setText(item.getText());
            commentCustom.setIdPostFk(item.getPost().getId());
            commentCustom.setIdUserFk(item.getUser().getId());
            commentCustom.setUsername(item.getUser().getUsername());
            commentsList.add(commentCustom);
        }
        return commentsList;
    }
    
    @PostMapping("/upload")
    public Map<String, String> uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        String path = fileStorageService.store(multipartFile);
        String host = request.getRequestURL().toString().replace(request.getRequestURI(), "");
        String url = ServletUriComponentsBuilder.fromHttpUrl(host).path("/media/").path(path).toUriString();
        return Map.of("url", url);
    }
    @GetMapping("/media/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) throws IOException {
        Resource file = fileStorageService.loadAsResource(filename);
        String contentType = Files.probeContentType(file.getFile().toPath());
        
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, contentType).body(file);
    }
    @PostMapping("/save/report")
    public void saveReport (@RequestBody Report report) {
        reportService.saveReport(report);
    }
    @GetMapping("/get/all-reports")
    public List<Report> getAllReports (){
        return reportService.getReports();
    }
    @DeleteMapping("/delete/report")
    public void deleteReport (@RequestParam int id) {
        reportService.deleteReport(id);
    }
}
