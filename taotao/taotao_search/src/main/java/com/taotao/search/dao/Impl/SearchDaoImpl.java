package com.taotao.search.dao.Impl;/**
 * by wyz on 2019/2/14/014.
 */

import com.taotao.search.dao.SearchDao;
import com.taotao.search.pojo.Item;
import com.taotao.search.pojo.SearchResult;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: taotao_parent
 *
 * @description:
 *
 * @author: Mr.Wu
 *
 * @create: 2019-02-14 09:01
 **/
@Repository
public class SearchDaoImpl implements SearchDao {

    @Autowired
    private HttpSolrClient solrClient;

    @Override
    public SearchResult search(SolrQuery query) {
        SearchResult searchResult = new SearchResult();
        try {

            QueryResponse response = solrClient.query(query);
            SolrDocumentList solrDocuments = response.getResults();
            long numFound = solrDocuments.getNumFound();
            searchResult.setNumCount(numFound);
            List<Item> itemList = new ArrayList<>();
            //取高亮显示
            Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
            //取商品列表
            for (SolrDocument solrDocument : solrDocuments) {
                //创建一商品对象
                Item item = new Item();
                item.setId((String) solrDocument.get("id"));
                //取高亮显示的结果
                List<String> list = highlighting.get(solrDocument.get("id")).get("item_title");
                String title = "";
                if (list != null && list.size()>0) {
                    title = list.get(0);
                } else {
                    title = (String) solrDocument.get("item_title");
                }
                item.setTitle(title);
                item.setImage((String) solrDocument.get("item_image"));
                item.setPrice((long) solrDocument.get("item_price"));
                item.setSell_point((String) solrDocument.get("item_sell_point"));
                item.setCategory_name((String) solrDocument.get("item_category_name"));
                //添加的商品列表
                itemList.add(item);
            }
            searchResult.setItems(itemList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return searchResult;
    }
}
