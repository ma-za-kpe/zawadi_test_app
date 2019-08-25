
package com.maku.zawaditestapp.POJO;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Search {

    @SerializedName("searchedByName")
    @Expose
    private List<SearchedByName> searchedByName = null;

    public List<SearchedByName> getSearchedByName() {
        return searchedByName;
    }

    public void setSearchedByName(List<SearchedByName> searchedByName) {
        this.searchedByName = searchedByName;
    }

}
