package com.enigma.challengegoldpocket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AppConfigImpl implements AppConfigService{

    @Autowired
    RedisTemplate redisTemplate;


    @Override
    public String getValue(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

    @Override
    public void setValue(String key, Object value) {

    }

    @Override
    public Map<String, Object> getMap(String key) {
        return null;
    }
}
