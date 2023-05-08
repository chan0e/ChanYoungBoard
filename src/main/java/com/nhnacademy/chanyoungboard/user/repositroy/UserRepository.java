package com.nhnacademy.chanyoungboard.user.repositroy;

import com.nhnacademy.chanyoungboard.pagenation.Page;
import com.nhnacademy.chanyoungboard.user.domain.User;

import java.util.List;

public interface UserRepository {
    void add(User user);

    void modify(User user);

    User remove(String id);

    User getUser(String id);

    List<User> getUsers();



//


    int getTotalCount();
    Page<User> getPagedList(int page, int size);
    boolean existById(String id);
}
