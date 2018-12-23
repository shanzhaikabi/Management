package com.ssh.entity;

import javax.persistence.*;

@Entity
public class User {
    private String userid;
    private String name;
    private String password;
    private Integer identifyid;
    private Integer qq;
    private String wechat;
    private String address;
    private String tel;
    private String phone;
    private String email;
    private String homepage;
    private String identifytime;
    private String teltime;
    private String mailtime;
    private Integer status;
    private String createtime;

    @Id
    @Column(name = "userid")
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "identifyid")
    public Integer getIdentifyid() {
        return identifyid;
    }

    public void setIdentifyid(Integer identifyid) {
        this.identifyid = identifyid;
    }

    @Basic
    @Column(name = "qq")
    public Integer getQq() {
        return qq;
    }

    public void setQq(Integer qq) {
        this.qq = qq;
    }

    @Basic
    @Column(name = "wechat")
    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "homepage")
    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    @Basic
    @Column(name = "identifytime")
    public String getIdentifytime() {
        return identifytime;
    }

    public void setIdentifytime(String identifytime) {
        this.identifytime = identifytime;
    }

    @Basic
    @Column(name = "teltime")
    public String getTeltime() {
        return teltime;
    }

    public void setTeltime(String teltime) {
        this.teltime = teltime;
    }

    @Basic
    @Column(name = "mailtime")
    public String getMailtime() {
        return mailtime;
    }

    public void setMailtime(String mailtime) {
        this.mailtime = mailtime;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "createtime")
    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userid != user.userid) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (identifyid != null ? !identifyid.equals(user.identifyid) : user.identifyid != null) return false;
        if (qq != null ? !qq.equals(user.qq) : user.qq != null) return false;
        if (wechat != null ? !wechat.equals(user.wechat) : user.wechat != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (tel != null ? !tel.equals(user.tel) : user.tel != null) return false;
        if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (homepage != null ? !homepage.equals(user.homepage) : user.homepage != null) return false;
        if (identifytime != null ? !identifytime.equals(user.identifytime) : user.identifytime != null) return false;
        if (teltime != null ? !teltime.equals(user.teltime) : user.teltime != null) return false;
        if (mailtime != null ? !mailtime.equals(user.mailtime) : user.mailtime != null) return false;
        if (status != null ? !status.equals(user.status) : user.status != null) return false;
        if (createtime != null ? !createtime.equals(user.createtime) : user.createtime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (identifyid != null ? identifyid.hashCode() : 0);
        result = 31 * result + (qq != null ? qq.hashCode() : 0);
        result = 31 * result + (wechat != null ? wechat.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (homepage != null ? homepage.hashCode() : 0);
        result = 31 * result + (identifytime != null ? identifytime.hashCode() : 0);
        result = 31 * result + (teltime != null ? teltime.hashCode() : 0);
        result = 31 * result + (mailtime != null ? mailtime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        return result;
    }
}
