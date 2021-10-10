package com.nchu.order.entity;

/**
 * 评价实体类
 */
public class EvaInfo {

    /*评价编号*/
    private int eva_id;
    /*评论内容*/
    private String eva_content;
    /*用户编号*/
    private int user_id;
    /*评价时间*/
    private String eva_time;
    /*好评度*/
    private String eva_degree;
    /*订单编号*/
    private int order_id;

    public EvaInfo() {

    }

    public EvaInfo(int eva_id, String eva_content, int user_id, String eva_time, String eva_degree, int order_id) {
        this.eva_id = eva_id;
        this.eva_content = eva_content;
        this.user_id = user_id;
        this.eva_time = eva_time;
        this.eva_degree = eva_degree;
        this.order_id = order_id;
    }

    public int getEva_id() {
        return eva_id;
    }

    public void setEva_id(int eva_id) {
        this.eva_id = eva_id;
    }

    public String getEva_content() {
        return eva_content;
    }

    public void setEva_content(String eva_content) {
        this.eva_content = eva_content;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
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

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    @Override
    public String toString() {
        return "EvaInfo{" +
                "eva_id=" + eva_id +
                ", eva_content='" + eva_content + '\'' +
                ", user_id=" + user_id +
                ", eva_time='" + eva_time + '\'' +
                ", eva_degree='" + eva_degree + '\'' +
                ", order_id=" + order_id +
                '}';
    }
}
