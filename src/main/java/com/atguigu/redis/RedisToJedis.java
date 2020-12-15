package com.atguigu.redis;

import org.junit.Test;
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

    @Test
    public void testJedisUtil() {
        Jedis jedis = RedisUtil.getJedisFromPool();
        Set<String> keys = jedis.keys("*");

        for (String key : keys) {
            System.out.println(key);
        }
    }

    @Test
    public void key() {
        Jedis jedis = RedisUtil.getJedisFromPool();
        jedis.set("gao", "sen");
        jedis.set("song", "sen");
        jedis.set("li", "sen");
        jedis.set("wang", "sen");
        System.out.println(jedis.get("gao"));

    }
    @Test
    public void string() {
        Jedis jedis = RedisUtil.getJedisFromPool();
        jedis.mset("str1","v1","str2","v2","str3","v3");
        System.out.println(jedis.mget("str1","str2","str3"));

    }
    @Test
    public void hash() {
        Jedis jedisFromPool = RedisUtil.getJedisFromPool();
        jedisFromPool.hset("hash1","userName","lisi");
        System.out.println(jedisFromPool.hget("hash1", "userName"));
    }

    @Test
    public void zSet() {
        Jedis jedis = RedisUtil.getJedisFromPool();
        jedis.zadd("zset01", 100d, "z3");
        jedis.zadd("zset01", 90d, "l4");
        jedis.zadd("zset01", 80d, "w5");
        jedis.zadd("zset01", 70d, "z6");

        Set<String> zrange = jedis.zrange("zset01", 0, -1);
        for (String s : zrange) {
            System.out.println(s);
        }
    }
}
