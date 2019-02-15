package com.taotao.rest.service;

import com.taotao.common.util.TaotaoResult;

/**
 * by wyz on 2019/2/12/012.
 */
public interface SyncCacheService {

    TaotaoResult syncCache(String key);
}
