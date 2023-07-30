package com.jm;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author caozhenhao
 * @version 1.0
 * @date 2023/7/30 12:12
 */
@MapperScan({"com.jm.mapper","com.jm.core.mapper"})
@SpringBootApplication
public class FeCoreApplication {
    public static void main(String[] args) {

        SpringApplication.run(FeCoreApplication.class, args);
    }
}