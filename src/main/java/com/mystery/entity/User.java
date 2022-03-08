package com.mystery.entity;

import com.alibaba.fastjson.annotation.JSONType;
import org.springframework.stereotype.Component;

@Component
@JSONType(orders={"id","numberl","username","gender","college","speciality","classnumber","contactnumber","mail","photo","password","role","fullname"})
public class User {
    private Integer id;   //用户默认自增ID
    private String numberl;    //用户学号
    private String username;    //用户名
    private Integer gender;     //用户性别
    private String college;     //用户学院
    private String speciality;  //用户专业
    private Integer classnumber; //班级号
    private Long contactnumber; //联系电话
    private String mail;           //联系邮箱
    private String photo;       //学生照片地址
    private String password;    //用户密码
    private Integer role;       //用户角色，默认为学生
    private String fullname;    //用户真是姓名


    public  User(){

    }

    public User( String numberl,String username, String password, Integer role) {
        this.numberl=numberl;
        this.username = username;
        this.password = password;
        this.role = role;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", numberl=" + numberl +
                ", username='" + username + '\'' +
                ", gender=" + gender +
                ", college='" + college + '\'' +
                ", speciality='" + speciality + '\'' +
                ", classnumber=" + classnumber +
                ", contactnumber=" + contactnumber +
                ", mail='" + mail + '\'' +
                ", photo='" + photo + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", fullname='" + fullname + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumberl() {
        return numberl;
    }

    public void setNumberl(String numberl) {
        this.numberl = numberl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Integer getClassnumber() {
        return classnumber;
    }

    public void setClassnumber(Integer classnumber) {
        this.classnumber = classnumber;
    }

    public Long getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(Long contactnumber) {
        this.contactnumber = contactnumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
