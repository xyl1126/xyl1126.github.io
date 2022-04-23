package com.yyv.meifa.mapper;

import com.yyv.meifa.pojo.YyvXiaoFei;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class YyvXiaoFeiMapperTest {
    @Autowired
    private YyvXiaoFeiMapper yyvXiaoFeiMapper;
    @Test
    void selectYyvXiaoFeiCount() {
        int row = yyvXiaoFeiMapper.selectYyvXiaoFeiCount(null, null);
        System.out.println(row);
    }

    @Test
    void selectAll() {
        List<YyvXiaoFei> yyvXiaoFeis = yyvXiaoFeiMapper.selectAll(0, 2, null, null);
        for(YyvXiaoFei y:yyvXiaoFeis){
            System.out.println(y.getId());
        }
    }
}