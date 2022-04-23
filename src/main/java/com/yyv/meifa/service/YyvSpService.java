package com.yyv.meifa.service;

import com.yyv.meifa.pojo.YyvSp;

import java.util.List;

public interface YyvSpService {
    //查询商品
    List<YyvSp> selectYyvSp();
   //添加,修改商品
    boolean save(YyvSp yyvSp);
    //删除商品
    boolean deleteYyvSp(Integer id);
    //回显
    YyvSp selectYyvSpById(Integer id);
}
