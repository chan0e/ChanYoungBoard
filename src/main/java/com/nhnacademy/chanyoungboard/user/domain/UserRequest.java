package com.nhnacademy.chanyoungboard.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    @NotBlank (message = "아이디를 입력해주세요")
    private String id;
    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;
    @NotBlank(message = "이름을 입력해주세요")
    private String name;

    private String profileFileName;
    private User.Role role;

    private MultipartFile profileFile;

    public UserRequest(String id, String password, String name, String profileFileName, User.Role role) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.profileFileName = profileFileName;
        this.role = role;
    }


}
