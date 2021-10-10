package com.nchu.order.dao;

import com.nchu.order.entity.EvaInfoVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IEvaInfoVODao {
    //查询评论

    /**
     *
     * @return
     */
    @Select("select * from `v_evainfo-userinfo`")
    List<EvaInfoVO> queryEvaInfoVO();

    //按评分查看评论

    /**
     *
     * @param degree
     * @return
     */
    @Select("select * from `v_evainfo-userinfo` where eva_degree like concat('#{degree}','%')")
    List<EvaInfoVO> queryIntegralEvaInfoVO(String degree);

    //分页查询

    /**
     *
     * @param degree
     * @param start
     * @param size
     * @return
     */
    @Select("select * from `v_evainfo-userinfo` where eva_degree like concat('#{degree}','%') limit #{start},#{size};")
    List<EvaInfoVO> queryPageEvaInfoVO(@Param("degree") String degree,
                                       @Param("start") int start ,
                                       @Param("size") int size);

}
