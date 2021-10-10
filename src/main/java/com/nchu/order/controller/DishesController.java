package com.nchu.order.controller;

import com.github.pagehelper.PageInfo;
import com.nchu.order.entity.Dishes;
import com.nchu.order.service.IDishesService;
import com.nchu.order.util.LoggerUtil;
import com.nchu.order.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * 食物的管理类
 * 对食物进行增删改查操作
 */
@Controller("dishesController")
@RequestMapping("dishes")
public class DishesController {

    @Autowired
    private IDishesService dishesService;

    /**
     * 分页
     * 查询所有的食物信息
     * 后台商家使用
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll")
    public ModelAndView queryAll(@RequestParam(name = "pageNum",required = true,defaultValue = "1")int pageNum, @RequestParam(name = "pageSize",required = true,defaultValue = "5")int pageSize) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Dishes> dishesList =  dishesService.queryAllDishes(pageNum,pageSize);
        //pageInfo就是一个分页Bean
        PageInfo pageInfo = new PageInfo(dishesList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("dishesInfo");  //在视图解析器中配置了前缀后缀
        return mv;
    }

    /**
     * 新增食物信息
     * @param req
     * @param resp
     * @param upload
     * @return
     * @throws Exception
     */
    @RequestMapping("/addDishes")
    public String addDishes(HttpServletRequest req, HttpServletResponse resp, MultipartFile upload) throws Exception {

        String dishesName= req.getParameter("dishes_name");
        String dishesDes= req.getParameter("dishes_des");
        String dishesNum= req.getParameter("dishes_number");
        String dishesCate= req.getParameter("dishes_cate");
        String dishesprice= req.getParameter("dishes_price");

        // 先获取到要上传的文件目录
        String path = req.getSession().getServletContext().getRealPath("/images/foodImg/");
        // 创建File对象，一会向该路径下上传文件
        File file = new File(path);
        // 判断路径是否存在，如果不存在，创建该路径
        if(!file.exists()) {
            file.mkdirs();
        }
        // 获取到上传文件的名称
        String filename = upload.getOriginalFilename();
        String[] ext = filename.split("\\.");
        String endFile = ext[ext.length-1];
        System.out.println(endFile);
        // 把文件的名称唯一化
        filename = "food_"+dishesName+"."+endFile;

        // 上传文件
        upload.transferTo(new File(file,filename));

        Dishes dishes = new Dishes();

        dishes.setDishes_name(dishesName);
        dishes.setDishes_cate(dishesCate);
        dishes.setDishes_number(dishesNum);
        dishes.setDishes_price(dishesprice);
        dishes.setDishes_des(dishesDes);
        dishes.setDishes_photo(filename);
        dishesService.save(dishes);
        LoggerUtil.setINFOLoggers("管理员新增了食物:"+dishesName);
        return "redirect:/dishes/findAll";
    }

    /**
     * 删除食物
     * @param deleteDishesID
     * @return
     * @throws Exception
     */
    @RequestMapping("/deleteDishes")
    public String deleteDishes(@RequestParam("deleteDishesID")int deleteDishesID) throws Exception {

        dishesService.deleteById(deleteDishesID);
        LoggerUtil.setWARNLoggers("管理员删除了食物:"+dishesService.findDishById(deleteDishesID).getDishes_name());
        return "redirect:/dishes/findAll";
    }


    /**
     * 去更新食物信息界面
     * @param updateDishesID
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/toUpdateDishes")
    public String toUpdateDishes(@RequestParam("updateDishesID")int updateDishesID,Model model) throws Exception {
        Dishes updateDishes = dishesService.findDishById(updateDishesID);
        model.addAttribute("updateDishes",updateDishes);
        return "updateDishes";
    }


    /**
     * 更新信息
     * @param req
     * @param resp
     * @param upload
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateDishes")
    public String updateDishes(HttpServletRequest req, HttpServletResponse resp, MultipartFile upload) throws Exception {
        String dishesId= req.getParameter("dishes_id");
        String dishesName= req.getParameter("dishes_name");
        String dishesDes= req.getParameter("dishes_des");
        String dishesNum= req.getParameter("dishes_number");
        String dishesCate= req.getParameter("dishes_cate");
        String dishesprice= req.getParameter("dishes_price");
        String currDishesPhoto = req.getParameter("currDishesPhoto");/*之前保存的图片*/

