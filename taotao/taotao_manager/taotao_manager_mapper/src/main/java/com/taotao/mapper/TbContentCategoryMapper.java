package com.taotao.mapper;


import com.taotao.pojo.TbContentCategory;

import java.util.List;

public interface TbContentCategoryMapper {

    public List selectContentCategory(long parentId);

    public void createItemCat(TbContentCategory tbContentCategory);

}