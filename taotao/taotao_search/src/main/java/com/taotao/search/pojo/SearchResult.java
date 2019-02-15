package com.taotao.search.pojo;/**
 * by wyz on 2019/2/14/014.
 */

import java.util.List;

/**
 * @program: taotao_parent
 *
 * @description:
 *
 * @author: Mr.Wu
 *
 * @create: 2019-02-14 08:58
 **/

public class SearchResult {
    private List<Item> items;

    private long numCount;

    private long pageCount;

    private long curPage;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public long getNumCount() {
        return numCount;
    }

    public void setNumCount(long numCount) {
        this.numCount = numCount;
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    public long getCurPage() {
        return curPage;
    }

    public void setCurPage(long curPage) {
        this.curPage = curPage;
    }
}
