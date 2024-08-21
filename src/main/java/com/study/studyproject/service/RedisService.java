package com.study.studyproject.service;

import java.util.Set;

public interface RedisService {

    String getValue(String key);

    void save(String key, String value);

    void delete(String key);

    Set<String> selectAll();

}