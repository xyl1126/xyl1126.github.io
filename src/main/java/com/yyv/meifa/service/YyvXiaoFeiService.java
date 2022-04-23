package com.yyv.meifa.service;

import com.yyv.meifa.pojo.YyvXiaoFei;
import org.apache.ibatis.annotations.Param;

import java.text.ParseException;
import java.util.List;

public interface YyvXiaoFeiService {
    List<YyvXiaoFei> selectAll(Integer pageIndex,Integer pageSize,String userName,Integer userCode);
    //删除
    boolean delYyvXiaoFei(Integer id);
    //添加会员消费
    boolean insertYyvXiaoFei(YyvXiaoFei yyvXiaoFei) throws ParseException;
    //查询userId是否存在
    boolean selectUserId(Integer userId);
    //查询spId是否存在
    boolean selectSpId(Integer spId);
    //根据UserId删除
    boolean deleteUserId(Integer userId);
    //根据spId删除
    boolean deteleSpId(Integer spId);
    //查询总页数
    int selectYyvXiaoFeiCount(String userName,Integer userCode);
}

