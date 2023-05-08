package com.nhnacademy.chanyoungboard.user.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
@ToString
public class User {
    public enum Role{
        ADMIN, USER
    }

    private String id;
    private String password;
    private String name;
    private Role role;

    private LocalDateTime createdAt;

    private User(String id, String password, String name, Role role) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.role = role;
        this.createdAt = LocalDateTime.now();
    }

    public static User createAdmin(String id, String password, String name){
        return new User(id,password,name,Role.ADMIN);
    }

    public static User createUser(String id, String password, String name){
        return new User(id,password,name,Role.USER);
    }

    public void update(String password, String name, Role role){
        this.password = password;
        this.name = name;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return id != null ? id.equals(user.id) : user.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
