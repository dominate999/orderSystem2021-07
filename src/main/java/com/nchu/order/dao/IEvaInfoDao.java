package com.nchu.order.dao;

import com.nchu.order.entity.EvaInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface IEvaInfoDao {
    //增

    /**
     *
     * @param evainfo
     * @return
     */
    @Insert("insert into evainfo values (null," +
            "#{eva_content}," +
            "#{user_id}," +
            "#{eva_time}," +
            "#{eva_degree}," +
            "#{order_id});")
    int addEvaInfo(EvaInfo evainfo);
    //删

    /**
     *
     * @param id
     * @return
     */
    @Delete("delete from evainfo where EVA_ID = #{id};")
    int deleteEvaInfo(int id);
    //查

    /**
     *
     * @return
     */
    @Select("select * from evainfo where 1=1;")
    List<EvaInfo> queryAll();
    //改

    /**
     *
     * @param evainfo
     * @return
     */
    @Update("UPDATE evainfo SET " +
            "EVA_CONTENT = #{eva_content}," +
            "EVA_DEGREE = #{eva_degree}" +
            "WHERE EVA_ID = #{eva_id};")
    int updateEvaInfo(EvaInfo evainfo);
    //条件查询（kw）

    /**
     *
     * @param kw
     * @return
     */
    @Select("select * from evainfo where 1=1 \n" +
            "and EVA_ID LIKE CONCAT('%',#{kw},'%')\n" +
            "OR EVA_CONTENT LIKE CONCAT('%',#{kw},'%')\n" +
            "OR USER_ID LIKE CONCAT('%',#{kw},'%')\n" +
            "OR EVA_TIME LIKE CONCAT('%',#{kw},'%')\n" +
            "OR EVA_DEGREE LIKE CONCAT('%',#{kw},'%');")
    List<EvaInfo> queryEvaInfo(String kw);
    //条件查询（map）

    /**
     *
     * @param map
     * @return
     */
    @Select("select * from evainfo where 1=1 \n" +
            "and EVA_ID LIKE CONCAT('%',#{map_eva_id},'%')\n" +
            "and EVA_CONTENT LIKE CONCAT('%',#{map_eva_content},'%')\n" +
            "and USER_ID LIKE CONCAT('%',#{map_user_id},'%')\n" +
            "and EVA_TIME LIKE CONCAT('%',#{map_eva_time},'%')\n" +
            "and EVA_DEGREE LIKE CONCAT('%',#{map_eva_degree},'%');")
    List<EvaInfo> queryMapEvaInfo(Map map);

    //主键查询（id）

    /**
     *
     * @param id
     * @return
     */
    @Select("select * from evainfo where EVA_ID = #{id}")
    EvaInfo queryIdEvaInfo(int id);

    //分页查询（kw，start，size）

    /**
     *
     * @param kw
     * @param start
     * @param size
     * @return
     */
    @Select("select * from evainfo where 1=1 \n" +
            "and EVA_ID LIKE CONCAT('%',#{kw},'%')\n" +
            "OR EVA_CONTENT LIKE CONCAT('%',#{kw},'%')\n" +
            "OR USER_ID LIKE CONCAT('%',#{kw},'%')\n" +
            "OR EVA_TIME LIKE CONCAT('%',#{kw},'%')\n" +
            "OR EVA_DEGREE LIKE CONCAT('%',#{kw},'%')\n" +
            "LIMIT #{start},#{size};")
    List<EvaInfo> queryPageEvaInfo(@Param("kw")String kw,
                                   @Param ("start") int start,
                                   @Param ("size") int size);
    //统计查询（count）

    /**
     *
     * @return
     */
    @Select("select count(EVA_ID) from evainfo where 1=1;")
    int queryEvaInfoNum();

    //查询用户评论

    /**
     *
     * @param user_id
     * @return
     */
    @Select("select * from evainfo where user_id = #{user_id}")
    List<EvaInfo> queryUserEvaInfo(int user_id);

    /**
     *
     * @param order_id
     * @return
     */
    @Select("select * from evainfo where order_id = #{order_id}")
    List<EvaInfo> queryOrderEvaInfo(int order_id);
}
