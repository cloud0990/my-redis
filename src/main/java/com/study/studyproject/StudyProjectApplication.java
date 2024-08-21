package com.study.studyproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Slf4j
@SpringBootApplication
public class StudyProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyProjectApplication.class, args);
        /*SpringApplication springApplication = new SpringApplication(StudyProjectApplication.class);
        ApplicationContext context = springApplication.run(args);
        Environment env = context.getEnvironment();

        log.info("Redis Host : {}", env.getProperty("spring.data.redis.host"));
        log.info("Redis Port : {}", env.getProperty("spring.data.redis.port"));*/
    }

}
