package com.crowhyc.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * <p>
 * Description: com.crowhyc.graphql
 * </p>
 * date：2019/12/1
 * email:crowhyc@163.com
 *
 * @author Dean.Hwang
 */
@SpringBootApplication
@EnableJpaRepositories
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
