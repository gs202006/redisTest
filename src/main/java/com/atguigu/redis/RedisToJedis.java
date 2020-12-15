package com.atguigu.redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class RedisToJedis {
    public static void main(String[] args) {
        Jedis hadoop103 = new Jedis("hadoop103", 6379);
        Set<String> keys = hadoop103.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
    }
}
