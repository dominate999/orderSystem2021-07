package com.nchu.order.entity;

/**
 * 子订单实体类
 */
public class OrderItem {

    /*单种菜品的编号*/
    private int orderitem_id;
    /*订单号*/
    private int order_id;
    /*菜品号*/
    private int dishes_id;
    /*单菜品数量*/
    private String orderitem_number;
    /*单菜品对应金额*/
    private String orderitem_money;

    public OrderItem() {

    }

    public OrderItem(int orderitem_id, int order_id, int dishes_id, String orderitem_number, String orderitem_money) {
        this.orderitem_id = orderitem_id;
        this.order_id = order_id;
        this.dishes_id = dishes_id;
        this.orderitem_number = orderitem_number;
        this.orderitem_money = orderitem_money;
    }

    public int getOrderitem_id() {
        return orderitem_id;
    }

    public void setOrderitem_id(int orderitem_id) {
        this.orderitem_id = orderitem_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getDishes_id() {
        return dishes_id;
    }

    public void setDishes_id(int dishes_id) {
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

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderitem_id=" + orderitem_id +
                ", order_id=" + order_id +
                ", dishes_id=" + dishes_id +
                ", orderitem_number='" + orderitem_number + '\'' +
                ", orderitem_money='" + orderitem_money + '\'' +
                '}';
    }
}
