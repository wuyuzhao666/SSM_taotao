package com.taotao.rest.dao.Impl;/**
 * by wyz on 2019/2/11/011.
 */

import com.taotao.rest.dao.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @program: taotao_parent
 *
 * @description:
 *
 * @author: Mr.Wu
 *
 * @create: 2019-02-11 20:32
 **/
@Repository
public class JedisSingleClientImpl implements JedisClient {

    @Autowired
    private JedisPool jedisPool;

    @Override
    public String set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        String set = jedis.set(key, value);
        jedis.close();
        return set;
    }

    @Override
    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String s = jedis.get(key);
        jedis.close();
        return s;
    }

    @Override
    public Long hset(String hkey, String key, String value) {
        Jedis jedis = jedisPool.getResource();
        Long hset = jedis.hset(hkey, key, value);
        jedis.close();
        return hset;
    }

    @Override
    public String hget(String hkey, String key) {
        Jedis jedis = jedisPool.getResource();
        String hget = jedis.hget(hkey, key);
        jedis.close();
        return hget;
    }

    @Override
    public Long del(String key) {
        Jedis jedis = jedisPool.getResource();
        Long del = jedis.del(key);
        jedis.close();
        return del;
    }

    @Override
    public Long hdel(String hkey, String key) {
        Jedis jedis = jedisPool.getResource();
        Long hdel = jedis.hdel(hkey, key);
        jedis.close();
        return hdel;
    }

    @Override
    public void expire(String key,int seconds) {
        Jedis jedis = jedisPool.getResource();
        jedis.expire(key,seconds);
        jedis.close();
    }
}
