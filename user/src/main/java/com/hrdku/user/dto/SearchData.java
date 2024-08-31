package com.hrdku.user.dto;

public class SearchData {
    private String searchKey;

    public SearchData() {
        super();
    }

    public SearchData(String searchKey) {
        super();
        this.searchKey = searchKey;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }
}
