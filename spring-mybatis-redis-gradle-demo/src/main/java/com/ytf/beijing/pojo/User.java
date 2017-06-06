package com.ytf.beijing.pojo;

import java.io.Serializable;

public class User implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return name;
    }

    public void setUserName(String userName) {
        this.name = userName == null ? null : userName.trim();
    }
}
