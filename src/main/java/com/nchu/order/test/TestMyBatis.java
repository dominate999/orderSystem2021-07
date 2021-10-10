package com.nchu.order.test;

import com.nchu.order.dao.IDishesDao;
import com.nchu.order.entity.Dishes;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试mybatis时候配置好
 */
public class TestMyBatis {

    @Test
    public void run1() throws IOException {

        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        SqlSession session = factory.openSession();
        // 获取到代理对象
        IDishesDao dao = session.getMapper(IDishesDao.class);


        // 提交事务
        session.commit();

        // 关闭资源
        session.close();
        in.close();
    }

    @Test
    public void selectTest() throws Exception {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        SqlSession session = factory.openSession();

        IDishesDao dao = session.getMapper(IDishesDao.class);

        //List<Dishes> list = dao.queryDishes("10");

        List<Dishes> list = dao.queryDishes("10");

        for (Dishes dishes1 : list) {
            System.out.println(dishes1.toString());
        }

        session.close();
        in.close();
    }

    @Test
    public void mapSelectTest() throws Exception {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        SqlSession session = factory.openSession();

        IDishesDao dao = session.getMapper(IDishesDao.class);

        //List<Dishes> list = dao.queryDishes("10");

        Map<String, String> map = new HashMap();
        map.put("mdishes_number", "");
        map.put("mdishes_cate", "荤菜");
        map.put("mdishes_price", "");
        map.put("mdishes_sales", "");

        List<Dishes> list = dao.queryMapDishes(map);

        for (Dishes dishes1 : list) {
            System.out.println(dishes1.toString());
        }

        session.close();
        in.close();
    }

    @Test
    public void idSelectTest() throws Exception {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        SqlSession session = factory.openSession();

        IDishesDao dao = session.getMapper(IDishesDao.class);

        Dishes dishes1 = dao.queryIdDishes(10);

        System.out.println(dishes1.toString());

        session.close();
        in.close();
    }

    @Test
    public void pageSelectTest() throws Exception {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        SqlSession session = factory.openSession();

        IDishesDao dao = session.getMapper(IDishesDao.class);

        List<Dishes> list = dao.queryPageDishes("10", 0, 8);

        for (Dishes dishes1 : list) {
            System.out.println(dishes1.toString());
        }

        session.close();
        in.close();
    }

    @Test
    public void countSelectTest() throws Exception {

        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        SqlSession session = factory.openSession();

        IDishesDao dao = session.getMapper(IDishesDao.class);

        int count_dishes = dao.queryDishesNum();

        System.out.println(count_dishes);

        session.close();
        in.close();
    }

    @Test
    public void insertTest() throws Exception {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        SqlSession session = factory.openSession();

        IDishesDao dao = session.getMapper(IDishesDao.class);

        Dishes dishes = new Dishes();
        dishes.setDishes_id(null);
        dishes.setDishes_name("test");
        dishes.setDishes_des("test_des");
        dishes.setDishes_number("0");
        dishes.setDishes_cate("测试类");
        dishes.setDishes_price("10");
        dishes.setDishes_sales("0");

        dishes.setDishes_photo("/test");
        int num = dao.addDishes(dishes);
        System.out.println(num);

        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void deleteTest() throws Exception {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        SqlSession session = factory.openSession();

        IDishesDao dao = session.getMapper(IDishesDao.class);

        int num = dao.deleteDishes(84);
        System.out.println(num);

        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void updateTest() throws Exception {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        SqlSession session = factory.openSession();

        IDishesDao dao = session.getMapper(IDishesDao.class);

        Dishes dishes = new Dishes();
        dishes.setDishes_id(85);
        dishes.setDishes_name("test2");
        dishes.setDishes_des("test_des2");
        dishes.setDishes_number("10");
        dishes.setDishes_cate("测试类2");
        dishes.setDishes_price("12");
        dishes.setDishes_sales("10");

        dishes.setDishes_photo("/test2");
        int num = dao.updateDishes(dishes);
        System.out.println(num);

        session.commit();
        session.close();
        in.close();
    }

}
