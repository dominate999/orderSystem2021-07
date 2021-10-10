package com.nchu.order.test;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 测试log4j是否配置好
 */
public class Log4j2Test {
    private static Logger logger = LogManager.getLogger(Log4j2Test.class.getName()); // log4j

    public static void main(String[] args) {
        logger.error("Did it again!");   //error级别的信息，参数就是你输出的信息
        logger.info("我是info信息");    //info级别的信息
        logger.debug("我是debug信息");
        logger.warn("我是warn信息");
        logger.fatal("我是fatal信息");
        logger.log(Level.DEBUG, "我是debug信息"); //这个就是制定Level类型的调用：谁闲着没事调用这个，也不一定哦！
        logger.trace("开始程序.");
        for (int i = 0; i < 2; i++) {
            logger.error("hello");
        }
        logger.trace("退出程序.");
    }
}

