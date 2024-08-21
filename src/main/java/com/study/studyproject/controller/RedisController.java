package com.study.studyproject.controller;

import com.study.studyproject.service.RedisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/my-redis")
@RequiredArgsConstructor
public class RedisController {

    private final RedisTemplate<String, String> redisTemplate;
    private final RedisService redisService;

    @GetMapping("/select/{key}")
    public ResponseEntity<?> getRedisKey(@PathVariable String key) {
        var value = redisService.getValue(key);
        log.info("### RedisController getRedisKey() : {}", value);
        return new ResponseEntity<>(value, HttpStatus.OK);
    }

    @GetMapping("/select-all")
    public ResponseEntity<?> selectAll() {
        var keys = redisService.selectAll();
        if (keys != null) {
            keys.forEach((key) -> {
                var value = redisTemplate.opsForValue().get(key);
                log.info("### RedisController selectAll() key : {}, value : {}", key, value);
            });
        }else {
            log.info("### RedisController selectAll() IS NULL");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveRedis(@RequestBody Map<String, String> param) {
        param.forEach(redisService::save);
        return new ResponseEntity<>(param, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteRedis(@RequestBody String key) {
        redisService.delete(key);
        return new ResponseEntity<>(key, HttpStatus.OK);
    }

}