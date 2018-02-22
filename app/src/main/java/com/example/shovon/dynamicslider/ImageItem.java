package com.example.shovon.dynamicslider;

/**
 * Created by SHOVON on 2/22/2018.
 */

public class ImageItem {
    public String id;
    public String prop_id;
    public String title;
    public Integer img_url;
    public String getId() {
        return id;
    }

    public Integer getImg_url() {
        return img_url;
    }

    public String getProp_id() {
        return prop_id;
    }

    public void setProp_id(String prop_id) {
        this.prop_id = prop_id;
    }

    public void setImg_url(Integer img_url) {
        this.img_url = img_url;
    }

    public void setId(String id) {
        this.id = id;

    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }



    public String getprop_id() {
        return prop_id;
    }
    public void setprop_id(String prop_id) {
        this.prop_id = prop_id;
    }

}
