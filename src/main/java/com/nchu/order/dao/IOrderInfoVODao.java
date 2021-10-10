package com.nchu.order.dao;

import com.nchu.order.entity.OrderInfoVO;
import com.nchu.order.entity.OrderItemVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IOrderInfoVODao {
    //查

    /**
     *
     *
     * @return
     */
    @Select("select * from `v_orderinfo-userinfo`")
    List<OrderInfoVO> queryOrderInfoVO();

    //关键字查询

    /**
     *
     * @param kw
     * @return
     */
    @Select("select * from `v_orderinfo-userinfo` where 1=1\n" +
            "and order_name LIKE CONCAT('%',#{kw},'%')\n" +
            "or order_time LIKE CONCAT('%',#{kw},'%')\n" +
            "or order_status LIKE CONCAT('%',#{kw},'%')\n" +
            "or order_number LIKE CONCAT('%',#{kw},'%')\n" +
            "or order_money LIKE CONCAT('%',#{kw},'%')\n" +
            "or user_name LIKE CONCAT('%',#{kw},'%')\n" +
            "or user_phone LIKE CONCAT('%',#{kw},'%')\n" +
            "or user_addressed LIKE CONCAT('%',#{kw},'%')")
    List<OrderInfoVO> queryKWOrderInfoVO(String kw);

    //分页查询

    /**
     *
     * @param kw
     * @param start
     * @param size
     * @return
     */
    @Select("select * from `v_orderinfo-userinfo` where 1=1\n" +
            "and order_name LIKE CONCAT('%',#{kw},'%')\n" +
            "or order_time LIKE CONCAT('%',#{kw},'%')\n" +
            "or order_status LIKE CONCAT('%',#{kw},'%')\n" +
            "or order_number LIKE CONCAT('%',#{kw},'%')\n" +
            "or order_money LIKE CONCAT('%',#{kw},'%')\n" +
            "or user_name LIKE CONCAT('%',#{kw},'%')\n" +
            "or user_addressed LIKE CONCAT('%',#{kw},'%')\n" +
            "or user_phone LIKE CONCAT('%',#{kw},'%')\n" +
            "LIMIT #{start},#{size};")
    List<OrderInfoVO> queryPageOrderInfoVO(@Param("kw") String kw,@Param("start") int start,@Param("size") int size);

    //order_id查询

    /**
     *
     * @param order_id
     * @return
     */
    @Select("select * from `v_orderinfo-userinfo` where order_id=#{order_id}")
    OrderInfoVO queryOrderIdOrderInfoVO(int order_id);

    //user_id查询

    /**
     *
     * @param user_id
     * @return
     */
    @Select("select * from `v_orderinfo-userinfo` where user_id=#{user_id}")
    List<OrderInfoVO> queryUserIdOrderInfoVO(int user_id);



}
