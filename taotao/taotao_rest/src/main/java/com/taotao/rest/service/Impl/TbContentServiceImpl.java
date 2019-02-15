package com.taotao.rest.service.Impl;/**
 * by wyz on 2019/1/30/030.
 */

import com.taotao.common.util.JsonUtils;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.rest.service.JedisClient;
import com.taotao.rest.service.TbContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: taotao_parent
 *
 * @description:
 *
 * @author: Mr.Wu
 *
 * @create: 2019-01-30 14:11
 **/
@Service
public class TbContentServiceImpl implements TbContentService {


    @Value("${INDEX_CONTENT_REDIS_KEY}")
    private String INDEX_CONTENT_REDIS_KEY;

    @Autowired
    private TbContentMapper mapper;
    @Autowired
    private JedisClient jedisClient;

    @Override
    public List getContentList(long id) {

//        查询缓存
        try{
            System.out.println("查询缓存");
            String s = jedisClient.hget(INDEX_CONTENT_REDIS_KEY, id + "");
            System.out.println(INDEX_CONTENT_REDIS_KEY);
            if(!StringUtils.isBlank(s)){
                List<TbContent> tbContents = JsonUtils.jsonToList(s, TbContent.class);
                return  tbContents;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        TbContentExample example = new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(id);
        List<TbContent> tbContents = mapper.selectByExample(example);
//        存入缓存
        try{
            System.out.println("存入缓存");
            String s = JsonUtils.objectToJson(tbContents);
            jedisClient.hset(INDEX_CONTENT_REDIS_KEY,id+"",s);
        }catch (Exception e){
            e.printStackTrace();
        }
        return tbContents;
    }
}
