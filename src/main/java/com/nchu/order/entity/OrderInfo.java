package com.nchu.order.entity;

/**
 * 订单信息实体类
 */
public class OrderInfo {
    /*订单编号*/
    private int order_id;
    /*订单名称*/
    private String order_name;
    /*订单结算时间*/
    private String order_time;
    /*状态(未接单，已配送，未配送，已完成）*/
    private String order_status;
    /*用户编号*/
    private int user_id;
    /*订单内食物总数量*/
    private String order_number;
    /*订单总金额*/
    private String order_money;

    public OrderInfo() {

    }

    public OrderInfo(int order_id, String order_name, String order_time, String order_status, int user_id,
                     String order_number, String order_money) {
        this.order_id = order_id;
        this.order_name = order_name;
        this.order_time = order_time;
        this.order_status = order_status;
        this.user_id = user_id;
        this.order_number = order_number;
        this.order_money = order_money;
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

    public String getOrder_money() {
        return order_money;
    }

    public void setOrder_money(String order_money) {
        this.order_money = order_money;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "order_id=" + order_id +
                ", order_name='" + order_name + '\'' +
                ", order_time='" + order_time + '\'' +
                ", order_status='" + order_status + '\'' +
                ", user_id=" + user_id +
                ", order_number='" + order_number + '\'' +
                ", order_money='" + order_money + '\'' +
                '}';
    }

}
