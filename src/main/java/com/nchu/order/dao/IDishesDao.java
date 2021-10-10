package com.nchu.order.dao;

import com.nchu.order.entity.Dishes;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


public interface IDishesDao {
    //增
    /**
     *
     * @param dishes
     * @return
     */
    @Insert("insert into dishesinfo values (null," +
            "#{dishes_name}," +
            "#{dishes_des}," +
            "0," +
            "#{dishes_cate}," +
            "#{dishes_price}," +
            "0," +
            "#{dishes_photo});")
    int addDishes(Dishes dishes);

    //删
    /**
     *
     * @param id
     * @return
     */
    @Delete("delete from dishesinfo where DISHES_ID = #{id};")
    int deleteDishes(int id);

    //查
    /**
     *
     * @return
     */
    @Select(" select * from dishesinfo")
    List<Dishes> queryAll();

    //改
    /**
     *
     * @param dishes
     * @return
     */
    @Update({"<script> ",
            "update dishesinfo set ",
            "<if test = \"dishes_name != null\">",
            "dishes_name=#{dishes_name},",
            "</if>",
            "<if test = \"dishes_des != null\">",
            "dishes_des=#{dishes_des},",
            "</if>",
            "<if test = \"dishes_number != null\">",
            "dishes_number=#{dishes_number},",
            "</if>",
            "<if test = \"dishes_cate != null\">",
            "dishes_cate=#{dishes_cate},",
            "</if> ",
            "<if test = \"dishes_price != null\">",
            "dishes_price=#{dishes_price},",
            "</if>",
            "<if test = \"dishes_sales != null\">",
            "dishes_sales=#{dishes_sales},",
            "</if>",
            "<if test = \"dishes_photo != null\">",
            "dishes_photo=#{dishes_photo},",
            "</if>",
            "DISHES_ID = #{dishes_id} ",
            "WHERE DISHES_ID = #{dishes_id};",
            "</script>"
    })
    int updateDishes(Dishes dishes);


    //条件查询（kw）
    /**
     *
     * @param kw
     * @return
     */
    @Select("select * from dishesinfo where 1=1 \n" +
            "and DISHES_ID LIKE CONCAT('%',#{kw},'%')\n" +
            "OR DISHES_NAME LIKE CONCAT('%',#{kw},'%')\n" +
            "OR DISHES_DES LIKE CONCAT('%',#{kw},'%')\n" +
            "OR DISHES_NUMBER LIKE CONCAT('%',#{kw},'%')\n" +
            "OR DISHES_CATE LIKE CONCAT('%',#{kw},'%')\n" +
            "OR DISHES_PRICE LIKE CONCAT('%',#{kw},'%')\n" +
            "OR DISHES_SALES LIKE CONCAT('%',#{kw},'%') ")
    List<Dishes> queryDishes(@Param("kw")String kw);

    //条件查询（map）
    /**
     *
     * @param map
     * @return
     */
    @Select("select * from dishesinfo where 1=1 \n" +
            "and DISHES_NUMBER LIKE CONCAT('%',#{mdishes_number},'%')\n" +
            "and DISHES_CATE LIKE CONCAT('%',#{mdishes_cate},'%')\n" +
            "and DISHES_PRICE LIKE CONCAT('%',#{mdishes_price},'%')\n" +
            "and DISHES_SALES LIKE CONCAT('%',#{mdishes_sales},'%');")
    List<Dishes> queryMapDishes(Map<String,String> map);

    //主键查询（id）
    /**
     *
     * @param id
     * @return
     */
    @Select("select * from dishesinfo where DISHES_ID = #{id}")
    Dishes queryIdDishes(int id);

    //分页查询（kw，start，size）
    /**
     *
     * @param kw
     * @param start
     * @param size
     * @return
     */
    @Select("select * from dishesinfo where 1=1 \n" +
            "and DISHES_ID LIKE CONCAT('%',#{kw},'%')\n" +
            "OR DISHES_NAME LIKE CONCAT('%',#{kw},'%')\n" +
            "OR DISHES_DES LIKE CONCAT('%',#{kw},'%')\n" +
            "OR DISHES_NUMBER LIKE CONCAT('%',#{kw},'%')\n" +
            "OR DISHES_CATE LIKE CONCAT('%',#{kw},'%')\n" +
            "OR DISHES_PRICE LIKE CONCAT('%',#{kw},'%')\n" +
            "OR DISHES_SALES LIKE CONCAT('%',#{kw},'%')\n" +
            "LIMIT #{start},#{size};")
    List<Dishes> queryPageDishes(@Param ("kw") String kw,
                                 @Param ("start") int start,
                                 @Param ("size") int size);


    //统计查询（count）
    /**
     *
     * @return
     */
    @Select("select count(DISHES_ID) from dishesinfo where 1=1;")
    int queryDishesNum();



    //类型查询

    /**
     *
     * @param cate
     * @param kw
     * @return
     */
    @Select("select * from dishesinfo where DISHES_CATE LIKE CONCAT('%',#{cate},'%') \n" +
            "            and (DISHES_ID LIKE CONCAT('%',#{kw},'%')\n" +
            "            OR DISHES_NAME LIKE CONCAT('%',#{kw},'%')\n" +
            "            OR DISHES_DES LIKE CONCAT('%',#{kw},'%')\n" +
            "            OR DISHES_NUMBER LIKE CONCAT('%',#{kw},'%')\n" +
            "            OR DISHES_PRICE LIKE CONCAT('%',#{kw},'%')\n" +
            "            OR DISHES_SALES LIKE CONCAT('%',#{kw},'%'))")
    List<Dishes> queryCateDishes(@Param("cate") String cate,@Param("kw") String kw);

}
