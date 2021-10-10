package com.nchu.order.entity;

/**
 * 订单详情视图实体类
 * 关联
 * 食物表
 * 订单表
 * 子订单表
 */
public class OrderItemVO {

    /*子订单id*/
    private Integer orderitem_id;
    /*订单id*/
    private Integer order_id;
    /*食物id*/
    private Integer dishes_id;
    /*子订单数量*/
    private String orderitem_number;
    /*子订单的总价格*/
    private String orderitem_money;
    /*食物id*/
    private String dishes_name;
    /*食物描述*/
    private String dishes_des;
    /*食物类型*/
    private String dishes_cate;
    /*食物价格*/
    private String dishes_price;
    /*食物图片*/
    private String dishes_photo;

    public OrderItemVO() {
    }

    public OrderItemVO(Integer orderitem_id, Integer order_name, Integer dishes_id, String orderitem_number, String orderitem_money, String dishes_name, String dishes_des, String dishes_cate, String dishes_price, String dishes_photo) {
        this.orderitem_id = orderitem_id;
        this.order_id = order_name;
        this.dishes_id = dishes_id;
        this.orderitem_number = orderitem_number;
        this.orderitem_money = orderitem_money;
        this.dishes_name = dishes_name;
        this.dishes_des = dishes_des;
        this.dishes_cate = dishes_cate;
        this.dishes_price = dishes_price;
        this.dishes_photo = dishes_photo;
    }

    public Integer getOrderitem_id() {
        return orderitem_id;
    }

    public void setOrderitem_id(Integer orderitem_id) {
        this.orderitem_id = orderitem_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getDishes_id() {
        return dishes_id;
    }

    public void setDishes_id(Integer dishes_id) {
        this.dishes_id = dishes_id;
    }

    public String getOrderitem_number() {
        return orderitem_number;
    }

    public void setOrderitem_number(String orderitem_number) {
        this.orderitem_number = orderitem_number;
    }

    public String getOrderitem_money() {
        return orderitem_money;
    }

    public void setOrderitem_money(String orderitem_money) {
        this.orderitem_money = orderitem_money;
    }

    public String getDishes_name() {
        return dishes_name;
    }

    public void setDishes_name(String dishes_name) {
        this.dishes_name = dishes_name;
    }

    public String getDishes_des() {
        return dishes_des;
    }

    public void setDishes_des(String dishes_des) {
        this.dishes_des = dishes_des;
    }

    public String getDishes_cate() {
        return dishes_cate;
    }

    public void setDishes_cate(String dishes_cate) {
        this.dishes_cate = dishes_cate;
    }

    public String getDishes_price() {
        return dishes_price;
    }

    public void setDishes_price(String dishes_price) {
        this.dishes_price = dishes_price;
    }

    public String getDishes_photo() {
        return dishes_photo;
    }

    public void setDishes_photo(String dishes_photo) {
        this.dishes_photo = dishes_photo;
    }

    @Override
    public String toString() {
        return "OrderItemVO{" +
                "orderitem_id=" + orderitem_id +
                ", order_id=" + order_id +
                ", dishes_id=" + dishes_id +
                ", orderitem_number='" + orderitem_number + '\'' +
                ", orderitem_money='" + orderitem_money + '\'' +
                ", dishes_name='" + dishes_name + '\'' +
                ", dishes_des='" + dishes_des + '\'' +
                ", dishes_cate='" + dishes_cate + '\'' +
                ", dishes_price='" + dishes_price + '\'' +
                ", dishes_photo='" + dishes_photo + '\'' +
                '}';
    }
}
