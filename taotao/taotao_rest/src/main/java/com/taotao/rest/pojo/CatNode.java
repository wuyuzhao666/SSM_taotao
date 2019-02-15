package com.taotao.rest.pojo;/**
 * by wyz on 2019/1/29/029.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @program: taotao_parent
 *
 * @description:
 *
 * @author: Mr.Wu
 *
 * @create: 2019-01-29 14:38
 **/

public class CatNode {
    @JsonProperty("u")
    private String url;
    @JsonProperty("n")
    private String name;
    @JsonProperty("i")
    private List<?> item;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<?> getItem() {
        return item;
    }

    public void setItem(List<?> item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "CatNode{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", item=" + item +
                '}';
    }
}
