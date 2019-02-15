package com.taotao.search.service.Impl;/**
 * by wyz on 2019/2/14/014.
 */

import com.taotao.search.dao.SearchDao;
import com.taotao.search.pojo.SearchResult;
import com.taotao.search.service.SearchService;
import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: taotao_parent
 *
 * @description:
 *
 * @author: Mr.Wu
 *
 * @create: 2019-02-14 09:56
 **/
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchDao searchDao;

    @Override
    public SearchResult search(String queryString, int page, int rows) {

        SolrQuery query = new SolrQuery();
        query.setQuery(queryString);
        query.setStart((page-1) * rows);
        query.setRows(rows);

        //设置默认搜素域
        query.set("df", "item_keywords");
        //设置高亮显示
        query.setHighlight(true);
        query.addHighlightField("item_title");
        query.setHighlightSimplePre("<em style=\"color:red\">");
        query.setHighlightSimplePost("</em>");
        //执行查询
        SearchResult searchResult = searchDao.search(query);
        long recordCount = searchResult.getNumCount();
        long pageCount = recordCount / rows;
        if (recordCount % rows > 0) {
            pageCount++;
        }
        searchResult.setPageCount(pageCount);
        searchResult.setCurPage(page);



        return searchResult;
    }
}
