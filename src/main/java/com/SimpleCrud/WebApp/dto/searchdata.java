package com.SimpleCrud.WebApp.dto;

public class searchdata {
    private String keyword;


    public searchdata() {
    }


    public searchdata(String keyword) {
        this.keyword = keyword;
    }


    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
