package com.nchu.order.entity;


/**
 * 食物实体类
 */
public class Dishes {
    /*食物id*/
    private Integer dishes_id;
    /*食物名称*/
    private String dishes_name;
    /*描述*/
    private String dishes_des;
    /*库存信息*/
    private String dishes_number;
    /*菜品类别*/
    private String dishes_cate;
    /*价格*/
    private String dishes_price;
    /*销量*/
    private String dishes_sales;
    /*食物图片*/
    private String dishes_photo;

    public Dishes() {

    }
    public Dishes(Integer dishes_id, String dishes_name, String dishes_des, String dishes_number, String dishes_cate,
                  String dishes_price, String dishes_sales, String dishes_photo) {
        super();
        this.dishes_id = dishes_id;
        this.dishes_name = dishes_name;
        this.dishes_des = dishes_des;
        this.dishes_number = dishes_number;
        this.dishes_cate = dishes_cate;
        this.dishes_price = dishes_price;
        this.dishes_sales = dishes_sales;
        this.dishes_photo = dishes_photo;
    }

    public String getDishes_photo() {
        return dishes_photo;
    }

    public void setDishes_photo(String dishes_photo) {
        this.dishes_photo = dishes_photo;
    }

    public String getDishes_sales() {
        return dishes_sales;
    }

    public void setDishes_sales(String dishes_sales) {
        this.dishes_sales = dishes_sales;
    }

    public String getDishes_price() {
        return dishes_price;
    }

    public void setDishes_price(String dishes_price) {
        this.dishes_price = dishes_price;
    }

    public String getDishes_cate() {
        return dishes_cate;
    }

    public void setDishes_cate(String dishes_cate) {
        this.dishes_cate = dishes_cate;
    }

    public String getDishes_number() {
        return dishes_number;
    }

    public void setDishes_number(String dishes_number) {
        this.dishes_number = dishes_number;
    }

    public String getDishes_des() {
        return dishes_des;
    }

    public void setDishes_des(String dishes_des) {
        this.dishes_des = dishes_des;
    }

    public String getDishes_name() {
        return dishes_name;
    }

    public void setDishes_name(String dishes_name) {
        this.dishes_name = dishes_name;
    }

    public Integer getDishes_id() {
        return dishes_id;
    }

    public void setDishes_id(Integer dishes_id) {
        this.dishes_id = dishes_id;
    }

    @Override
    public String toString() {
        return "Dishes{" +
                "dishes_id=" + dishes_id +
                ", dishes_name='" + dishes_name + '\'' +
                ", dishes_des='" + dishes_des + '\'' +
                ", dishes_number='" + dishes_number + '\'' +
                ", dishes_cate='" + dishes_cate + '\'' +
                ", dishes_price='" + dishes_price + '\'' +
                ", dishes_sales='" + dishes_sales + '\'' +
                ", dishes_photo='" + dishes_photo + '\'' +
                '}';
    }
}

