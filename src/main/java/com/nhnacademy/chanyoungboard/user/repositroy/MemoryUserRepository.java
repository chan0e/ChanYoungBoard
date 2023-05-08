package com.nhnacademy.chanyoungboard.user.repositroy;

import com.nhnacademy.chanyoungboard.pagenation.Page;
import com.nhnacademy.chanyoungboard.user.domain.User;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;


@Slf4j
public class MemoryUserRepository implements UserRepository{

    private final ConcurrentMap<String, User> userMap = new ConcurrentHashMap<>();

    private int page = 1;

    @Override
    public void add(User user) {
        userMap.put(user.getId(),user);
    }

    @Override
    public void modify(User user) {
        User target = userMap.get(user.getId());
        if(Objects.nonNull(target)) {
            target.update(user.getPassword(), user.getName(), user.getRole());
        }
    }

    @Override
    public User remove(String id) {
        return userMap.remove(id);
    }

    @Override
    public User getUser(String id) {
        return userMap.get(id);
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public int getTotalCount() {
        return userMap.size();
    }

    @Override
    public Page<User> getPagedList(int page, int size) {
        return new Page<User>() {
            @Override
            public int getPageNumber() {
                return page;
            }

            @Override
            public int getPageSize() {
                return size;
            }

            @Override
            public int getTotalPageCount() {
                return (int)Math.ceil( (getTotalCount()*1.0) /getPageSize());
            }

            @Override
            public long getTotalCount() {
                return userMap.size();
            }

            @Override
            public List<User> getList() {
                List<User> users = userMap.values().stream()
                        // .filter(o -> o.getRole().equals(User.Role.USER))
                        .sorted(Comparator.comparing(User::getCreatedAt).reversed())
                        .collect(Collectors.toList());

                int start = (getPageNumber()-1)*getPageSize();
                int end = start + getPageSize();

                if(end > getTotalCount()){
                    end = (int) getTotalCount();
                }

                log.info("totalCount:{}" + getTotalCount());
                log.info("user-page-start:{}",start);
                log.info("user-page-end:{}",end);

                return users.subList(start,end);
            }
        };
    }

    @Override
    public boolean existById(String id) {
        return userMap.containsKey(id);
    }

}
