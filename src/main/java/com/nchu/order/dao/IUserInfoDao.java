package com.nchu.order.dao;

import com.nchu.order.entity.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface IUserInfoDao {
    //增

    /**
     *
     * @param userinfo
     * @return
     */
    @Insert("insert into userinfo values (null," +
            "#{user_account}," +
            "#{user_password}," +
            "#{user_name}," +
            "#{user_addressed}," +
            "#{user_phone}," +
            "#{user_photo}," +
            "'0');")
    int addUserInfo(UserInfo userinfo);

    //删

    @Delete("delete from userinfo where USER_ID = #{id};")
    int deleteUserInfo(int id);

    //查

    /**
     *
     * @return
     */
    @Select(" select * from userinfo")
    List<UserInfo> queryAll();

    //改

    /**
     *
     * @param userinfo
     * @return
     */
    @Update({
            "<script> ",
            "update userinfo set ",
            "<if test = \"user_account != null\">",
            "user_account=#{user_account},",
            "</if>",
            "<if test = \"user_password != null\">",
            "user_password=#{user_password},",
            "</if>",
            "<if test = \"user_name != null\">",
            "user_name=#{user_name},",
            "</if>",
            "<if test = \"user_addressed != null\">",
            "user_addressed=#{user_addressed},",
            "</if> ",
            "<if test = \"user_phone != null\">",
            "user_phone=#{user_phone},",
            "</if>",
            "<if test = \"user_photo != null\">",
            "user_photo=#{user_photo},",
            "</if>",
            "<if test = \"user_integral != null\">",
            "user_integral=#{user_integral},",
            "</if>",
            "user_id = #{user_id} ",
            "WHERE user_id=#{user_id};",
            "</script>"
    })
    int updateUserInfo(UserInfo userinfo);

    //更新积分

    /**
     *
     * @param integral
     * @param id
     * @return
     */
    @Update("UPDATE userinfo SET USER_INTEGRAL = #{integral} WHERE USER_ID = #{id};")
    int updateUserIntegral(@Param("integral") String integral, @Param("id") int id);

    //条件查询（kw）

    /**
     *
     * @param kw
     * @return
     */
    @Select("select * from userinfo where 1=1 \n" +
            "and USER_ID LIKE CONCAT('%',#{kw},'%')\n" +
            "OR USER_ACCOUNT LIKE CONCAT('%',#{kw},'%')\n" +
            "OR USER_NAME LIKE CONCAT('%',#{kw},'%')\n" +
            "OR USER_PASSWORD LIKE CONCAT('%',#{kw},'%')\n" +
            "OR USER_ADDRESSED LIKE CONCAT('%',#{kw},'%')\n" +
            "OR USER_PHONE LIKE CONCAT('%',#{kw},'%')")
    List<UserInfo> queryUserInfo(String kw);

    //条件查询（map）

    /**
     *
     * @param map
     * @return
     */
    @Select("select * from userinfo where 1=1 \n" +
            "and USER_ACCOUNT LIKE CONCAT('%',#{map_user_account},'%')\n" +
            "and USER_NAME LIKE CONCAT('%',#{map_user_name},'%')\n" +
            "and USER_PASSWORD LIKE CONCAT('%',#{map_user_password},'%')\n" +
            "and USER_ADDRESSED LIKE CONCAT('%',#{map_user_addressed},'%')\n" +
            "and USER_PHONE LIKE CONCAT('%',#{map_user_phone},'%');")
    List<UserInfo> queryMapUserInfo(Map map);

    //主键查询（id）

    /**
     *
     * @param id
     * @return
     */
    @Select("select * from userinfo where USER_ID = #{id}")
    UserInfo queryIdUserInfo(int id);

    //分页查询（kw，start，size）

    /**
     *
     * @param kw
     * @param start
     * @param size
     * @return
     */
    @Select("select * from userinfo where 1=1 \n" +
            "and USER_ID LIKE CONCAT('%',#{kw},'%')\n" +
            "OR USER_ACCOUNT LIKE CONCAT('%',#{kw},'%')\n" +
            "OR USER_NAME LIKE CONCAT('%',#{kw},'%')\n" +
            "OR USER_PASSWORD LIKE CONCAT('%',#{kw},'%')\n" +
            "OR USER_ADDRESSED CONCAT('%',#{kw},'%')\n" +
            "OR USER_PHONE LIKE CONCAT('%',#{kw},'%')\n" +
            "LIMIT #{start},#{size};")
    List<UserInfo> queryPageUserInfo(@Param("kw")String kw, @Param ("start") int start, @Param ("size") int size);

    //统计查询（count）

    /**
     *
     * @return
     */
    @Select("select count(USER_ID) from userinfo where 1=1;")
    int queryUserInfoNum();

    //查询账号（account）
    @Select("select count(USER_ID) from userinfo where user_account = #{account};")
    int queryUserAccount(String account);

    //验证密码(account password)
    @Select("select count(USER_ID) from userinfo where user_account = #{user_account} " +
            "and user_password = #{user_password}")
    int queryUser(UserInfo userinfo);
}
