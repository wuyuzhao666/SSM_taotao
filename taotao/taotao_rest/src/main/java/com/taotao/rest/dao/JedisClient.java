package com.taotao.rest.dao;

/**
 * by wyz on 2019/2/11/011.
 */
public interface JedisClient {
    String set(String key ,String value);

    String get(String key);

    Long hset(String hkey, String key , String value);

    String hget(String hkey , String key);

    Long del(String key);

    Long hdel(String hkey, String key);

    void expire(String key ,int seconds);
}
