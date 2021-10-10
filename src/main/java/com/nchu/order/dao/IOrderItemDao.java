package com.nchu.order.dao;

import com.nchu.order.entity.OrderItem;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface IOrderItemDao {
    //增

    /**
     *
     * @param orderitem
     * @return
     */
    @Insert("insert into orderitem values (null," +
            "#{order_id}," +
            "#{dishes_id}," +
            "#{orderitem_number}," +
            "#{orderitem_money});")
    int addOrderItem(OrderItem orderitem);

    //删

    /**
     *
     * @param id
     * @return
     */
    @Delete("delete from orderitem where orderitem_id = #{id};")
    int deleteOrderItem(int id);

    //查

    /**
     *
     * @return
     */
    @Select("select * from orderitem where 1=1;")
    List<OrderItem> queryAll();

    //改

    /**
     *
     * @param orderitem
     * @return
     */
    @Update("UPDATE orderitem SET " +
            "order_id = #{order_id}," +
            "dishes_id = #{dishes_id}," +
            "orderitem_number = #{orderitem_number}," +
            "orderitem_money = #{orderitem_money}" +
            "WHERE orderitem_id = #{orderitem_id};")
    int updateOrderItem(OrderItem orderitem);

    //条件查询（kw）

    /**
     *
     * @param kw
     * @return
     */
    @Select("select * from orderitem where 1=1 \n" +
            "and orderitem_id LIKE CONCAT('%',#{kw},'%')\n" +
            "OR order_id LIKE CONCAT('%',#{kw},'%')\n" +
            "OR dishes_id LIKE CONCAT('%',#{kw},'%')\n" +
            "OR orderitem_number LIKE CONCAT('%',#{kw},'%')\n" +
            "OR orderitem_money LIKE CONCAT('%',#{kw},'%');")
    List<OrderItem> queryOrderItem(String kw);

    //条件查询（map）

    /**
     *
     * @param map
     * @return
     */
    @Select("select * from orderitem where 1=1 \n" +
            "and orderitem_id LIKE CONCAT('%',#{map_orderitem_id},'%')\n" +
            "and order_id LIKE CONCAT('%',#{map_order_id},'%')\n" +
            "and dishes_id LIKE CONCAT('%',#{map_dishes_id},'%')\n" +
            "and orderitem_number LIKE CONCAT('%',#{map_orderitem_number},'%')\n" +
            "and orderitem_money LIKE CONCAT('%',#{map_orderitem_money},'%');")
    List<OrderItem> queryMapOrderItem(Map map);

    //主键查询（id）

    /**
     *
     * @param id
     * @return
     */
    @Select("select * from orderitem where orderitem_id = #{id};")
    OrderItem queryIdOrderItem(int id);

    //分页查询（kw，start，size）

    /**
     *
     * @param kw
     * @param start
     * @param size
     * @return
     */
    @Select("select * from orderitem where 1=1 \n" +
            "and orderitem_id LIKE CONCAT('%',#{kw},'%')\n" +
            "OR order_id LIKE CONCAT('%',#{kw},'%')\n" +
            "OR dishes_id LIKE CONCAT('%',#{kw},'%')\n" +
            "OR orderitem_number LIKE CONCAT('%',#{kw},'%')\n" +
            "OR orderitem_money LIKE CONCAT('%',#{kw},'%')" +
            "LIMIT #{start},#{size};")
    List<OrderItem> queryPageOrderItem(@Param("kw")String kw, @Param ("start") int start, @Param ("size") int size);

    //统计查询（count）

    /**
     *
     * @return
     */
    @Select("select count(orderitem_id) from orderitem where 1=1;")
    int queryOrderItemNum();

    //查询order表

    /**
     *
     * @param order_id
     * @return
     */
    @Select("select * from orderitem where order_id = #{order_id}")
    List<OrderItem> queryOrder(int order_id);
}
