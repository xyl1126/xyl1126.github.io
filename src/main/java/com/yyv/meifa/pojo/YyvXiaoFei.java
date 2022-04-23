package com.yyv.meifa.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class YyvXiaoFei {
    private Integer id;
    private Integer userId;
    private Integer spId;
    private double benci;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GTM+8")
    private Date xTime;
    private double sumjin;
    private double yuE;
    private int zcount;
    private String userName;
    private String spName;
    private Integer userCode;
    private double benciyuE;

    public double getBenciyuE() {
        return benciyuE;
    }

    public void setBenciyuE(double benciyuE) {
        this.benciyuE = benciyuE;
    }

    public Integer getUserCode() {
        return userCode;
    }

    public void setUserCode(Integer userCode) {
        this.userCode = userCode;
    }

    public double getSumjin() {
        return sumjin;
    }

    public void setSumjin(double sumjin) {
        this.sumjin = sumjin;
    }

    public double getYuE() {
        return yuE;
    }

    public void setYuE(double yuE) {
        this.yuE = yuE;
    }

    public int getZcount() {
        return zcount;
    }

    public void setZcount(int zcount) {
        this.zcount = zcount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSpName() {
        return spName;
    }

    public void setSpName(String spName) {
        this.spName = spName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSpId() {
        return spId;
    }

    public void setSpId(Integer spId) {
        this.spId = spId;
    }

    public double getBenci() {
        return benci;
    }

    public void setBenci(double benci) {
        this.benci = benci;
    }

    public Date getxTime() {
        return xTime;
    }

    public void setxTime(Date xTime) {
        this.xTime = xTime;
    }
}
