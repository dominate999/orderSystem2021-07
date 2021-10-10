package com.nchu.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.nchu.order.dao.*;
import com.nchu.order.entity.*;
import com.nchu.order.service.IOrderInfoService;

import com.nchu.order.util.ExcelExportUtil;
import com.nchu.order.util.LoggerUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单信息管理服务层实现类
 */
@Service("orderInfoService")
public class OrderInfoServiceImpl implements IOrderInfoService {
    // 在userService中保存一个dao的引用。用来操作数据库
    @Autowired
    private IUserInfoDao iUserInfoDao;
    @Autowired
    private IOrderDao iOrderDao;
    @Autowired
    private IOrderItemDao iOrderItemDao;
    @Autowired
    private IDishesDao iDishesDao;
    @Autowired
    private IOrderInfoVODao iOrderInfoVODao;
    @Autowired
    private IOrderItemVODao iOrderItemVODao;

    /**
     * 订单的生成
     *
     * @param cart   购物车信息
     * @param userId 用户id信息
     * @return 返回订单号
     * @throws Exception
     */
    @Override//订单的生产
    public String saveOrder(CartInfoServiceImpl cart, int userId) throws Exception {
        // 创建订单对象
        OrderInfo order = new OrderInfo();
        Date dateTime = new Date();
        //将Date类型转化为String类型并存至订单对象中的结算时间
        String time;
        SimpleDateFormat formater = new SimpleDateFormat();
        formater.applyPattern("yyyy-MM-dd HH:mm");
        time = formater.format(dateTime);
        order.setOrder_time(time);
        //将BigDecimal类型转化为String类型并存至订单对象中的总金额
        cart.getTotalMoney().setScale(1, BigDecimal.ROUND_HALF_UP);
        String moneyString = String.valueOf(cart.getTotalMoney());
        order.setOrder_money(moneyString);
        String countString = String.valueOf(cart.getTotalCount());
        order.setOrder_number(countString);
        order.setUser_id(userId);
        order.setOrder_status("未接单");
        // 生成订单号
        char paramChar = (char) (Math.random() * 26 + 'A');
        String number = String.valueOf((int) ((Math.random() * 9 + 1) * 1000000));
        String orderName = paramChar + number;

        order.setOrder_name(orderName);
        // 保存订单
        int i = iOrderDao.addOrderInfo(order);

        // 遍历购物车中有每一个商品
        List<OrderItem> items = new ArrayList<OrderItem>();
        for (Cart cartItem : cart.getItems().values()) {
            // 生成订单项
            OrderItem orderItem = new OrderItem(0, order.getOrder_id(), cartItem.getId(), cartItem.getCount(),
                    cartItem.getTotalMoney());

            items.add(orderItem);
            // 修改食物的库存和销量
            Dishes dishes = iDishesDao.queryIdDishes(cartItem.getId());
            dishes.setDishes_number(String.valueOf(Integer.valueOf(dishes.getDishes_number()) - Integer.valueOf(cartItem.getCount())));
            dishes.setDishes_sales(String.valueOf(Integer.valueOf(dishes.getDishes_sales()) + Integer.valueOf(cartItem.getCount())));
            iDishesDao.updateDishes(dishes);

        }
        // 批量插入
        for (OrderItem item : items) {
            iOrderItemDao.addOrderItem(item);
        }
        // 清空购物车
        cart.clear();
        if (i > 0) {
            return order.getOrder_name();
        } else
            return "-1";
    }

    /**
     * 我的订单列表
     *
     * @param userId 用户id号
     * @return 返回用户的订单信息
     * @thro ws Exception
     */
    @Override
    public List<OrderInfo> queryUserOrders(int userId) throws Exception {
        return iOrderDao.queryUserOrderInfo(userId);
    }

    /**
     * 订单详情
     *
     * @param orderId 要查询的订单号
     * @return 订单详细
     * @throws Exception
     */
    @Override
    public List<OrderItemVO> queryOrderItems(int orderId) throws Exception {
        return iOrderItemVODao.queryIDOrderItemVO(orderId);
    }

    /**
     * 商铺--查看所有订单
     *
     * @throws Exception
     */
    @Override
    public List<OrderInfoVO> queryShopOrders(int pageNum, int pageSize) throws Exception {
        //参数pageNum是页码数值，pageSize是查询每页的参数，必须写在调用分页的代码的前面
        PageHelper.startPage(pageNum, pageSize);
        return iOrderInfoVODao.queryOrderInfoVO();
    }

