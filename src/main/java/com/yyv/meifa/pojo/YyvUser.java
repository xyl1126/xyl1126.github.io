package com.yyv.meifa.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class YyvUser {
    private Integer id;
    private String userName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date firstTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastTime;
    private long phone;
    private Integer userCode;
    private double sumjin;
    private double yuE;
    private int zcount;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(Date firstTime) {
        this.firstTime = firstTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Integer getUserCode() {
        return userCode;
    }

    public void setUserCode(Integer userCode) {
        this.userCode = userCode;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
}
