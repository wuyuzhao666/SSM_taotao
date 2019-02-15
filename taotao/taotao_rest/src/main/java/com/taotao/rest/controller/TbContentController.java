package com.taotao.rest.controller;/**
 * by wyz on 2019/1/30/030.
 */

import com.taotao.common.util.ExceptionUtil;
import com.taotao.common.util.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.rest.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
 * @create: 2019-01-30 14:16
 **/
@Controller
@RequestMapping("/content")
public class TbContentController {

    @Autowired
    private TbContentService tbContentService;

    @RequestMapping("/list/{contentCategoryId}")
    @ResponseBody
    public TaotaoResult getContentList(@PathVariable Long contentCategoryId) {
        try {
            List<TbContent> list = tbContentService.getContentList(contentCategoryId);
            return TaotaoResult.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        }
    }

}
