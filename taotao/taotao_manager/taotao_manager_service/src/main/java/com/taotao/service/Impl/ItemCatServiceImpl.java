package com.taotao.service.Impl;/**
 * by wyz on 2019/1/28/028.
 */

import com.taotao.common.pojo.TreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: taotao_parent
 *
 * @description:
 *
 * @author: Mr.Wu
 *
 * @create: 2019-01-28 13:44
 **/
@Service
public class ItemCatServiceImpl implements ItemCatService{

    @Autowired
    private TbItemCatMapper mapper;

    public List selectItemCat(int id) {

        List<TbItemCat> list = mapper.selectItemCat(id);

        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        for (TbItemCat tbItemCat: list) {
            TreeNode treeNode = new TreeNode(tbItemCat.getId(),tbItemCat.getName(),!tbItemCat.getIsParent()?"open":"closed");
            treeNodes.add(treeNode);
        }
        return treeNodes;
    }
}