        System.out.println("uploadName:" + upload.getOriginalFilename());/*上传的图片*/
        System.out.println("myName:" +currDishesPhoto );/*之前的图片*/
        String filename = upload.getOriginalFilename(); // 获取到上传文件的名称

        if(filename != null && filename!="") {
            // 先获取到要上传的文件目录
            String path = req.getSession().getServletContext().getRealPath("/images/foodImg/");
            System.out.println(path);
            // 创建File对象，一会向该路径下上传文件
            File file = new File(path);
            // 判断路径是否存在，如果不存在，创建该路径
            if (!file.exists()) {
                file.mkdirs();
            }
            String[] ext = filename.split("\\.");
            String endFile = ext[ext.length-1];
            System.out.println(endFile);
            // 替换上次的文件即可，文件名变化
            filename =" food_"+dishesId+"."+endFile;
            // 上传文件
            upload.transferTo(new File(file, filename));
            LoggerUtil.setINFOLoggers("上传成功！");
        }else {/*没有修改图片信息*/
            filename = currDishesPhoto;
        }

        Dishes dishes = new Dishes();
        dishes.setDishes_id(Integer.parseInt(dishesId));
        dishes.setDishes_name(dishesName);
        dishes.setDishes_cate(dishesCate);
        dishes.setDishes_number(dishesNum);
        dishes.setDishes_price(dishesprice);
        dishes.setDishes_des(dishesDes);
        dishes.setDishes_photo(filename);
        dishesService.update(dishes);
        LoggerUtil.setWARNLoggers("管理员对食物ID为"+dishesId+"的食物进行了修改");
        return "redirect:/dishes/findAll";
    }


    /**
     * 搜索食物信息
     * 分页
     * 后台商家使用
     * @param pageNum
     * @param pageSize
     * @param searchKw
     * @return
     * @throws Exception
     */
    @RequestMapping("/searchDishes")
    public ModelAndView searchDishes(@RequestParam(name = "pageNum",required = true,defaultValue = "1")int pageNum, @RequestParam(name = "pageSize",required = true,defaultValue = "5")int pageSize,@RequestParam("searchKw")String searchKw) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Dishes> dishesList = dishesService.findDishByKeyWord(pageNum,pageSize,searchKw);
        System.out.println("关键字:"+searchKw+" 查询成功！"+ TimeUtil.getCurrentTime());
        //pageInfo就是一个分页Bean
        PageInfo pageInfo = new PageInfo(dishesList);
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("kw",searchKw);
        mv.setViewName("dishesInfo");  //在视图解析器中配置了前缀后缀
        return mv;
    }


    /**
     * 生成购买对应的商品界面
     * @param productionId
     * @param productionCate
     * @return
     */
    @RequestMapping("/buyProduction")
    public ModelAndView buyProduction(@RequestParam("productionId")int productionId,@RequestParam("productionCate")String productionCate){
        ModelAndView mv = new ModelAndView();
        Dishes dishes = null;
        List<Dishes> introList = null;
        try {
            dishes = dishesService.findDishById(productionId);
            introList = dishesService.findRecommend(productionCate,productionId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.addObject("introList",introList);
        mv.addObject(dishes);
        mv.setViewName("buy");
        return mv;
    }


    /**
     * 购买食物主界面
     * 订餐首页
     * 分页
     * 搜索
     * 排序
     * @param pageNum
     * @param pageSize
     * @param productionCate
     * @param searchKw
     * @param oderByKw
     * @return
     */
    @RequestMapping("/browsePro")
    public ModelAndView browsePro(
            @RequestParam(name = "pageNum",required = true,defaultValue = "1")int pageNum,
            @RequestParam(name = "pageSize",required = true,defaultValue = "9")int pageSize,
            @RequestParam(name = "productionCate",required = true,defaultValue = "菜类")String productionCate,
            @RequestParam(name = "searchKw" ,required = true,defaultValue = "")String searchKw,
            @RequestParam(name = "oderByKw",required = true,defaultValue = "价格降")String oderByKw){
        ModelAndView mv = new ModelAndView();
        List<Dishes> dishesList = null;
        try {
            dishesList = dishesService.findDishOrderBy(pageNum,pageSize,searchKw,oderByKw,productionCate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PageInfo pageInfo = new PageInfo(dishesList);
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("productionCate",productionCate);
        mv.addObject("kw",searchKw);
        mv.addObject("oderByKw",oderByKw);
        mv.setViewName("dishesShopping");
        return mv;
    }
}
