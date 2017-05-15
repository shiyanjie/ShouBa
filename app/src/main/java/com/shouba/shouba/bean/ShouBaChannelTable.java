package com.shouba.shouba.bean;

/**
 * des:瘦吧分类
 * Created by syj
 * on 2017.05.09 10:22
 */
public class ShouBaChannelTable {
    private String channelId;
    private String channelName;

    public ShouBaChannelTable(String channelId, String channelName){
        this.channelId=channelId;
        this.channelName=channelName;
    }
    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}
