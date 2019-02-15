package com.taotao.portal.controller;/**
 * by wyz on 2019/1/29/029.
 */

import com.taotao.portal.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: taotao_parent
 *
 * @description:
 *
 * @author: Mr.Wu
 *
 * @create: 2019-01-29 10:09
 **/
@Controller
public class IndexController {

    @Autowired
    private TbContentService tbContentService;

    @RequestMapping("/index")
    public String indexShow(Model model){
        String contentList = tbContentService.getContentList();
        model.addAttribute("ad1",contentList);


        return "index";
    }
}
