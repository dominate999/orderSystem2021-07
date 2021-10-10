package com.nchu.order.entity;

/**
 * 购物车实体类
 */
public class Cart {

    /* 编号*/
    private Integer id;
    /* 名称*/
    private String name;
    /* 单价*/
    private String price;
    /* 总金额*/
    private String totalMoney;
    /* 数量*/
    private String count;
    /* 图片*/
    private String photo;


    public Cart(Integer id, String name, String price, String totalMoney, String count, String photo) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.totalMoney = totalMoney;
        this.count = count;
        this.photo = photo;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", totalMoney='" + totalMoney + '\'' +
                ", count='" + count + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
