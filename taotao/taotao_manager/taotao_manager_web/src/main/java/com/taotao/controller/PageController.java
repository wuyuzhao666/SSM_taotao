package com.taotao.controller;/**
 * by wyz on 2019/1/27/027.
 */

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: taotao_parent
 *
 * @description:
 *
 * @author: Mr.Wu
 *
 * @create: 2019-01-27 20:46
 **/
@Controller
public class PageController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    @RequestMapping("/{path}")
    public String showPage(@PathVariable String path){

        return path;
    }


}
