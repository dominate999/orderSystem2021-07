package com.nchu.order.dao;

import com.nchu.order.entity.OrderInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
public interface IOrderDao {
    //增

    /**
     *
     * @param orderinfo
     * @return
     */
    @Insert("insert into orderinfo values (null," +
            "#{order_name}," +
            "#{order_time}," +
            "#{order_status}," +
            "#{user_id}," +
            "#{order_number}," +
            "#{order_money});")
    @Options(useGeneratedKeys=true, keyProperty="order_id", keyColumn="order_id")
    int addOrderInfo(OrderInfo orderinfo);
    //删

    /**
     *
     * @param id
     * @return
     */
    @Delete("delete from orderinfo where order_id = #{id};")
    int deleteOrderInfo(int id);

    //查

    /**
     *
     * @return
     */
    @Select("select * from orderinfo where 1=1;")
    List<OrderInfo> queryAll();

    //改

    /**
     *
     * @param orderinfo
     * @return
     */
    @Update("UPDATE orderinfo SET " +
            "order_status = #{order_status}" +
            "WHERE order_id = #{order_id};")
    int updateOrderInfo(OrderInfo orderinfo);

    //条件查询（kw）

    /**
     *
     * @param kw
     * @return
     */
    @Select("select * from orderinfo where 1=1 \n" +
            "and order_id LIKE CONCAT('%',#{kw},'%')\n" +
            "OR order_name LIKE CONCAT('%',#{kw},'%')\n" +
            "OR order_time LIKE CONCAT('%',#{kw},'%')\n" +
            "OR order_status LIKE CONCAT('%',#{kw},'%')\n" +
            "OR user_id LIKE CONCAT('%',#{kw},'%')\n" +
            "OR order_number LIKE CONCAT('%',#{kw},'%')\n" +
            "OR order_money LIKE CONCAT('%',#{kw},'%');")
    List<OrderInfo> queryOrderInfo(String kw);

    //条件查询（map）

    /**
     *
     * @param map
     * @return
     */
    @Select("select * from orderinfo where 1=1 \n" +
            "and order_id LIKE CONCAT('%',#{map_order_id},'%')\n" +
            "and order_name LIKE CONCAT('%',#{map_order_name},'%')\n" +
            "and order_time LIKE CONCAT('%',#{map_order_time},'%')\n" +
            "and order_status LIKE CONCAT('%',#{map_order_status},'%')\n" +
            "and user_id LIKE CONCAT('%',#{map_user_id},'%')\n" +
            "and order_number LIKE CONCAT('%',#{map_order_number},'%')\n" +
            "and order_money LIKE CONCAT('%',#{map_order_money},'%');")
    List<OrderInfo> queryMapOrderInfo(Map map);

    //主键查询（id）

    /**
     *
     * @param id
     * @return
     */
    @Select("select * from orderinfo where order_id = #{id};")
    OrderInfo queryIdOrderInfo(int id);

    //分页查询（kw，start，size）

    /**
     *
     * @param kw
     * @param start
     * @param size
     * @return
     */
    @Select("select * from orderinfo where 1=1 \n" +
            "and order_id LIKE CONCAT('%',#{kw},'%')\n" +
            "OR order_name LIKE CONCAT('%',#{kw},'%')\n" +
            "OR order_time LIKE CONCAT('%',#{kw},'%')\n" +
            "OR order_status LIKE CONCAT('%',#{kw},'%')\n" +
            "OR user_id LIKE CONCAT('%',#{kw},'%')\n" +
            "OR order_number LIKE CONCAT('%',#{kw},'%')\n" +
            "OR order_money LIKE CONCAT('%',#{kw},'%')\n" +
            "LIMIT #{start},#{size};")
    List<OrderInfo> queryPageOrderInfo(@Param("kw")String kw,
                                       @Param ("start") int start,
                                       @Param ("size") int size);

    //统计查询（count）

    /**
     *
     * @return
     */
    @Select("select count(order_id) from orderinfo where 1=1;")
    int queryOrderInfoNum();

    //查看订单

    /**
     *
     * @param user_id
     * @return
     */
    @Select("select * from orderinfo where user_id = #{user_id};")
    List<OrderInfo> queryUserOrderInfo(int user_id);
}
