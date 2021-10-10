package com.nchu.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.nchu.order.dao.IUserInfoDao;
import com.nchu.order.entity.Dishes;
import com.nchu.order.entity.UserInfo;
import com.nchu.order.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息管理服务层实现类
 */
@Service("userinfoService")
public class UserInfoServiceImpl implements IUserInfoService {


    @Autowired
    private IUserInfoDao iUserInfoDao;

    /**
     * 保存用户的信息
     *
     * @return 返回true说明注册成功
     * 返回false说明注册失败！！
     * @throws Exception
     */
    @Override
    public boolean saveUser(UserInfo user) throws Exception {
        // 注册用户信息
        int updateCount = 0;
        updateCount = iUserInfoDao.addUserInfo(user);

        if (updateCount > 0) {
            return true;
        } else
            return false;

    }

    /**
     * 注册时查找是否有重名
     *
     * @return 返回true说明有重名<br />
     * 返回false说明没有重名！！
     * @throws Exception
     */

    @Override
    public boolean ifSame(UserInfo user) throws Exception {
        // 注册用户信息

        int sameCount = iUserInfoDao.queryUserAccount(user.getUser_account());

        if (sameCount > 0) {
            return false;
        } else
            return true;

    }

    /**
     * 登录
     *
     * @param user 登录用户的信息
     * @return 返回的是当前登录的user对象<br />
     * 如果 用户名或者密码错误，返回null
     * @throws Exception
     */
    @Override
    public boolean loginByUsernameAndPassword(UserInfo user) throws Exception {
        // 调用userdao操作数据库查找用户信息是否属实
        int useri = iUserInfoDao.queryUser(user);
        if (useri > 0) {
            return true;
        }
        // 用户不存在，返回false
        return false;

    }

    /**
     * 检查 用户名是否存在
     *
     * @param username
     * @return 返回true表示用户名存在.<br />
     * 返回false表示用户名不存在
     * @throws Exception
     */
    @Override
    public boolean existsUsername(String username) throws Exception {
        // 调用userdao根据用户名搜索用户信息
        int user = iUserInfoDao.queryUserAccount(username);
        // 如果用户存在，则返回true
        if (user > 0) {
            return true;
        }
        // 用户不存在，返回false
        return false;
    }

    /**
     * 新增用户
     *
     * @param userInfo
     * @return
     * @throws Exception
     */
    @Override
    public boolean addUser(UserInfo userInfo) throws Exception {
        int ifok = iUserInfoDao.addUserInfo(userInfo);
        if (ifok > 0) {

            return true;
        } else
            return false;
    }

    /**
     * 通过id删除用户
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteById(int id) throws Exception {
        int ifok = iUserInfoDao.deleteUserInfo(id);
        if (ifok > 0) {

            return true;
        } else
            return false;
    }


    /**
     * 更新用户信息
     *
     * @param userInfo
     * @return
     * @throws Exception
     */
    @Override
    public boolean updateUser(UserInfo userInfo) throws Exception {

        int ifok = iUserInfoDao.updateUserInfo(userInfo);
        if (ifok > 0) {

            return true;
        } else
            return false;
    }

    /**
     * 更新用户积分信息
     *
     * @param userInfo
     * @return
     * @throws Exception
     */
    @Override
    public boolean updateIntegral(UserInfo userInfo) throws Exception {

        int ifok = iUserInfoDao.updateUserIntegral(userInfo.getUser_integral(), userInfo.getUser_id());
        if (ifok > 0) {

            return true;
        } else
            return false;
    }

    /**
     * 分页查询所有的用户信息
     *
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @Override
    public List<UserInfo> queryAllUser(int pageNum, int pageSize) throws Exception {
        //参数pageNum是页码数值，pageSize是查询每页的参数，必须写在调用分页的代码的前面
        PageHelper.startPage(pageNum, pageSize);
        return iUserInfoDao.queryAll();
    }

    /**
     * 通过用户id查询用户信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public UserInfo findUserById(int id) throws Exception {
        return iUserInfoDao.queryIdUserInfo(id);
    }

    /**
     * 关键字查询用户信息
     *
     * @param pageNum
     * @param pageSize
     * @param kw
     * @return
     * @throws Exception
     */
    @Override
    public List<UserInfo> findUserByKeyWord(int pageNum, int pageSize, String kw) throws Exception {
        //参数pageNum是页码数值，pageSize是查询每页的参数，必须写在调用分页的代码的前面
        PageHelper.startPage(pageNum, pageSize);
        return iUserInfoDao.queryUserInfo(kw);
    }

    /**
     * 通过用户昵称查询用户信息
     *
     * @param user_account
     * @return
     * @throws Exception
     */
    @Override
    public UserInfo findUserAccountByKeyWord(String user_account) throws Exception {
        List<UserInfo> findName = new ArrayList<>();
        UserInfo userInfo = new UserInfo();
        findName = iUserInfoDao.queryAll();
        for (int i = 0; i < findName.size(); i++) {
            if (findName.get(i).getUser_account().equals(user_account)) {
                userInfo = findName.get(i);
                break;
            }
        }
        return userInfo;
    }


}
