package com.nhnacademy.chanyoungboard.admin.users.controller;

import com.nhnacademy.chanyoungboard.pagenation.Page;
import com.nhnacademy.chanyoungboard.post.domain.Post;
import com.nhnacademy.chanyoungboard.post.domain.PostRequest;
import com.nhnacademy.chanyoungboard.post.service.PostService;
import com.nhnacademy.chanyoungboard.user.domain.User;
import com.nhnacademy.chanyoungboard.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/board/posts/")
@RequiredArgsConstructor
public class BoardController {
    private final PostService postService;
    private final UserService userService;

    @GetMapping(value = {"/postlist", "/", ""})
    public String posts(Model model, @RequestParam(name = "page", defaultValue = "1") int page,
                        @RequestParam(name = "size", defaultValue = "10")int size, HttpServletRequest request){
        Page<Post> postpage = postService.getPostList(page,size);
        HttpSession session = request.getSession();
        User requestuser = (User) session.getAttribute("user");
        User user = userService.getUser(requestuser.getId());

        model.addAttribute("postPage",postpage);
        model.addAttribute("user",user);


        return "board/posts/postlist";
    }


    @GetMapping("/postview")
    public String posts(Model model, @RequestParam(name ="page", defaultValue = "1")int page,
                        @RequestParam(name = "size", defaultValue = "10")int size, Long id){

        Post post = postService.getPost(id);
        PostRequest postRequest = new PostRequest(post.getId(),post.getTitle(),post.getContent(),post.getWriter(),post.getCreatedAt());
        model.addAttribute("postRequest",postRequest);

        return "board/posts/postview";
    }

}
