package com.mystery.entity;

import com.alibaba.fastjson.annotation.JSONType;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
@Component
@JSONType(orders={"id","numberl","username","contactnumber","dormitory","dormitoryid","abnormal","diagnosis","highrisk","source","time","warning"})
public class Healthdaily {
    private int id;    //id
    private int numberl;    //用户学号
    private String username;    //姓名
    private Long contactnumber;    //联系方式，手机号
    private String dormitory;    //宿舍楼层
    private int dormitoryid;    //宿舍号码
    private int abnormal;    //是否异常，0无，1有
    private int diagnosis;    //是否确诊，0无，1有
    private int highrisk;    //是否去过高风险地区，0无，1有
    private String source;    //检测来源
    private Timestamp time;    //上报时间
    private int warning;    //是否被警告
    
    public Healthdaily(){}
    public Healthdaily( int numberl, String username, Long contactnumber, String dormitory, int dormitoryid, int abnormal, int diagnosis, int highrisk, String source, Timestamp time, int warning) {
        this.numberl = numberl;
        this.username = username;
        this.contactnumber = contactnumber;
        this.dormitory = dormitory;
        this.dormitoryid = dormitoryid;
        this.abnormal = abnormal;
        this.diagnosis = diagnosis;
        this.highrisk = highrisk;
        this.source = source;
        this.time = time;
        this.warning = warning;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberl() {
        return numberl;
    }

    public void setNumberl(int numberl) {
        this.numberl = numberl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(Long contactnumber) {
        this.contactnumber = contactnumber;
    }

    public String getDormitory() {
        return dormitory;
    }

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory;
    }

    public int getDormitoryid() {
        return dormitoryid;
    }

    public void setDormitoryid(int dormitoryid) {
        this.dormitoryid = dormitoryid;
    }

    public int getAbnormal() {
        return abnormal;
    }

    public void setAbnormal(int abnormal) {
        this.abnormal = abnormal;
    }

    public int getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(int diagnosis) {
        this.diagnosis = diagnosis;
    }

    public int getHighrisk() {
        return highrisk;
    }

    public void setHighrisk(int highrisk) {
        this.highrisk = highrisk;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getWarning() {
        return warning;
    }

    public void setWarning(int warning) {
        this.warning = warning;
    }
}
