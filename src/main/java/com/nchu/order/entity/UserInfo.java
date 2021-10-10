package com.nchu.order.entity;

/**
 * 用户信息实体类
 */
public class UserInfo {

    /*用户编号*/
    private int user_id;//
    /*用户账号*/
    private String user_account;
    /*用户密码*/
    private String user_password;
    /*用户昵称*/
    private String user_name;
    /*用户地址*/
    private String user_addressed;
    /*电话号码*/
    private String user_phone;
    /*用户头像*/
    private String user_photo;
    /*用户积分*/
    private String user_integral;

    public UserInfo() {

    }

    public UserInfo(int user_id, String user_account, String user_password, String user_name, String user_addressed,
                    String user_phone, String user_photo, String user_integral) {
        this.user_id = user_id;
        this.user_account = user_account;
        this.user_password = user_password;
        this.user_name = user_name;
        this.user_addressed = user_addressed;
        this.user_phone = user_phone;
        this.user_photo = user_photo;
        this.user_integral = user_integral;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_addressed() {
        return user_addressed;
    }

    public void setUser_addressed(String user_addressed) {
        this.user_addressed = user_addressed;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    public String getUser_integral() {
        return user_integral;
    }

    public void setUser_integral(String user_integral) {
        this.user_integral = user_integral;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "user_id=" + user_id +
                ", user_account='" + user_account + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_addressed='" + user_addressed + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_photo='" + user_photo + '\'' +
                ", user_integral='" + user_integral + '\'' +
                '}';
    }
}
