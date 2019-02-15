package com.taotao.search.service;

import com.taotao.search.pojo.SearchResult;

/**
 * by wyz on 2019/2/14/014.
 */
public interface SearchService {

    SearchResult search(String queryString,int page ,int rows);
}
