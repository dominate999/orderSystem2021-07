package com.nchu.order.service;

import com.nchu.order.entity.Cart;
import com.nchu.order.entity.Dishes;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 购物车管理服务层
 */
public interface ICartInfoService {

    /**
     * 获取购物车中商品总数量
     *
     * @return
     */
    int getTotalCount() throws Exception;

    /**
     * 增加一个食物
     *
     * @param dishes
     */
    void addItem(Dishes dishes) throws Exception;

    /**
     * 清空购物车
     */
    void clear() throws Exception;

    /**
     * 删除购物车中的商品
     *
     * @param id 要删除的商品编号
     */
    void deleteItem(int id) throws Exception;

    /**
     * 修改购物车
     *
     * @param id    要修改的商品编号
     * @param count 修改的商品数量
     */
    void updateItem(int id, int count) throws Exception;

    /**
     * 获取所有商品
     *
     * @return
     */
    Map<Integer, Cart> getItems() throws Exception;

    /**
     * 获取购物车里的信息
     *
     * @param cartItems
     * @throws Exception
     */
    void setItems(Map<Integer, Cart> cartItems) throws Exception;

    /**
     * 获取购物车中总的商品金额
     *
     * @return
     */
    BigDecimal getTotalMoney() throws Exception;
}
