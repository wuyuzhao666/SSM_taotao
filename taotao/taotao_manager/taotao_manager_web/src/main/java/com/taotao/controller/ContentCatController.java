package com.taotao.controller;/**
 * by wyz on 2019/1/29/029.
 */

import com.taotao.common.pojo.TreeNode;
import com.taotao.service.ContentCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
 * @create: 2019-01-29 21:27
 **/
@Controller
@RequestMapping("/content/category")
public class ContentCatController {

    @Autowired
    private ContentCatService contentCatService;

    @RequestMapping("/list")
    @ResponseBody
    public List selectItemCat(@RequestParam(value = "id",defaultValue = "0") Long id){

        List<TreeNode> list = contentCatService.selectContentCategory(id);
        return list;
    }

    @RequestMapping("/create")
    @ResponseBody
    public Map createItemCat(Long parentId , String name){
        String s = contentCatService.insertContentCat(parentId, name);

        Map<String,String> map = new HashMap<>();
        map.put("status",s);
        return map;
    }
}
