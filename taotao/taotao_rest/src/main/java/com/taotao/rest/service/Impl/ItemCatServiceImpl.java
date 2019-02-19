package com.taotao.rest.service.Impl;/**
 * by wyz on 2019/1/29/029.
 */

import com.taotao.common.util.JsonUtils;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.rest.pojo.CatNode;
import com.taotao.rest.pojo.Data;
import com.taotao.rest.service.ItemCatService;
import com.taotao.rest.dao.JedisClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: taotao_parent
 *
 * @description:
 *
 * @author: Mr.Wu
 *
 * @create: 2019-01-29 14:55
 **/
@Service
public class ItemCatServiceImpl implements ItemCatService {


    @Value("${INDEX_CONTENT_REDIS_KEY}")
    private String INDEX_CONTENT_REDIS_KEY;
    @Autowired
    private TbItemCatMapper mapper;
    @Autowired
    private JedisClient jedisClient;


    @Override
    public Data getItemList() {

        try{
            String hget = jedisClient.hget(INDEX_CONTENT_REDIS_KEY, 90 + "");
            System.out.println(hget);
            if(!StringUtils.isBlank(hget)){
                Data data = JsonUtils.jsonToPojo(hget, Data.class);
                return data;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        List<TbItemCat> parentCat = mapper.selectItemCat(0);
        Data data = new Data();
        int index = 1;
        List<CatNode> nodes = new ArrayList<>();
        for (TbItemCat tbItemCat : parentCat) {
            System.out.println(tbItemCat.toString());
            CatNode catNode = new CatNode();
            catNode.setUrl("/product/"+ index + ".html");
            catNode.setName("<a href='/products/" + index + ".html'>"+ tbItemCat.getName() + "</a>");
            index++;
            List<TbItemCat> sonCat = mapper.selectItemCat(tbItemCat.getId());
            List<CatNode> node0 = new ArrayList<>();
            for (TbItemCat tbItemCatSon: sonCat) {
                CatNode catNodeSon = new CatNode();
                catNodeSon.setUrl("/product/"+ index + ".html");
                catNodeSon.setName(tbItemCatSon.getName());
                index++;
                List<TbItemCat> childCat = mapper.selectItemCat(tbItemCatSon.getId());
                List<String> node = new ArrayList<>();
                for (TbItemCat tbItemCatChild : childCat) {
                    node.add("/products/"+ index + ".html |" + tbItemCatChild.getName());
                    index++;

                }
                catNodeSon.setItem(node);
                node0.add(catNodeSon);
            }
            catNode.setItem(node0);
            nodes.add(catNode);


        }
        data.setData(nodes);
        try{
            String s = JsonUtils.objectToJson(data);
            jedisClient.hset(INDEX_CONTENT_REDIS_KEY,90+"",s);
        }catch (Exception e){

        }

        return data;
    }
}
