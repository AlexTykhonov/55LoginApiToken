package com.tae.a55loginapitoken;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import java.io.Serializable;

public class Pet implements Serializable {

//    @Id
//    private Long ids;

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("userId")
    @Expose
    private Integer userId;
    private final static long serialVersionUID = 2292327506375878095L;

    public Pet(Integer id, String name, Integer age, Integer userId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.userId = userId;
    }

    public Pet() {
    }
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return this.age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getUserId() {
        return this.userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }


}