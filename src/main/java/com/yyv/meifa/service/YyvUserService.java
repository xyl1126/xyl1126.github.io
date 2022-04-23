package com.yyv.meifa.service;

import com.yyv.meifa.pojo.YyvUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YyvUserService {
    //查询全部
    List<YyvUser> selectYyvUser(Integer pageIndex,Integer pageSize,String userName,Integer userCode);
    //添加
    boolean insertYyvUser(YyvUser yyvUser);
    //修改
    boolean updateYyvUser(YyvUser yyvUser);
    //删除
    boolean deleteYyvUser(Integer id);
    //修改回显
    YyvUser selectYyvUserById(Integer id);
    //充值余额
    boolean updateYyvUserByyuE(float yuE,Integer id);
    //判断会员号是否存在
    YyvUser selectYyvUserCode(Integer userCode);
    //添加消费记录成功后修改会员信息
    int xiaoFeiUpdateYyvUser(YyvUser yyvUser);
    //查询总页数
    int selectYyvXiaoFeiCount(@Param("userName") String userName,@Param("userCode") Integer userCode);
}
