package com.nchu.order.service;


import com.nchu.order.entity.OrderInfo;
import com.nchu.order.entity.OrderInfoVO;
import com.nchu.order.entity.OrderItem;
import com.nchu.order.entity.OrderItemVO;
import com.nchu.order.service.impl.CartInfoServiceImpl;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

/**
 * 订单信息管理服务层
 */
public interface IOrderInfoService {

    /**
     * 订单的生成
     *
     * @param cart   购物车信息
     * @param userId 用户id信息
     * @return 返回订单号
     * @throws Exception
     */
    String saveOrder(CartInfoServiceImpl cart, int userId) throws Exception;

    /*
     * 我的订单列表
     *
     * @param userId
     *            用户id号
     * @return 返回用户的订单信息
     * @throws Exception
     */
    List<OrderInfo> queryUserOrders(int userId) throws Exception;

    /*
     * 订单详情
     *
     * @param orderId
     *            要查询的订单号
     * @return 订单详细
     * @throws Exception
     */
    List<OrderItemVO> queryOrderItems(int orderId) throws Exception;

    /*
     * 商铺--查看所有订单
     * @throws Exception
     */
    List<OrderInfoVO> queryShopOrders(int pageNum, int pageSize) throws Exception;

    /*
     * 商铺--通过关键字查看订单
     * @throws Exception
     */
    List<OrderInfoVO> queryOrdersByKeyWord(int pageNum, int pageSize, String kw) throws Exception;


    /**
     * 修改订单状态
     *
     * @param orderId 配送的订单号
     * @throws Exception
     */
    void updateOrder(int orderId, String status) throws Exception;

    /**
     * 修改状态为已配送
     *
     * @param orderId 配送的订单号
     * @throws Exception
     */
    void serveOrder(int orderId) throws Exception;


    /**
     * 修改状态为未接单
     *
     * @param orderId 未接单的订单号
     * @throws Exception
     */
    void noReceiveOrder(int orderId) throws Exception;

    /**
     * 修改状态为已接单
     *
     * @param orderId 已接单的订单号
     * @throws Exception
     */
    void receiveOrder(int orderId) throws Exception;

    /**
     * 修改状态为已完成
     *
     * @param orderId 已完成的订单号
     * @throws Exception
     */
    void completeOrder(int orderId) throws Exception;

    /**
     * 修改状态为已取消
     *
     * @param orderId 已取消的订单号
     * @throws Exception
     */
    void noCompleteOrder(int orderId) throws Exception;

    /**
     * 订单报表信息管理
     *
     * @return
     * @throws Exception
     */
    XSSFWorkbook ordersExcelExport() throws Exception;

    /**
     * 查询订单信息视图里的所有信息
     *
     * @return
     * @throws Exception
     */
    List<OrderInfoVO> queryAllOrders() throws Exception;


    /**
     * 查询订单详情里的所有信息
     *
     * @return
     * @throws Exception
     */
    List<OrderItemVO> queryAllOrderItems() throws Exception;

}
