package com.taotao.portal.service.Impl;/**
 * by wyz on 2019/1/30/030.
 */


import com.taotao.common.util.HttpClientUtil;
import com.taotao.common.util.JsonUtils;
import com.taotao.common.util.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.portal.service.TbContentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: taotao_parent
 *
 * @description:
 *
 * @author: Mr.Wu
 *
 * @create: 2019-01-30 14:25
 **/
@Service
public class TbContentServiceImpl implements TbContentService {

    @Value("${REST_BASE_URL}")
    private String REST_BASE_URL;
    @Value("${REST_INDEX_AD_URL}")
    private String REST_INDEX_AD_URL;

    @Override
    public String getContentList() {
        //调用服务层的服务
        System.out.println(REST_BASE_URL);
        System.out.println(REST_INDEX_AD_URL);
        String result = HttpClientUtil.doGet(REST_BASE_URL + REST_INDEX_AD_URL);
        //把字符串转换成TaotaoResult
        try {
            TaotaoResult taotaoResult = TaotaoResult.formatToList(result, TbContent.class);
            //取内容列表
            List<TbContent> list = (List<TbContent>) taotaoResult.getData();
            List<Map> resultList = new ArrayList<>();
            //创建一个jsp页码要求的pojo列表
            for (TbContent tbContent : list) {
                Map map = new HashMap<>();
                map.put("src", tbContent.getPic());
                map.put("height", 240);
                map.put("width", 670);
                map.put("srcB", tbContent.getPic2());
                map.put("widthB", 550);
                map.put("heightB", 240);
                map.put("href", tbContent.getUrl());
                map.put("alt", tbContent.getSubTitle());
                resultList.add(map);
            }
            return JsonUtils.objectToJson(resultList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
