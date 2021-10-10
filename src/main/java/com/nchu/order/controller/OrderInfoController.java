package com.nchu.order.controller;

import com.github.pagehelper.PageInfo;
import com.nchu.order.entity.*;
import com.nchu.order.service.IOrderInfoService;
import com.nchu.order.service.impl.CartInfoServiceImpl;
import com.nchu.order.util.LoggerUtil;
import com.nchu.order.util.TimeUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * 订单信息控制器
 * 用户可以查看订单信息
 * 管理员也可以查看订单信息
 */
@Controller("orderInfoController")
@RequestMapping("orderInfo")
public class OrderInfoController {
    @Autowired
    private IOrderInfoService orderInfoService;


    /**
     * 后台管理员使用
     * 查询所有的订单信息
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAllOrder")
    public ModelAndView findAllOrder(@RequestParam(name = "pageNum",required = true,defaultValue = "1")int pageNum, @RequestParam(name = "pageSize",required = true,defaultValue = "5")int pageSize) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<OrderInfoVO> orderInfoVOList = orderInfoService.queryShopOrders(pageNum,pageSize);
        //pageInfo就是一个分页Bean
        PageInfo pageInfo = new PageInfo(orderInfoVOList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orderInfo");
        return mv;
    }

    /**
     * 后台管理员使用
     * 查询订单信息
     * @param pageNum
     * @param pageSize
     * @param searchKw
     * @return
     * @throws Exception
     */
    @RequestMapping("/searchOrder")
    public ModelAndView searchOrder(@RequestParam(name = "pageNum",required = true,defaultValue = "1")int pageNum, @RequestParam(name = "pageSize",required = true,defaultValue = "5")int pageSize,@RequestParam("searchKw")String searchKw )throws Exception {
        ModelAndView mv = new ModelAndView();
        List<OrderInfoVO> orderInfoVOList = orderInfoService.queryOrdersByKeyWord(pageNum,pageSize,searchKw);
        System.out.println("关键字:"+searchKw+" 查询成功！"+ TimeUtil.getCurrentTime());
        //pageInfo就是一个分页Bean
        PageInfo pageInfo = new PageInfo(orderInfoVOList);
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("kw",searchKw);
        mv.setViewName("orderInfo");
        return mv;
    }

    /**
     * 查询对应订单的详情信息
     * @param findOrderId
     * @return
     * @throws Exception
     */
    @RequestMapping("/findOrderItem")
    public ModelAndView findOrderItem(@RequestParam("findOrderId")int findOrderId )throws Exception {
        ModelAndView mv = new ModelAndView();

        List<OrderItemVO> orderItemVOList = orderInfoService.queryOrderItems(findOrderId);

        mv.addObject("orderItemVOList",orderItemVOList);
        mv.setViewName("orderItemInfo");
        return mv;
    }

    /**
     * 更新对应的订单信息
     * @param updateOrderId
     * @param updateStatus
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateOrderStatus")
    @ResponseBody
    public String updateOrderStatus(@RequestParam("updateOrderId")int updateOrderId,@RequestParam("updateStatus")String updateStatus) throws Exception {
        System.out.println(updateOrderId+""+updateStatus);

        orderInfoService.updateOrder(updateOrderId,updateStatus);

        return updateStatus;
    }

    /**
     * 导出订单的报表信息
     * @param response
     * @throws Exception
     */
    @RequestMapping("/orderExcelExport")
    public void orderExcelExport(HttpServletResponse response)throws Exception {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/ms-excel");
        // 弹出层会有一个乱码问题
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String fileName = "订单信息"+TimeUtil.getCurrentTime()+".xlsx";
        response.setHeader("Content-Disposition", "inline;filename="+new String(fileName.getBytes("utf-8"),"iso-8859-1"));

        /*service*/
        XSSFWorkbook wb = orderInfoService.ordersExcelExport();

        LoggerUtil.setINFOLoggers("管理员导出订单信息!");

        // 打印出对应的Excel表格
        ServletOutputStream sos = response.getOutputStream();
        wb.write(response.getOutputStream());
        sos.flush();
        sos.close();
    }


    /**
     * 将用户购物车里面的东西转换成用户订单
     * @param session

     * @return
     */
    @RequestMapping("/saveUserOrder")
    public ModelAndView saveUserOrder(HttpSession session){
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        CartInfoServiceImpl cart = new CartInfoServiceImpl();
        String orderName = null;
        try {
            Map<Integer, Cart> caMap = (Map<Integer, Cart>) session.getAttribute("cartMap");
            cart.setItems(caMap);
            orderName = orderInfoService.saveOrder(cart,userInfo.getUser_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.setAttribute("orderName",orderName);
        LoggerUtil.setINFOLoggers("当前用户"+((UserInfo)session.getAttribute("userInfo")).getUser_account()+"已清空购物车！");
        mv.setViewName("alipay.trade.page.pay");
        return mv;
    }

    /**
     * 用户使用
     * 查询当前用户的所有订单信息
     * @param session
     * @return
     */
    @RequestMapping("/findUserOrder")
    public ModelAndView findUserOrder(HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        ModelAndView mv = new ModelAndView();
        List<OrderInfo> orderInfoList = null;
        try {
            orderInfoList = orderInfoService.queryUserOrders(userInfo.getUser_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.addObject("orderInfoList",orderInfoList);
        mv.setViewName("queryOrder");
        return mv;
    }

    /**
     * 用户使用
     * 查询对用的订单详情信息
     * @param findOrderId
     * @return
     * @throws Exception
     */
    @RequestMapping("/findUserOrderItem")
    public ModelAndView findUserOrderItem(HttpSession session,@RequestParam("findOrderId")int findOrderId )throws Exception {
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        ModelAndView mv = new ModelAndView();
        List<OrderItemVO> orderItemVOList = orderInfoService.queryOrderItems(findOrderId);
        LoggerUtil.setINFOLoggers("用户"+userInfo.getUser_account()+"查询了订单"+findOrderId+"的详情");
        mv.addObject("orderItemVOList",orderItemVOList);
        mv.setViewName("browseOrder");
        return mv;
    }


}
