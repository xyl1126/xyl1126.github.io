package com.yyv.meifa.service;

import com.yyv.meifa.pojo.YyvXiaoFei;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class YyvXiaoFeiServiceTest {
        @Autowired
        YyvXiaoFeiService yyvXiaoFeiService;
    @Test
    void selectYyvXiaoFeiCount() {
        int row = yyvXiaoFeiService.selectYyvXiaoFeiCount(null, null);
        System.out.println(row);
    }

    @org.junit.Test
    public void selectAll() {
        List<YyvXiaoFei> yyvXiaoFeis = yyvXiaoFeiService.selectAll(1, 2, null, null);
        for(YyvXiaoFei y:yyvXiaoFeis){
            System.out.println(y.getxTime());
        }
    }
}