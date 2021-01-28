package com.kevin.springboot;

import com.kevin.springboot.Utils.shiro.MybatisRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 *  Spring boot 的demo类
 *  @Author: Kevin Zhang @Date: 2020-11-23 16:56
**/
@SpringBootApplication(scanBasePackages = {"com.kevin.springboot"})
public class SpringBoot {
    public static void main(String[] args) {
        SpringApplication.run(SpringBoot.class, args);
    }

    @Bean
    public Realm realm() {
        MybatisRealm mybatisRealm = new MybatisRealm();
        return mybatisRealm;
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        // all paths are managed via annotations
        chainDefinition.addPathDefinition("/**", "anon");
        return chainDefinition;
    }
}
