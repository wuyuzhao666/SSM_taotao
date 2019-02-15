package com.taotao.service.Impl;/**
 * by wyz on 2019/1/27/027.
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGripResult;
import com.taotao.common.util.IDUtils;
import com.taotao.common.util.TaotaoResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @program: taotao_parent
 *
 * @description:
 *
 * @author: Mr.Wu
 *
 * @create: 2019-01-27 08:38
 **/
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper mapper;
    public TbItem getItemById(long id) {
        return mapper.getItemById(id);
    }

    public EUDataGripResult getAllItem(int page ,int size) {
        System.out.println("page:"+page+",size"+size);
        PageHelper.startPage(page,size);
        List<TbItem> allItem = mapper.getAllItem();
        EUDataGripResult result = new EUDataGripResult();
        PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(allItem);
        System.out.println(pageInfo.getTotal());
        result.setTotal(pageInfo.getTotal());
        result.setRows(allItem);
        return result;
    }

    public TaotaoResult insertItem(TbItem tbItem) {
        tbItem.setId(IDUtils.genItemId());
        tbItem.setCreated((Timestamp) new Date());
        TaotaoResult insert = mapper.insert(tbItem);
        return null;
    }
}
