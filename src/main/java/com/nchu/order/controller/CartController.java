package com.nchu.order.controller;

import com.nchu.order.entity.Cart;
import com.nchu.order.entity.Dishes;
import com.nchu.order.entity.UserInfo;
import com.nchu.order.service.ICartInfoService;
import com.nchu.order.service.IDishesService;
import com.nchu.order.util.LoggerUtil;
import net.sf.json.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.*;

/***
 * 购物车控制器
 * 实现对购物车的增删改等
 */
@Controller("cartController")
@RequestMapping("cartInfo")
public class CartController {

    @Autowired
    private ICartInfoService iCartInfoService;
    @Autowired
    private IDishesService iDishesService;

    /**
     * 查询所有的购物车信息
     * @param session
     * @return
     */
    @RequestMapping("/findCart")
    public ModelAndView findCart(HttpSession session){
        ModelAndView mv = new ModelAndView();
        List<Cart> cartList = new ArrayList<>();
        Map<Integer,Cart> cartMap = new HashMap<>();
        List<Dishes> dishesList = new ArrayList<>();
        int totalCount = 0;

        BigDecimal totalMoney = BigDecimal.valueOf(0);

        try {
            cartMap  = iCartInfoService.getItems();
            totalCount = iCartInfoService.getTotalCount();
            totalMoney = iCartInfoService.getTotalMoney();

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Map.Entry<Integer, Cart> item : cartMap.entrySet()) {
            Cart cart = item.getValue();
            cartList.add(cart);

        }
        session.setAttribute("cartMap",cartMap);
        session.setAttribute("totalCount",totalCount);
        mv.addObject("totalCount",totalCount);
        session.setAttribute("totalMoney",totalMoney);
        mv.addObject("totalMoney",totalMoney);
        session.setAttribute("cartList",cartList);
        mv.addObject("cartList",cartList);
        mv.setViewName("cart");

        return mv;
    }

    /**
     * 删除购物车指定的商品
     * @param deleteCartID
     * @return
     */
    @RequestMapping("/deleteCart")
    public String deleteCart(HttpSession session,@RequestParam("deleteCartID")int deleteCartID){

        try {
            iCartInfoService.deleteItem(deleteCartID);
        } catch (Exception e) {
            e.printStackTrace();
        }

        LoggerUtil.setINFOLoggers("当前用户删除了商品:"+deleteCartID);
        LoggerUtil.setINFOLoggers("当前购物车里的数量："+session.getAttribute("totalCount"));
        return "redirect:/cartInfo/findCart";
    }


    /**
     * 清空购物车
     * @return
     */
    @RequestMapping("/clearCart")
    public String clearCart(){
        try {
            iCartInfoService.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        LoggerUtil.setINFOLoggers("当前用户清空了购物车！");
        return "redirect:/cartInfo/findCart";
    }

    /**
     * 添加商品到购物车中
     * @param dishesId
     * @param session
     * @return
     */
    @RequestMapping("/addCart")
    @ResponseBody
    public int addCart(@RequestParam("dishesId")int dishesId,HttpSession session){
        Dishes dishes = new Dishes();

        try {
            dishes = iDishesService.findDishById(dishesId);
            iCartInfoService.addItem(dishes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(session.getAttribute("totalCount") == null){
            session.setAttribute("totalCount",0);
        }
        /*手动更新session*/
        session.setAttribute("totalCount",(int)session.getAttribute("totalCount")+1);
        int cartTotalCount =(int)session.getAttribute("totalCount");
        System.out.println("购物车里的数量："+cartTotalCount);

        LoggerUtil.setINFOLoggers("当前用户新增了商品"+dishesId+"到购物车中..");
        LoggerUtil.setINFOLoggers("购物车里当前的数量："+cartTotalCount);

        return cartTotalCount;
    }

    /**
     * 更新购物车的信息
     * @param cartId
     * @param count
     * @param session
     * @return
     */
    @RequestMapping("/updateCart")
    @ResponseBody
    public List updateCart(@RequestParam("cartId")int cartId, @RequestParam("count")int count, HttpSession session){
        System.out.println("CartId:"+cartId);
        System.out.println("Count:"+count);
        try {
            iCartInfoService.updateItem(cartId,count);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*修改当前的购物车中选定的的价格*/
        List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
        int cartTotalCount = 0;
        int cartTotalMoney = 0;
        int currentCartMoney = 0;
        for (Cart cart:cartList) {
            if(cart.getId() == cartId){
                cart.setCount(count+"");/*将前台输入过来的数量替换*/
                cart.setTotalMoney( Integer.parseInt(cart.getPrice())*count+"");
                currentCartMoney = Integer.parseInt(cart.getTotalMoney());
                break;
            }

        }

        for (Cart cart:cartList) {
            cartTotalMoney += Integer.parseInt(cart.getTotalMoney());
            cartTotalCount +=Integer.parseInt(cart.getCount());
        }


        System.out.println("当前商品数量="+cartTotalCount);
        System.out.println("当前商品的总价格 = "+cartTotalMoney);
        session.setAttribute("cartList",cartList);


        session.setAttribute("totalMoney",cartTotalMoney+"");
        System.out.println("当前购物车里面的总价格="+cartTotalMoney);

        /*更新session*/
        session.setAttribute("totalCount",cartTotalCount);
        System.out.println("购物车里的数量："+cartTotalCount);

        List<String> cartInfoList = new ArrayList<>();
        cartInfoList.add(cartTotalCount +"");/*购物车的总数量*/
        cartInfoList.add(currentCartMoney +"");/*当前的商品的价格*/
        cartInfoList.add(cartTotalMoney+"");/*购物车的总价格*/
        return cartInfoList;
    }


    @RequestMapping("/success")
    public ModelAndView success(){
        ModelAndView mv= new ModelAndView();
        System.out.println("购买成功！");
        mv.setViewName("cart.jsp");
        return mv;
    }
}
