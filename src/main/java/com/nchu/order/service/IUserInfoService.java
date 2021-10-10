package com.nchu.order.service;

import com.nchu.order.entity.Dishes;
import com.nchu.order.entity.UserInfo;

import java.util.List;

/**
 * 用户信息管理服务层
 */
public interface IUserInfoService {

    /**
     * 保存用户的信息
     *
     * @return 返回true说明注册成功
     * 返回false说明注册失败！！
     * @throws Exception
     */
    boolean saveUser(UserInfo user) throws Exception;

    /**
     * 注册时查找是否有重名
     *
     * @return 返回true说明有重名<br />
     * 返回false说明没有重名！！
     * @throws Exception
     */

    boolean ifSame(UserInfo user) throws Exception;

    /**
     * 登录
     *
     * @param user 登录用户的信息
     * @return 返回的是当前登录的user对象<br />
     * 如果 用户名或者密码错误，返回null
     * @throws Exception
     */
    boolean loginByUsernameAndPassword(UserInfo user) throws Exception;

    /**
     * 检查 用户名是否存在
     *
     * @param username
     * @return 返回true表示用户名存在.<br />
     * 返回false表示用户名不存在
     * @throws Exception
     */
    boolean existsUsername(String username) throws Exception;

    /**
     * 新增用户
     *
     * @param userInfo
     * @return
     * @throws Exception
     */
    boolean addUser(UserInfo userInfo) throws Exception;

    /**
     * 通过id删除用户
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteById(int id) throws Exception;

    /**
     * 更新用户信息
     *
     * @param userInfo
     * @return
     * @throws Exception
     */
    boolean updateUser(UserInfo userInfo) throws Exception;

    /**
     * 更新用户积分信息
     *
     * @param userInfo
     * @return
     * @throws Exception
     */
    boolean updateIntegral(UserInfo userInfo) throws Exception;

    /**
     * 分页查询所有的用户信息
     *
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    List<UserInfo> queryAllUser(int pageNum, int pageSize) throws Exception;

    /**
     * 通过用户id查询用户信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    UserInfo findUserById(int id) throws Exception;

    /**
     * 关键字查询用户信息
     *
     * @param pageNum
     * @param pageSize
     * @param kw
     * @return
     * @throws Exception
     */
    List<UserInfo> findUserByKeyWord(int pageNum, int pageSize, String kw) throws Exception;

    /**
     * 通过用户昵称查询用户信息
     *
     * @param user_account
     * @return
     * @throws Exception
     */
    UserInfo findUserAccountByKeyWord(String user_account) throws Exception;
}
