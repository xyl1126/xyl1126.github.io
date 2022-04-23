package com.yyv.meifa.mapper;

import com.yyv.meifa.pojo.YyvUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface YyvUserMapper {
    //查询全部
    List<YyvUser> selectYyvUser(@Param("pageIndex") Integer pageIndex,@Param("pageSize") Integer pageSize,@Param("userName")String userName,@Param("userCode") Integer userCode);
    //添加
    int insertYyvUser(YyvUser yyvUser);
    //修改
    int updateYyvUser(YyvUser yyvUser);
    //删除
    int deleteYyvUser(Integer id);
    //修改回显
    YyvUser selectYyvUserById(Integer id);
    //充值余额
    int updateYyvUserByyuE(@Param("yuE") float yuE, @Param("id") Integer id);
    //判断会员号是否存在
    YyvUser selectYyvUserCode(Integer userCode);
    //添加消费记录成功后修改会员信息
    int xiaoFeiUpdateYyvUser(YyvUser yyvUser);
    //查询user表总页数
    int selectUserCount(@Param("userName")String userName,@Param("userCode") Integer userCode);
}
