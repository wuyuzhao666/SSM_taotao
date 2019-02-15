package com.taotao.rest.service.Impl;/**
 * by wyz on 2019/2/11/011.
 */

import com.taotao.rest.service.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

/**
 * @program: taotao_parent
 *
 * @description:
 *
 * @author: Mr.Wu
 *
 * @create: 2019-02-11 20:42
 **/

public class JedisClusterClientImpl implements JedisClient {

    @Autowired
    private JedisCluster jedisCluster;

    @Override
    public String set(String key, String value) {
        return jedisCluster.set(key,value);
    }

    @Override
    public String get(String key) {
        return jedisCluster.get(key);
    }

    @Override
    public Long hset(String hkey, String key, String value) {
        return jedisCluster.hset(hkey,key,value);
    }

    @Override
    public String hget(String hkey, String key) {
        return jedisCluster.hget(hkey,key);
    }

    @Override
    public Long del(String key) {
        return jedisCluster.del(key);
    }

    @Override
    public Long hdel(String hkey, String key) {
        return jedisCluster.hdel(hkey,key);
    }
}
