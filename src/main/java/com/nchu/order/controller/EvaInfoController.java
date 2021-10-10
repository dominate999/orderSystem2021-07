package com.nchu.order.controller;

import com.nchu.order.dao.IEvaInfoVODao;
import com.nchu.order.entity.EvaInfo;
import com.nchu.order.entity.OrderItemVO;
import com.nchu.order.entity.UserInfo;
import com.nchu.order.service.ICartInfoService;
import com.nchu.order.service.IEvaInfoService;
import com.nchu.order.service.IOrderInfoService;
import com.nchu.order.util.LoggerUtil;
import com.sun.org.apache.xml.internal.serializer.AttributesImplSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户评价信息管理控制器
 * 对用户评价信息的增删改查
 */
@Controller("EvaInfoController")
@RequestMapping("evaInfo")
public class EvaInfoController {

    @Autowired
    private IEvaInfoService iEvaInfoService;
    @Autowired
    private IOrderInfoService iOrderInfoService;

    /**
     * 查询当前用户的所有的评价信息
     * @param session
     * @return
     */
    @RequestMapping("findUserEvaInfo")
    public ModelAndView findUserEvaInfo(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        int userId  = userInfo.getUser_id();
        List<EvaInfo> evaInfoList = null;
        try {
            evaInfoList = iEvaInfoService.findEvaByUserId(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.addObject("evaInfoList", evaInfoList);
        mv.setViewName("queryEcaluate");
        return mv;
    }

    /**
     * 跳转到对应的订单进行评价的界面
     * @param session
     * @param orderName
     * @param orderId
     * @return
     */
    @RequestMapping("evaDishes")
    public ModelAndView evaDishes(HttpSession session, @RequestParam("orderName")String orderName,@RequestParam("orderId")int orderId) {
        ModelAndView mv = new ModelAndView();
        session.setAttribute("orderName", orderName);
        session.setAttribute("orderId", orderId);
        mv.setViewName("evaluateOrder");
        return mv;
    }

    /**
     * 新增评价信息
     * @param req
     * @param resp
     * @param session
     * @return
     */
    @RequestMapping("addEvaInfo")
    public String addEvaInfo(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        EvaInfo evaInfo = new EvaInfo();
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        int userId  = userInfo.getUser_id();
        String evaContent = req.getParameter("txt");
        String starNum = req.getParameter("starNum");
        evaInfo.setUser_id(userId);
        evaInfo.setEva_content(evaContent);
        evaInfo.setEva_degree(starNum);
        evaInfo.setOrder_id(Integer.parseInt(req.getParameter("orderId")));
        System.out.println(evaInfo.toString());
        try {
            iEvaInfoService.save(evaInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/evaInfo/findUserEvaInfo";
    }


    /**
     * 删除评价
     * @param evaId
     * @return
     */
    @RequestMapping("/deleteEvaInfo")
    public String deleteEvaInfo(@RequestParam("evaId")int evaId){
        try {
            iEvaInfoService.deleteById(evaId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/evaInfo/findUserEvaInfo";
    }

    /**
     * 去更新评价信息界面
     * @param evaId
     * @return
     */
    @RequestMapping("toUpdateEvaInfo")
    public ModelAndView toUpdateEvaInfo(@RequestParam("evaId")int evaId){
        ModelAndView mv = new ModelAndView();
        List<OrderItemVO> orderItemVOList = null;
        EvaInfo evaInfo = null;
        try {
            evaInfo = iEvaInfoService.findEvaById(evaId);
            orderItemVOList = iOrderInfoService.queryOrderItems(evaInfo.getOrder_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.addObject("evaInfo",evaInfo);
        mv.addObject("orderItemVOList",orderItemVOList);
        mv.setViewName("updateEvaluate");
        return  mv;
    }

    /**
     * 更新评价信息
     * @param req
     * @param resp
     * @param session
     * @return
     */
    @RequestMapping("updateEvaInfo")
    public String updateEvaInfo(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        EvaInfo evaInfo = new EvaInfo();
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        evaInfo.setEva_id(Integer.parseInt(req.getParameter("evaId")));
        evaInfo.setUser_id(userInfo.getUser_id());
        evaInfo.setEva_content(req.getParameter("evaContent"));
        evaInfo.setEva_degree(req.getParameter("starNum"));
        evaInfo.setOrder_id(Integer.parseInt(req.getParameter("orderId")));

        try {
            iEvaInfoService.update(evaInfo);
            System.out.println(evaInfo.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/evaInfo/findUserEvaInfo";
    }


}
