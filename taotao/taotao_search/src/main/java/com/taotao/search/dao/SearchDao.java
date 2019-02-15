package com.taotao.search.dao;

import com.taotao.search.pojo.SearchResult;
import org.apache.solr.client.solrj.SolrQuery;

/**
 * by wyz on 2019/2/14/014.
 */
public interface SearchDao {

    SearchResult search(SolrQuery query);
}
