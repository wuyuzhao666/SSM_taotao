package com.taotao.rest.service.Impl;/**
 * by wyz on 2019/2/12/012.
 */

import com.taotao.common.util.TaotaoResult;
import com.taotao.rest.dao.JedisClient;
import com.taotao.rest.service.SyncCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @program: taotao_parent
 *
 * @description:
 *
 * @author: Mr.Wu
 *
 * @create: 2019-02-12 17:46
 **/
@Service
public class SyncCacheServiceImpl implements SyncCacheService {


    @Value("${INDEX_CONTENT_REDIS_KEY}")
    private String INDEX_CONTENT_REDIS_KEY;

    @Autowired
    private JedisClient jedisClient;

    @Override
    public TaotaoResult syncCache(String key) {
        try {
            Long hdel = jedisClient.hdel(INDEX_CONTENT_REDIS_KEY, key+"");
            return TaotaoResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500,e.getMessage());
        }
    }
}
