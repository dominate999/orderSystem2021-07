package com.nchu.order.util;

import org.apache.log4j.Logger;

/**
 * log4j日志工具类
 */
public class LoggerUtil {
    /*定义静态资源logger*/
    public static Logger logger = Logger.getLogger(LoggerUtil.class);

    private LoggerUtil() {

    }

    public static void setINFOLoggers(String word) {
        logger.info(word);
    }

    public static void setERRORLoggers(String word) {
        logger.error(word);
    }

    public static void setWARNLoggers(String word) {
        logger.warn(word);
    }

    public static void setDEBUGLoggers(String word) {
        logger.debug(word);
    }

}
