package com.nchu.order.service.impl;

import com.nchu.order.entity.Cart;
import com.nchu.order.entity.Dishes;
import com.nchu.order.service.ICartInfoService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 购物车服务层实现类
 */
@Service("cartInfoService")
public class CartInfoServiceImpl implements ICartInfoService {
    //用来存储每个
    private Map<Integer, Cart> cartItems = new HashMap<Integer, Cart>();

    /**
     * 获取购物车中商品总数量
     *
     * @return
     */
    @Override
    public int getTotalCount() throws Exception {
        int totalCount = 0;
        // 遍历相加每一个商品数量
        for (Map.Entry<Integer, Cart> item : cartItems.entrySet()) {
            Cart cartItem = item.getValue();
            totalCount += Integer.valueOf(cartItem.getCount());
        }
        return totalCount;
    }

    /**
     * 增加一个食物
     *
     * @param dishes
     */
    @Override
    public void addItem(Dishes dishes) throws Exception {
        // 先从购物车中取出商品
        Cart item = cartItems.get(dishes.getDishes_id());
        // 如果为null，说明之前没有此商品
        if (item == null) {
            item = new Cart(dishes.getDishes_id(), dishes.getDishes_name(), dishes.getDishes_price(), dishes.getDishes_price(), "1", dishes.getDishes_photo());
            cartItems.put(dishes.getDishes_id(), item);
        } else {
            // 非空说明原来购物车中有此商品。修改商品数量和总金额
            int conutInt = Integer.valueOf(item.getCount()) + 1;
            item.setCount(String.valueOf(conutInt));
            int totalInt = Integer.valueOf(item.getPrice()) * Integer.valueOf(item.getCount());
            String totalMonry = String.valueOf(totalInt);
            item.setTotalMoney(totalMonry);
        }
    }

    /**
     * 清空购物车
     */
    @Override
    public void clear() throws Exception {
        // 清空购物车
        cartItems.clear();
    }

    /**
     * 删除购物车中的商品
     *
     * @param id 要删除的商品编号
     */
    @Override
    public void deleteItem(int id) throws Exception {
        // 删除商品
        cartItems.remove(id);
    }

    /**
     * 修改购物车
     *
     * @param id    要修改的商品编号
     * @param count 修改的商品数量
     */
    @Override
    public void updateItem(int id, int count) throws Exception {
        // 先从购物车中取出商品
        Cart item = cartItems.get(id);
        // 如果为null，说明之前没有此商品
        if (item != null) {
            // 修改商品数量和总金额

            item.setCount(String.valueOf(count));
            String totalMoney = String.valueOf(Integer.valueOf(item.getPrice()) * Integer.valueOf(item.getCount()));
            item.setTotalMoney(totalMoney);
        }
    }

    /**
     * 获取所有商品
     *
     * @return
     */
    @Override
    public Map<Integer, Cart> getItems() throws Exception {
        return cartItems;
    }

    /**
     * 获取购物车里的信息
     *
     * @param cartItems
     * @throws Exception
     */
    @Override
    public void setItems(Map<Integer, Cart> cartItems) throws Exception {
        this.cartItems = cartItems;
    }

    /**
     * 获取购物车中总的商品金额
     *
     * @return
     */
    @Override
    public BigDecimal getTotalMoney() throws Exception {
        BigDecimal totalMoney = new BigDecimal(0);
        // 遍历商品求商品总金额
        for (Map.Entry<Integer, Cart> item : cartItems.entrySet()) {
            Cart cartItem = item.getValue();
            BigDecimal t = new BigDecimal(cartItem.getTotalMoney() + "");
            totalMoney = totalMoney.add(t);
        }

        return totalMoney;
    }

}
