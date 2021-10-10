package com.nchu.order.service;

import com.nchu.order.entity.Dishes;

import java.util.List;

/**
 * 食物管理服务层
 */
public interface IDishesService {


    /**
     * 新增食物
     *
     * @param dishes
     * @return
     * @throws Exception
     */
    boolean save(Dishes dishes) throws Exception;

    /**
     * 通过id删除食物
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteById(int id) throws Exception;

    /**
     * 更新食物信息
     *
     * @param dishes
     * @return
     * @throws Exception
     */
    boolean update(Dishes dishes) throws Exception;

    /**
     * 分页查询食物信息
     *
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    List<Dishes> queryAllDishes(int pageNum, int pageSize) throws Exception;

    /**
     * 通过id查询食物信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    Dishes findDishById(int id) throws Exception;

    /**
     * 关键字分页查询食物信息
     *
     * @param pageNum
     * @param pageSize
     * @param kw
     * @return
     * @throws Exception
     */
    List<Dishes> findDishByKeyWord(int pageNum, int pageSize, String kw) throws Exception;

    /**
     * 关键字查询对应类型的食物信息
     *
     * @param kw
     * @return
     * @throws Exception
     */
    List<Dishes> findDishCateByKeyWord(String kw) throws Exception;

    /**
     * 通过类型和当前食物的信心推荐出同类食物
     *
     * @param kw
     * @param id
     * @return
     * @throws Exception
     */
    List<Dishes> findRecommend(String kw, int id) throws Exception;

    /**
     * 搜索关键字和排序以及排序
     * 对食物信息进行处理
     *
     * @param pageNum
     * @param pageSize
     * @param kw
     * @param word
     * @return
     * @throws Exception
     */
    List<Dishes> findDishOrderBy(int pageNum, int pageSize, String kw, String word) throws Exception;

    /**
     * 搜索关键字和排序以及排序、食物类别
     * 对食物信息进行处理
     *
     * @param pageNum
     * @param pageSize
     * @param kw
     * @param word
     * @param cate
     * @return
     * @throws Exception
     */
    List<Dishes> findDishOrderBy(int pageNum, int pageSize, String kw, String word, String cate) throws Exception;

}
