package com.taotao.search.service.Impl;/**
 * by wyz on 2019/2/13/013.
 */

import com.taotao.common.util.TaotaoResult;
import com.taotao.search.mapper.ItemMapper;
import com.taotao.search.pojo.Item;
import com.taotao.search.service.ItemService;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: taotao_parent
 *
 * @description:
 *
 * @author: Mr.Wu
 *
 * @create: 2019-02-13 20:08
 **/
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private HttpSolrClient httpSolrClient;
    @Autowired
    private ItemMapper itemMapper;


    @Override
    public TaotaoResult getItemList() {
        List<Item> itemList = itemMapper.getItemList();

        try {
            for (Item item : itemList) {
                System.out.println(item.toString());
                SolrInputDocument document = new SolrInputDocument();
                document.setField("id", item.getId());
                document.setField("item_title", item.getTitle());
                document.setField("item_sell_point", item.getSell_point());
                document.setField("item_price", item.getPrice());
                document.setField("item_image", item.getImage());
                document.setField("item_category_name", item.getCategory_name());
                document.setField("item_desc", item.getItem_des());
                httpSolrClient.add(document);
            }
            httpSolrClient.optimize();
            httpSolrClient.commit();
            httpSolrClient.close();
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500,e.getMessage());

        }
        return TaotaoResult.ok();
    }
}
