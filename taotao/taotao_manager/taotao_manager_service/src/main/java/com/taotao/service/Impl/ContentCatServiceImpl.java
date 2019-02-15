package com.taotao.service.Impl;/**
 * by wyz on 2019/1/29/029.
 */

import com.taotao.common.pojo.TreeNode;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbItemCat;
import com.taotao.service.ContentCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: taotao_parent
 *
 * @description:
 *
 * @author: Mr.Wu
 *
 * @create: 2019-01-29 21:23
 **/
@Service
public class ContentCatServiceImpl implements ContentCatService {

    @Autowired
    private TbContentCategoryMapper mapper;
    public List selectContentCategory(long parentId) {

        List<TbContentCategory> list = mapper.selectContentCategory(parentId);

        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        for (TbContentCategory tbContentCategory: list) {
            TreeNode treeNode = new TreeNode(tbContentCategory.getId(),tbContentCategory.getName(),!tbContentCategory.getIsParent()?"open":"closed");
            treeNodes.add(treeNode);
        }
        return treeNodes;
    }

    public String insertContentCat(long parentId, String name) {
        try {
            TbContentCategory category = new TbContentCategory();
            category.setParentId(parentId);
            category.setName(name);
            Date date = new Date();
            category.setCreated(date);
            category.setUpdated(date);
            if(parentId == 0 || parentId == 30 || parentId == 86){
                category.setIsParent(true);
            }else {
                category.setIsParent(false);
            }
            mapper.createItemCat(category);
        } catch (Exception e) {
            e.printStackTrace();
            return "400";
        }

        return "200";
    }
}
