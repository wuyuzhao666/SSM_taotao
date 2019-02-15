package com.taotao.search.controller;/**
 * by wyz on 2019/2/14/014.
 */

import com.taotao.common.util.TaotaoResult;
import com.taotao.search.pojo.Item;
import com.taotao.search.pojo.SearchResult;
import com.taotao.search.service.SearchService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: taotao_parent
 *
 * @description:
 *
 * @author: Mr.Wu
 *
 * @create: 2019-02-14 10:14
 **/
@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping("/query")
    @ResponseBody
    public TaotaoResult search(@RequestParam("q") String queryString,
                               @RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "60") Integer rows){


        System.out.println(page);
        System.out.println(rows);
        if(StringUtils.isBlank(queryString)){
            return TaotaoResult.build(400,"查询条件不能为空");
        }
        SearchResult searchResult = null;
        try{
            queryString = new String(queryString.getBytes("iso8859-1"),"utf-8");
           searchResult = searchService.search(queryString, page, rows);
            List<Item> items = searchResult.getItems();
        }catch (Exception e){
            return TaotaoResult.build(500,e.getMessage());
        }
        return TaotaoResult.ok(searchResult);


    }

}
