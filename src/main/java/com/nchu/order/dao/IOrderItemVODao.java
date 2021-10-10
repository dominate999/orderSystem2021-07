package com.nchu.order.dao;

import com.nchu.order.entity.OrderItemVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IOrderItemVODao {
    //查询

    /**
     *
     * @param order_id
     * @return
     */
    @Select("select * from `v_orderitem-dishesinfo` where order_id = #{order_id}")
    List<OrderItemVO> queryIDOrderItemVO(int order_id);


    //查询

    /**
     *
     * @return
     */
    @Select("select * from `v_orderitem-dishesinfo` where 1 = 1")
    List<OrderItemVO> queryAllOrderItemVO();
}
