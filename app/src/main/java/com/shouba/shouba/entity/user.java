package com.shouba.shouba.entity;

/**
 * Created by Administrator on 2017/6/29.
 */

public class user extends BaseModel {
    public static final int SEX_NO = 0;    //未设置
    public static final int SEX_MALE = 1;  //男
    public static final int SEX_FEMALE = 2;    //女

    public static final String SEX_MALE_STR = "男";
    public static final String SEX_FEMALE_STR = "女";

    private int id;
    private String uid;
    private String name;
    private String iconurl;
    private String gender;
}
