package com.nhnacademy.chanyoungboard.admin.users.controller;


import com.nhnacademy.chanyoungboard.pagenation.Page;
import com.nhnacademy.chanyoungboard.user.domain.User;
import com.nhnacademy.chanyoungboard.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/users")
@RequiredArgsConstructor
@Slf4j
public class AdminController {
    private final UserService userService;

    @GetMapping(value = {"/list", "/",""})
    public String users(Model model, @RequestParam(name = "page", defaultValue = "1") int page,
                        @RequestParam(name = "size", defaultValue = "10")int size, HttpServletRequest request){
        Page<User> userPage =  userService.getUserList(page,size);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        User admin = userService.getUser(user.getId());

        for(int i=0; i< userPage.getList().size(); i++){
            log.info("user:{}",userPage.getList().get(i));
        }
        model.addAttribute("userPage", userPage);
        model.addAttribute("admin",admin);

        return "admin/users/list";
    }


}
