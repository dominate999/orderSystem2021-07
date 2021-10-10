package com.nchu.order.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.PageInfo;
import com.mysql.cj.Session;
import com.nchu.order.entity.Dishes;
import com.nchu.order.entity.UserInfo;
import com.nchu.order.service.IUserInfoService;
import com.nchu.order.util.LoggerUtil;
import com.nchu.order.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

/**
 * 用户信息模块
 */
@Controller("userInfoController")
@RequestMapping("userInfo")
public class UserInfoController {

    @Autowired
    private IUserInfoService userInfoService;

    /**
     * 用户登录系统
     * @param session
     * @param request
     * @param loginUsername
     * @param loginPassword
     * @return
     * @throws Exception
     */
    @RequestMapping("/login")
    public String login(HttpSession session, HttpServletRequest request, @RequestParam("loginUsername")String loginUsername, @RequestParam("loginPassword")String loginPassword) throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setUser_account(loginUsername);
        userInfo.setUser_password(loginPassword);

        if(userInfoService.loginByUsernameAndPassword(userInfo) == true){
            userInfo = userInfoService.findUserAccountByKeyWord(loginUsername);
            session.setAttribute("userInfo",userInfo);
            LoggerUtil.setINFOLoggers(userInfo.getUser_name() +" 登录系统成功！");
            return "redirect:/indexInfo/findIndexAll";

        }else {
            LoggerUtil.setINFOLoggers(userInfo.getUser_name() +" 登录系统失败！");
            request.setAttribute("Error","请检查账号密码是否输入错误！");
            request.setAttribute("ErrorLoginUsername",loginUsername);
            return "forward:/pages/login.jsp";
        }
    }

    /**
     * 用户注销
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/logOut")
    public String logOut(HttpSession session) throws Exception {
        /*销毁session中用户登录的信息*/
        LoggerUtil.setINFOLoggers(((UserInfo)(session.getAttribute("userInfo"))).getUser_account() +" 用户退出系统！");
        session.removeAttribute("userInfo");
        return "redirect:/indexInfo/findIndexAll";

    }

    /**
     * 用户注册
     * @param registerUsername
     * @param registerPassword
     * @param registerAddressed
     * @param registerPhone
     * @return
     * @throws Exception
     */
    @RequestMapping("/register")
    public String register(@RequestParam("registerUsername")String registerUsername,
                           @RequestParam("registerPassword")String registerPassword,
                           @RequestParam("registerAddressed")String registerAddressed,
                           @RequestParam("registerPhone")String registerPhone) throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setUser_account(registerUsername);
        userInfo.setUser_password(registerPassword);
        userInfo.setUser_name(registerUsername);
        userInfo.setUser_phone(registerPhone);
        userInfo.setUser_addressed(registerAddressed);
        userInfo.setUser_photo("photo3.jpg");
        userInfoService.addUser(userInfo);

        //重定向到登录界面登录
        return "redirect:/pages/login.jsp";
    }

    /**
     * ajax检验用户名是否相同
     * @param registerInfomation
     * @return
     * @throws Exception
     */
    @RequestMapping("/ajaxVerifyUsername")
    @ResponseBody
    public int  ajaxVerifyUsername(@RequestParam("registerInfomation")String registerInfomation) throws Exception {
        /*当前用户名已存在 ，不可用*/
        if(userInfoService.existsUsername(registerInfomation)) {
            return -1;
        }
        else{ /*当前用户名已存在*/
            return 1;
        }
    }

    /**
     * 用户修改信息模块
     * @param session
     * @param request
     * @param upadteUserPhoto
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateUser")
        public String updateUser(HttpSession session,HttpServletRequest request,MultipartFile upadteUserPhoto) throws Exception {
            UserInfo updateUserInfo   = (UserInfo) session.getAttribute("userInfo");/*之前保存的图片*/
            String currUserPhoto = updateUserInfo.getUser_photo();
            String updateUsername = request.getParameter("updateUsername");
            String updatePassword = request.getParameter("updatePassword");
            String updateUseraddressed = request.getParameter("updateUseraddressed");
        String updateUserphone = request.getParameter("updateUserphone");
        System.out.println("uploadName:" + upadteUserPhoto.getOriginalFilename());/*上传的图片*/
        System.out.println("myName:" +currUserPhoto );/*之前的图片*/

        String filename = upadteUserPhoto.getOriginalFilename(); // 获取到上传文件的名称

        if(filename != null&& filename!="") {
            // 先获取到要上传的文件目录
            String path = session.getServletContext().getRealPath("/images/");
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
            filename ="user_"+updateUserInfo.getUser_id()+"."+endFile;
            // 上传文件
            upadteUserPhoto.transferTo(new File(file, filename));
            LoggerUtil.setINFOLoggers("用户头像修改成功！");
        }else {/*没有修改图片信息*/
            filename = currUserPhoto;
        }

        UserInfo UuserInfo = new UserInfo();
        UuserInfo.setUser_id(updateUserInfo.getUser_id());
        UuserInfo.setUser_password(updatePassword);
        UuserInfo.setUser_name(updateUsername);
        UuserInfo.setUser_photo(filename);
        UuserInfo.setUser_addressed(updateUseraddressed);
        UuserInfo.setUser_phone(updateUserphone);
        System.out.println(UuserInfo.toString());
        userInfoService.updateUser(UuserInfo);
        session.setAttribute("userInfo",userInfoService.findUserById(updateUserInfo.getUser_id()));
        LoggerUtil.setINFOLoggers(UuserInfo.getUser_account() + " 修改了账号信息!");
        return "redirect:/pages/userInfoCenter.jsp";
    }

    /**
     * 查询所有的用户信息
     * 后台商家使用
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAllUser")
    public ModelAndView findAllUser(@RequestParam(name = "pageNum",required = true,defaultValue = "1")int pageNum, @RequestParam(name = "pageSize",required = true,defaultValue = "5")int pageSize) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userInfoList = userInfoService.queryAllUser(pageNum,pageSize);
        //pageInfo就是一个分页Bean
        PageInfo pageInfo = new PageInfo(userInfoList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("shopUserInfo");
        LoggerUtil.setINFOLoggers("管理员 查看了所有用户信息！");
        return mv;
    }

    /**
     * 后台管理员使用
     * 搜索对应的用户信息
     * @param pageNum
     * @param pageSize
     * @param searchKw
     * @return
     * @throws Exception
     */
    @RequestMapping("/searchUser")
    public ModelAndView searchUser(@RequestParam(name = "pageNum",required = true,defaultValue = "1")int pageNum, @RequestParam(name = "pageSize",required = true,defaultValue = "5")int pageSize,@RequestParam("searchKw")String searchKw )throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userInfoList = userInfoService.findUserByKeyWord(pageNum,pageSize,searchKw);
        LoggerUtil.setINFOLoggers("管理员通过关键字:"+searchKw+"查询了用户信息！");
        //pageInfo就是一个分页Bean
        PageInfo pageInfo = new PageInfo(userInfoList);
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("kw",searchKw);
        mv.setViewName("shopUserInfo");
        return mv;
    }


    @RequestMapping("/toUserInfoCenter")
    public  ModelAndView toUserInfoCenter(HttpSession session) throws  Exception{
        ModelAndView mv = new ModelAndView();
        int userId = ((UserInfo)session.getAttribute("userInfo")).getUser_id();
        UserInfo userInfo = userInfoService.findUserById(userId);
        session.setAttribute("userInfo",userInfo);
        mv.setViewName("userInfoCenter");
        return mv;
    }

}