package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baizhi.annotation.ChinaName;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {
    @ChinaName(name="编号")
    private Integer id;
    @ChinaName(name="姓名")
    private String name;
    @ChinaName(name="法名")
    private String dhamaname;
    @ChinaName(name="头像")
    private String img;
    @ChinaName(name="性别")
    private String sex;
    @ChinaName(name="住址")
    private String location;
    @ChinaName(name="签名")
    private String sign;
   @ChinaName(name="手机")
    private String phone;
   @ChinaName(name="密码")
    private String password;
   @ChinaName(name="盐值")
    private String salt;
   @ChinaName(name="状态")
    private String status;
   @ChinaName(name="注册时间")
   @JSONField(format = "yyyy-MM-dd")
   @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registtime;

   /* public User(String id,String name, String dhamaname, String img, String sex, String location, String sign, String phone, String password, String salt, String status, Date registtime) {
        this.id = id;
        this.name = name;
        this.dhamaname = dhamaname;
        this.img = img;
        this.sex = sex;
        this.location = location;
        this.sign = sign;
        this.phone = phone;
        this.password = password;
        this.salt = salt;
        this.status = status;
        this.registtime = registtime;
    }*/

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", dhamaname='" + dhamaname + '\'' + ", img='" + img + '\'' + ", sex='" + sex + '\'' + ", location='" + location + '\'' + ", sign='" + sign + '\'' + ", phone='" + phone + '\'' + ", password='" + password + '\'' + ", salt='" + salt + '\'' + ", status='" + status + '\'' + ", registtime=" + registtime + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDhamaname() {
        return dhamaname;
    }

    public void setDhamaname(String dhamaname) {
        this.dhamaname = dhamaname;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRegisttime() {
        return registtime;
    }

    public void setRegisttime(Date registtime) {
        this.registtime = registtime;
    }

    public User(Integer id, String name, String dhamaname, String img, String sex, String location, String sign, String phone, String password, String salt, String status, Date registtime) {
        this.id = id;
        this.name = name;
        this.dhamaname = dhamaname;
        this.img = img;
        this.sex = sex;
        this.location = location;
        this.sign = sign;
        this.phone = phone;
        this.password = password;
        this.salt = salt;
        this.status = status;
        this.registtime = registtime;
    }

    public User() {

    }
}
