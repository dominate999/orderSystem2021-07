package com.nchu.order.service;

import com.nchu.order.entity.Dishes;
import com.nchu.order.entity.EvaInfo;
import com.nchu.order.entity.EvaInfoVO;

import java.util.List;

/**
 * 评价信息服务层
 */
public interface IEvaInfoService {

    /**
     * 新增评价信息
     *
     * @param evaInfo
     * @return
     * @throws Exception
     */
    boolean save(EvaInfo evaInfo) throws Exception;

    /**
     * 通过id删除评价信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteById(int id) throws Exception;

    /**
     * 修改评价信息
     *
     * @param evaInfo
     * @return
     * @throws Exception
     */
    boolean update(EvaInfo evaInfo) throws Exception;

    /**
     * 查询所有的信息
     *
     * @return
     * @throws Exception
     */
    List<EvaInfo> queryAllEva() throws Exception;

    /**
     * 通过eva_id查询对应的评价
     *
     * @param eva_id
     * @return
     * @throws Exception
     */
    EvaInfo findEvaById(int eva_id) throws Exception;

    /**
     * 通过关键字查询订单
     *
     * @param kw
     * @return
     * @throws Exception
     */
    List<EvaInfo> queryEvaByKeyWord(String kw) throws Exception;

    /**
     * 查询订单视图里的所有信息
     *
     * @return
     * @throws Exception
     */
    List<EvaInfoVO> queryEva() throws Exception;

    /**
     * 通过用户查询对应的所有订单
     *
     * @param user_id
     * @return
     * @throws Exception
     */
    List<EvaInfo> findEvaByUserId(int user_id) throws Exception;
}
