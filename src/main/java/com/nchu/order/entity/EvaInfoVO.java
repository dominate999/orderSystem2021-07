package com.nchu.order.entity;

/**
 * 评价信息视图实体类
 * 用户的信息和其评价的信息
 */
public class EvaInfoVO {
    /*评价编号*/
    private Integer eva_id;
    /*评价内容*/
    private String eva_content;
    /*用户id*/
    private Integer user_id;
    /*评价时间*/
    private String eva_time;
    /*评价等级*/
    private String eva_degree;
    /*用户昵称*/
    private String user_account;
    /*用户名字*/
    private String user_name;
    /*用户地址*/
    private String user_addressed;
    /*用户联系方式*/
    private String user_phone;
    /*用户头像*/
    private String user_photo;

    public EvaInfoVO() {
    }

    public EvaInfoVO(Integer eva_id, String eva_content, Integer user_id, String eva_time, String eva_degree, String user_account, String user_name, String user_addressed, String user_phone, String user_photo) {
        this.eva_id = eva_id;
        this.eva_content = eva_content;
        this.user_id = user_id;
        this.eva_time = eva_time;
        this.eva_degree = eva_degree;
        this.user_account = user_account;
        this.user_name = user_name;
        this.user_addressed = user_addressed;
        this.user_phone = user_phone;
        this.user_photo = user_photo;
    }

    public Integer getEva_id() {
        return eva_id;
    }

    public void setEva_id(Integer eva_id) {
        this.eva_id = eva_id;
    }

    public String getEva_content() {
        return eva_content;
    }

    public void setEva_content(String eva_content) {
        this.eva_content = eva_content;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getEva_time() {
        return eva_time;
    }

    public void setEva_time(String eva_time) {
        this.eva_time = eva_time;
    }

    public String getEva_degree() {
        return eva_degree;
    }

    public void setEva_degree(String eva_degree) {
        this.eva_degree = eva_degree;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
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

    @Override
    public String toString() {
        return "EvaInfoVO{" +
                "eva_id=" + eva_id +
                ", eva_content='" + eva_content + '\'' +
                ", user_id=" + user_id +
                ", eva_time='" + eva_time + '\'' +
                ", eva_degree='" + eva_degree + '\'' +
                ", user_account='" + user_account + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_addressed='" + user_addressed + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_photo='" + user_photo + '\'' +
                '}';
    }
}
