package com.taotao.rest.controller;/**
 * by wyz on 2019/2/12/012.
 */

import com.taotao.common.util.TaotaoResult;
import com.taotao.rest.service.SyncCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: taotao_parent
 *
 * @description:
 *
 * @author: Mr.Wu
 *
 * @create: 2019-02-12 17:50
 **/
@Controller
public class SyncCacheController {

    @Autowired
    private SyncCacheService syncCacheService;

    @RequestMapping("/sync/{id}")
    private TaotaoResult syncCache(@PathVariable String id){
        TaotaoResult taotaoResult = syncCacheService.syncCache(id);
        return taotaoResult;
    }

}
