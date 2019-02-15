package com.taotao.controller;/**
 * by wyz on 2019/1/28/028.
 */

import com.taotao.common.pojo.TreeNode;
import com.taotao.service.ItemCatService;
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
 * @create: 2019-01-28 13:50
 **/
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/list")
    @ResponseBody
    public List selectItemCat(@RequestParam(value = "id",defaultValue = "0") Integer id){

        List<TreeNode> list = itemCatService.selectItemCat(id);
        return list;
    }
}
