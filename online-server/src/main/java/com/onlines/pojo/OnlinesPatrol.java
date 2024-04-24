package com.onlines.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OnlinesPatrol {
    private Integer id;

    private String url;

    private String title;

    private String htmlinfo;

    private String groupId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createtime;

    private String datumAddress;

    private Date datumCreatetime;

    private String username;

    private Integer needLogin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHtmlinfo() {
        return htmlinfo;
    }

    public void setHtmlinfo(String htmlinfo) {
        this.htmlinfo = htmlinfo;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDatumAddress() {
        return datumAddress;
    }

    public void setDatumAddress(String datumAddress) {
        this.datumAddress = datumAddress;
    }

    public Date getDatumCreatetime() {
        return datumCreatetime;
    }

    public void setDatumCreatetime(Date datumCreatetime) {
        this.datumCreatetime = datumCreatetime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public Integer getNeedLogin() {
        return needLogin;
    }
    public void setNeedLogin(Integer needLogin) {
        this.needLogin = needLogin;
    }
}