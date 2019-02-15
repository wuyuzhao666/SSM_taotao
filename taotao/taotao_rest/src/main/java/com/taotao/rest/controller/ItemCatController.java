package com.taotao.rest.controller;/**
 * by wyz on 2019/1/29/029.
 */

import com.taotao.common.util.JsonUtils;
import com.taotao.rest.pojo.Data;
import com.taotao.rest.service.ItemCatService;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;

/**
 * @program: taotao_parent
 *
 * @description:
 *
 * @author: Mr.Wu
 *
 * @create: 2019-01-29 15:23
 **/
@Controller
public class ItemCatController {

    @Autowired
    public ItemCatService itemCatService;

    @RequestMapping( "/itemcat/all")
    @ResponseBody
    public String testX(String callback){
        Data itemList = itemCatService.getItemList();
        String string = callback + "(" + JsonUtils.objectToJson(itemList ) + ");";

        return string;
    }
}
