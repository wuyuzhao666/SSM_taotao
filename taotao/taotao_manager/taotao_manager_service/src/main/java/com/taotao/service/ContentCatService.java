package com.taotao.service;

import java.util.List;

/**
 * by wyz on 2019/1/29/029.
 */
public interface ContentCatService {
    public List selectContentCategory(long parentId);

    public String insertContentCat(long parentId,String name);
}
