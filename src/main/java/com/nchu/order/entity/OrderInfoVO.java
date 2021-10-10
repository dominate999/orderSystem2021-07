package com.nchu.order.entity;

/**
 * 订单信息视图类
 * 包含了订单信息和用户信息
 */
public class OrderInfoVO {
    /*订单编号*/
    private int order_id;
    /*订单名称*/
    private String order_name;
    /*订单时间*/
    private String order_time;
    /*订单状态*/
    private String order_status;
    /*用户编号*/
    private int user_id;
    /*订单食物数量*/
    private String order_number;
    /*订单价格*/
    private String order_money;
    /*用户名字*/
    private String user_name;
    /*用户地址*/
    private String user_addressed;
    /*用户电话*/
    private String user_phone;
    /*用户积分*/
    private String user_integral;

    public OrderInfoVO() {
    }

    public OrderInfoVO(int order_id, String order_name, String order_time, String order_status, int user_id, String order_number, String order_money, String user_name, String user_addressed, String user_phone, String user_integral) {
        this.order_id = order_id;
        this.order_name = order_name;
        this.order_time = order_time;
        this.order_status = order_status;
        this.user_id = user_id;
        this.order_number = order_number;
        this.order_money = order_money;
        this.user_name = user_name;
        this.user_addressed = user_addressed;
        this.user_phone = user_phone;
        this.user_integral = user_integral;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
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

    public String getOrder_money() {
        return order_money;
    }

    public void setOrder_money(String order_money) {
        this.order_money = order_money;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_integral() {
        return user_integral;
    }

    public void setUser_integral(String user_integral) {
        this.user_integral = user_integral;
    }

    @Override
    public String toString() {
        return "OrderInfoVO{" +
                "order_id=" + order_id +
                ", order_name='" + order_name + '\'' +
                ", order_time='" + order_time + '\'' +
                ", order_status='" + order_status + '\'' +
                ", user_id=" + user_id +
                ", order_number='" + order_number + '\'' +
                ", order_money='" + order_money + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_addressed='" + user_addressed + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_integral='" + user_integral + '\'' +
                '}';
    }
}
