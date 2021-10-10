package com.nchu.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.nchu.order.dao.IDishesDao;
import com.nchu.order.entity.Dishes;
import com.nchu.order.service.IDishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 食物管理服务层实现类
 */
@Service("dishesService")
public class DishesServiceImpl implements IDishesService {

    @Autowired
    private IDishesDao iDishesDao;

    /**
     * 新增食物
     *
     * @param dishes
     * @return
     * @throws Exception
     */
    @Override
    public boolean save(Dishes dishes) throws Exception {
        int ifok = iDishesDao.addDishes(dishes);
        if (ifok > 0) {

            return true;
        } else
            return false;
    }


    /**
     * 通过id删除食物
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteById(int id) throws Exception {
        int ifok = iDishesDao.deleteDishes(id);
        if (ifok > 0) {

            return true;
        } else
            return false;
    }


    /**
     * 更新食物信息
     *
     * @param dishes
     * @return
     * @throws Exception
     */
    @Override
    public boolean update(Dishes dishes) throws Exception {

        int ifok = iDishesDao.updateDishes(dishes);
        if (ifok > 0) {

            return true;
        } else
            return false;
    }

    /**
     * 分页查询食物信息
     *
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @Override
    public List<Dishes> queryAllDishes(int pageNum, int pageSize) throws Exception {
        //参数pageNum是页码数值，pageSize是查询每页的参数，必须写在调用分页的代码的前面
        PageHelper.startPage(pageNum, pageSize);
        return iDishesDao.queryAll();
    }


    /**
     * 通过id查询食物信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Dishes findDishById(int id) throws Exception {
        return iDishesDao.queryIdDishes(id);
    }

    /**
     * 关键字分页查询食物信息
     *
     * @param pageNum
     * @param pageSize
     * @param kw
     * @return
     * @throws Exception
     */
    @Override
    public List<Dishes> findDishByKeyWord(int pageNum, int pageSize, String kw) throws Exception {
        //参数pageNum是页码数值，pageSize是查询每页的参数，必须写在调用分页的代码的前面
        PageHelper.startPage(pageNum, pageSize);
        return iDishesDao.queryDishes(kw);
    }

    /**
     * 关键字查询对应类型的食物信息
     *
     * @param kw
     * @return
     * @throws Exception
     */
    @Override
    public List<Dishes> findDishCateByKeyWord(String kw) throws Exception {
        List<Dishes> tempDishes = new ArrayList();
        List<Dishes> headDishes = new ArrayList();


        tempDishes = iDishesDao.queryDishes(kw);
        Collections.shuffle(tempDishes);
        headDishes.add(tempDishes.get(0));
        headDishes.add(tempDishes.get(1));
        headDishes.add(tempDishes.get(2));
        return headDishes;
    }

    /**
     * 通过类型和当前食物的信心推荐出同类食物
     *
     * @param kw
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public List<Dishes> findRecommend(String kw, int id) throws Exception {
        List<Dishes> tempDishes = new ArrayList();
        List<Dishes> headDishes = new ArrayList();
        tempDishes = iDishesDao.queryDishes(kw);
        for (int i = 0; i < tempDishes.size(); i++) {
            if (tempDishes.get(i).getDishes_id() == id) {
                tempDishes.remove(i);
            }
        }
        Collections.shuffle(tempDishes);
        headDishes.add(tempDishes.get(0));
        headDishes.add(tempDishes.get(1));
        headDishes.add(tempDishes.get(2));
        return headDishes;
    }

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
    @Override
    public List<Dishes> findDishOrderBy(int pageNum, int pageSize, String kw, String word) throws Exception {
        String orderBy = "";
        if (word.equals("价格降")) {
            orderBy = "dishes_price" + " desc";//按照（数据库）排序字段 倒序 排序

        }
        if (word.equals("价格升")) {
            orderBy = "dishes_price" + " asc";//按照（数据库）排序字段 倒序 排序

        }
        if (word.equals("销量升")) {
            orderBy = "dishes_sales" + " asc";//按照（数据库）排序字段 倒序 排序

        }
        if (word.equals("销量降")) {
            orderBy = "dishes_sales" + " desc";//按照（数据库）排序字段 倒序 排序

        }
        PageHelper.startPage(pageNum, pageSize, orderBy);
        return iDishesDao.queryDishes(kw);
    }

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
    @Override
    public List<Dishes> findDishOrderBy(int pageNum, int pageSize, String kw, String word, String cate) throws Exception {
        String orderBy = "";

        if (word.equals("价格降")) {
            orderBy = "dishes_price + 0" + " desc";//按照（数据库）排序字段 倒序 排序
        }
        if (word.equals("价格升")) {
            orderBy = "dishes_price + 0" + " asc";//按照（数据库）排序字段 倒序 排序

        }
        if (word.equals("销量升")) {
            orderBy = "dishes_sales + 0" + " asc";//按照（数据库）排序字段 倒序 排序

        }
        if (word.equals("销量降")) {
            orderBy = "dishes_sales + 0" + " desc";//按照（数据库）排序字段 倒序 排序
        }

        PageHelper.startPage(pageNum, pageSize, orderBy);
        return iDishesDao.queryCateDishes(cate, kw);
    }
}
