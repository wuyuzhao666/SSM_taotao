package com.taotao.mapper;


import com.taotao.pojo.TbItemCat;

import java.util.List;

public interface TbItemCatMapper {
    public List selectItemCat(long id);

    public TbItemCat selectItemCatById(int id);

}