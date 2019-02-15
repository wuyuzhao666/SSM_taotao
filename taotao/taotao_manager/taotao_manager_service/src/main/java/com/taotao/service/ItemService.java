package com.taotao.service;

import com.taotao.common.pojo.EUDataGripResult;
import com.taotao.common.util.TaotaoResult;
import com.taotao.pojo.TbItem;

import java.util.List;

/**
 * by wyz on 2019/1/26/026.
 */
public interface ItemService {

    public TbItem getItemById(long id);



    public EUDataGripResult getAllItem(int page , int size);

    public TaotaoResult insertItem(TbItem tbItem);
}
