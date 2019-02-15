package com.taotao.controller;/**
 * by wyz on 2019/1/26/026.
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGripResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: taotao_parent
 *
 * @description:
 *
 * @author: Mr.Wu
 *
 * @create: 2019-01-26 22:05
 **/
@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/getItemById")
    @ResponseBody
    public TbItem getItemById(@RequestBody TbItem tbItem){
        TbItem itemBy = itemService.getItemById(tbItem.getId());
        System.out.println(itemBy.toString());
        return itemBy;
    }

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGripResult listLimit(Integer page ,Integer rows){
        EUDataGripResult allItem = itemService.getAllItem(page, rows);


//        List itemLimit = itemService.getItemLimit(page, size);
        return allItem;


    }

}
