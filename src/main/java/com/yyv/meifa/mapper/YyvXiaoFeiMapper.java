package com.yyv.meifa.mapper;

import com.yyv.meifa.pojo.YyvXiaoFei;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YyvXiaoFeiMapper {
    //查询全部
    List<YyvXiaoFei> selectAll(@Param("pageIndex") Integer pageIndex,@Param("pageSize") Integer pageSize,@Param("userName") String userName,@Param("userCode") Integer userCode);
  /*  //按会员号或会员名称查询
    List<YyvXiaoFei> selectXiaoFeiByIdAndName(@Param("userCode")Integer userCode,@Param("userName") String userName);*/
    //删除
    int delYyvXiaoFei(Integer id);
    //添加会员消费
    int insertYyvXiaoFei(YyvXiaoFei yyvXiaoFei);
    //查询userId是否存在
    int selectUserId(Integer userId);
    //查询spId是否存在
    int selectSpId(Integer spId);
    //根据UserId删除
    int deleteUserId(Integer userId);
    //根据spId删除
    int deteleSpId(Integer spId);
    //查询总页数
    int selectYyvXiaoFeiCount(@Param("userName") String userName,@Param("userCode") Integer userCode);

}
