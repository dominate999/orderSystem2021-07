package com.nchu.order.test;


import com.nchu.order.service.IDishesService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 城市spring框架是否搭建成功
 */
public class TestSpring {

    @Test
    public void run1() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        IDishesService iDishesService = (IDishesService) ac.getBean("dishesService");
        iDishesService.queryAllDishes(1, 8);
    }
}

