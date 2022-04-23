package com.yyv.meifa.mapper;

import com.yyv.meifa.pojo.YyvSp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface YyvSpMapper {
    //查询商品
    List<YyvSp> selectYyvSp();
    //添加商品
    int insertYyvSp(YyvSp yyvSp);
    //修改商品
    int updateYyvSp(YyvSp yyvSp);
    //删除商品
    int deleteYyvSp(Integer id);
    //回显
    YyvSp selectYyvSpById(Integer id);
}
