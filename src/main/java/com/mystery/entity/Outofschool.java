package com.mystery.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@JSONType(orders={"id","number","photo","leavecontent","leavetime","approval"})
public class Outofschool {
    private int id;               //ID
    private String number;           //学号
    private  String photo;        //用户头像
    private String leavecontent;  //申请内容
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Timestamp leavetime;  //申请提交时间
    private int approval;         //申请提交状态



    public Outofschool(){}

    public Outofschool( String number, String leavecontent, Timestamp leavetime, int approval, String photo) {
        this.number = number;
        this.leavecontent = leavecontent;
        this.leavetime = leavetime;
        this.approval = approval;
        this.photo = photo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLeavecontent() {
        return leavecontent;
    }

    public void setLeavecontent(String leavecontent) {
        this.leavecontent = leavecontent;
    }

    public Timestamp getLeavetime() {
        return leavetime;
    }

    public void setLeavetime(Timestamp leavetime) {
        this.leavetime = leavetime;
    }

    public int getApproval() {
        return approval;
    }

    public void setApproval(int approval) {
        this.approval = approval;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
