package com.nhnacademy.chanyoungboard.config;


import com.nhnacademy.chanyoungboard.post.domain.Post;
import com.nhnacademy.chanyoungboard.post.repository.MemoryPostRepository;
import com.nhnacademy.chanyoungboard.post.repository.PostRepository;
import com.nhnacademy.chanyoungboard.user.domain.User;
import com.nhnacademy.chanyoungboard.user.repositroy.MemoryUserRepository;
import com.nhnacademy.chanyoungboard.user.repositroy.UserRepository;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;




@Configuration
@ComponentScan(basePackageClasses = {com.nhnacademy.chanyoungboard.Base.class},
        excludeFilters = @ComponentScan.Filter(Controller.class))
public class RootConfig {
    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("message");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public UserRepository userRepository(){
        UserRepository userRepository = new MemoryUserRepository();
        userRepository.add(User.createAdmin("admin","12345","영찬"));
        for (int i = 1; i <= 100; i++) {
                userRepository.add(User.createUser("user"+i,"1234","유저"+i));
            System.out.println(userRepository.getUser("user"+i));
        }

        System.out.println(userRepository.getUser("admin"));

        return userRepository;
    }

    @Bean
    public PostRepository postRepository(){
        PostRepository postRepository = new MemoryPostRepository();

        for (int i = 0; i < 35; i++) {
            postRepository.register(Post.createpost(i,"title"+i,"content"+i, "user"+i));
            System.out.println(postRepository.getPost(i));
        }

        return postRepository;

    }

}