    /**
     * 商铺--通过关键字查看订单
     *
     * @throws Exception
     */
    @Override
    public List<OrderInfoVO> queryOrdersByKeyWord(int pageNum, int pageSize, String kw) throws Exception {
        //参数pageNum是页码数值，pageSize是查询每页的参数，必须写在调用分页的代码的前面
        PageHelper.startPage(pageNum, pageSize);
        return iOrderInfoVODao.queryKWOrderInfoVO(kw);
    }

    /**
     * 修改订单状态
     *
     * @param orderId 配送的订单号
     * @throws Exception
     */
    @Override
    public void updateOrder(int orderId, String status) throws Exception {
        OrderInfo orderInfo = iOrderDao.queryIdOrderInfo(orderId);

        orderInfo.setOrder_status(status);/*修改状态*/
        UserInfo lastUserInfo = iUserInfoDao.queryIdUserInfo(orderInfo.getUser_id());
        if(status.equals("已完成")){
            int lastInteger = Integer.parseInt(lastUserInfo.getUser_integral());
            int addInteger = Integer.parseInt(orderInfo.getOrder_money());
            int currentInteger = lastInteger+addInteger*10;
            iUserInfoDao.updateUserIntegral(String.valueOf(currentInteger),orderInfo.getUser_id());
            System.out.println(currentInteger);
            LoggerUtil.setINFOLoggers("用户"+lastUserInfo.getUser_account()+"积分更新为："+currentInteger);
        }
        iOrderDao.updateOrderInfo(orderInfo);
    }

    /**
     * 修改状态为已配送
     *
     * @param orderId 配送的订单号
     * @throws Exception
     */
    @Override
    public void serveOrder(int orderId) throws Exception {
        OrderInfo serve = new OrderInfo();
        serve.setOrder_id(orderId);
        serve.setOrder_status("已配送");
        iOrderDao.updateOrderInfo(serve);
    }


    /**
     * 修改状态为未接单
     *
     * @param orderId 未接单的订单号
     * @throws Exception
     */
    @Override
    public void noReceiveOrder(int orderId) throws Exception {
        OrderInfo noReceive = new OrderInfo();
        noReceive.setOrder_id(orderId);
        noReceive.setOrder_status("未接单");
        iOrderDao.updateOrderInfo(noReceive);
    }

    /**
     * 修改状态为已接单
     *
     * @param orderId 已接单的订单号
     * @throws Exception
     */
    @Override
    public void receiveOrder(int orderId) throws Exception {
        OrderInfo receive = new OrderInfo();
        receive.setOrder_id(orderId);
        receive.setOrder_status("已接单");
        iOrderDao.updateOrderInfo(receive);
    }

    /**
     * 修改状态为已完成
     *
     * @param orderId 已完成的订单号
     * @throws Exception
     */
    @Override
    public void completeOrder(int orderId) throws Exception {
        OrderInfo complete = new OrderInfo();
        complete.setOrder_id(orderId);
        complete.setOrder_status("已完成");
        iOrderDao.updateOrderInfo(complete);
    }

    /**
     * 修改状态为已取消
     *
     * @param orderId 已取消的订单号
     * @throws Exception
     */
    @Override
    public void noCompleteOrder(int orderId) throws Exception {
        OrderInfo noComplete = new OrderInfo();
        noComplete.setOrder_id(orderId);
        noComplete.setOrder_status("已取消");
        iOrderDao.updateOrderInfo(noComplete);
    }

    /**
     * 订单报表信息管理
     *
     * @return
     * @throws Exception
     */
    @Override
    public XSSFWorkbook ordersExcelExport() throws Exception {
        List<OrderInfoVO> orderInfoVOList = queryAllOrders();
        List<OrderItemVO> orderItemVOList = queryAllOrderItems();
        return ExcelExportUtil.getXSSFWorkbook(orderInfoVOList, orderItemVOList);

    }

    /**
     * 查询订单信息视图里的所有信息
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<OrderInfoVO> queryAllOrders() throws Exception {
        return iOrderInfoVODao.queryOrderInfoVO();
    }


    /**
     * 查询订单详情里的所有信息
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<OrderItemVO> queryAllOrderItems() throws Exception {
        return iOrderItemVODao.queryAllOrderItemVO();
    }


}
