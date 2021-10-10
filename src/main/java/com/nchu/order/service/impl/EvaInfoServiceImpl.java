package com.nchu.order.service.impl;

import com.nchu.order.dao.IEvaInfoDao;
import com.nchu.order.dao.IEvaInfoVODao;
import com.nchu.order.entity.Dishes;
import com.nchu.order.entity.EvaInfo;
import com.nchu.order.entity.EvaInfoVO;
import com.nchu.order.service.IEvaInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 评价信息服务层实现类
 */
@Service("evaInfoService")
public class EvaInfoServiceImpl implements IEvaInfoService {

    @Autowired
    private IEvaInfoDao evaInfoDao;
    @Autowired
    private IEvaInfoVODao evaInfoVODao;

    /**
     * 新增评价信息
     *
     * @param evaInfo
     * @return
     * @throws Exception
     */
    @Override
    public boolean save(EvaInfo evaInfo) throws Exception {
        Date dateTime = new Date();
        String time;
        SimpleDateFormat formater = new SimpleDateFormat();
        formater.applyPattern("yyyy-MM-dd HH:mm");
        time = formater.format(dateTime);
        evaInfo.setEva_time(time);
        int ifok = evaInfoDao.addEvaInfo(evaInfo);
        if (ifok > 0) {

            return true;
        } else
            return false;
    }

    /**
     * 通过id删除评价信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteById(int id) throws Exception {
        int ifok = evaInfoDao.deleteEvaInfo(id);
        if (ifok > 0) {

            return true;
        } else
            return false;
    }


    /**
     * 修改评价信息
     *
     * @param evaInfo
     * @return
     * @throws Exception
     */
    @Override
    public boolean update(EvaInfo evaInfo) throws Exception {

        int ifok = evaInfoDao.updateEvaInfo(evaInfo);
        if (ifok > 0) {

            return true;
        } else
            return false;
    }


    /**
     * 查询所有的信息
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<EvaInfo> queryAllEva() throws Exception {
        return evaInfoDao.queryAll();
    }


    /**
     * 通过关键字查询订单
     *
     * @param kw
     * @return
     * @throws Exception
     */
    @Override
    public List<EvaInfo> queryEvaByKeyWord(String kw) throws Exception {
        return evaInfoDao.queryEvaInfo(kw);
    }

    /**
     * 通过eva_id查询对应的评价
     *
     * @param eva_id
     * @return
     * @throws Exception
     */
    @Override
    public EvaInfo findEvaById(int eva_id) throws Exception {
        return evaInfoDao.queryIdEvaInfo(eva_id);
    }


    /**
     * 查询订单视图里的所有信息
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<EvaInfoVO> queryEva() throws Exception {
        List<EvaInfoVO> queryEva = evaInfoVODao.queryEvaInfoVO();
        for (int i = 0; i < queryEva.size(); i++) {
            if (Integer.valueOf(queryEva.get(i).getEva_degree()) < 3) {
                queryEva.remove(i);
                i--;
            }
        }
        Collections.shuffle(queryEva);
        return queryEva;
    }


    /**
     * 通过用户查询对应的所有订单
     *
     * @param user_id
     * @return
     * @throws Exception
     */
    @Override
    public List<EvaInfo> findEvaByUserId(int user_id) throws Exception {
        return evaInfoDao.queryUserEvaInfo(user_id);
    }

}
