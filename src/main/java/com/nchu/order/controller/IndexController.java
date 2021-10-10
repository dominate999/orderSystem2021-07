package com.nchu.order.controller;

import com.nchu.order.entity.Dishes;
import com.nchu.order.entity.EvaInfo;
import com.nchu.order.entity.EvaInfoVO;
import com.nchu.order.service.IDishesService;
import com.nchu.order.service.IEvaInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * 首页控制器
 */
@Controller("indexController")
@RequestMapping("indexInfo")
public class IndexController {

    @Autowired
    private IEvaInfoService iEvaInfoService;
    @Autowired
    private IDishesService iDishesService;

    /**
     * 查询对应的所有信息到放到主界面
     * 分别对应有
     * 评价信息
     * 菜类信息
     * 水果信息
     * 奶茶信息
     * 甜点信息
     * @return
     */
    @RequestMapping("/findIndexAll")
    public ModelAndView findIndexAll(){
        ModelAndView mv = new ModelAndView();
        List<Dishes> foodList = null;
        List<Dishes> fruitList = null;
        List<Dishes> drinkList = null;
        List<Dishes> dessertList = null;
        List<EvaInfoVO> evaInfoVOList = null;

        try {
            foodList = iDishesService.findDishCateByKeyWord("菜类");
            fruitList = iDishesService.findDishCateByKeyWord("水果");
            drinkList = iDishesService.findDishCateByKeyWord("奶茶");
            dessertList = iDishesService.findDishCateByKeyWord("甜点");
            evaInfoVOList = iEvaInfoService.queryEva();
        } catch (Exception e) {
            e.printStackTrace();
        }


        mv.addObject("foodList",foodList);
        mv.addObject("fruitList",fruitList);
        mv.addObject("drinkList",drinkList);
        mv.addObject("dessertList",dessertList);
        mv.addObject("evaInfoVOList",evaInfoVOList);
        mv.setViewName("main");
        return mv;
    }

}
