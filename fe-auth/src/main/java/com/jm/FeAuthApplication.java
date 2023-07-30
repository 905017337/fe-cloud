package com.jm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author caozhenhao
 * @version 1.0
 * @date 2023/7/30 11:58
 */
@MapperScan({"com.jm.mapper"})
@SpringBootApplication
public class FeAuthApplication {
    public static void main(String[] args) {

        SpringApplication.run(FeAuthApplication.class, args);
    }
}