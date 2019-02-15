package com.taotao.mapper;

import com.taotao.common.util.TaotaoResult;
import com.taotao.pojo.TbItem;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbItemMapper {
   public TbItem getItemById(long id);


   public List getAllItem();

   public TaotaoResult insert(TbItem tbItem);
}