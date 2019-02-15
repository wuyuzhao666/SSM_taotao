package com.taotao.search.controller;/**
 * by wyz on 2019/2/13/013.
 */

import com.taotao.common.util.TaotaoResult;
import com.taotao.search.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: taotao_parent
 *
 * @description:
 *
 * @author: Mr.Wu
 *
 * @create: 2019-02-13 20:34
 **/
@Controller
@RequestMapping("/manager")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/importall")
    @ResponseBody
    public TaotaoResult getItemList(){

        TaotaoResult result = itemService.getItemList();
        return result;
    }
}
