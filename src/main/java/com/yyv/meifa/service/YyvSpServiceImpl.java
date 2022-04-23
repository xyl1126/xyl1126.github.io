package com.yyv.meifa.service;

import com.yyv.meifa.mapper.YyvSpMapper;
import com.yyv.meifa.pojo.YyvSp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("yyvSpService")
public class YyvSpServiceImpl implements YyvSpService {
    @Resource(name = "yyvSpMapper")
    private YyvSpMapper yyvSpMapper;

    public YyvSpMapper getYyvSpMapper() {
        return yyvSpMapper;
    }

    public void setYyvSpMapper(YyvSpMapper yyvSpMapper) {
        this.yyvSpMapper = yyvSpMapper;
    }

    @Override
    public List<YyvSp> selectYyvSp() {
        return yyvSpMapper.selectYyvSp();
    }

    @Override
    public boolean save(YyvSp yyvSp) {
        boolean flag=false;
        if(yyvSp!=null&&yyvSp.getId()>0){
            if(yyvSpMapper.updateYyvSp(yyvSp)>0){
                flag=true;
            }
        }else {
            if(yyvSpMapper.insertYyvSp(yyvSp)>0){
                flag=true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteYyvSp(Integer id) {
        return (yyvSpMapper.deleteYyvSp(id)>0)?true:false;
    }

    @Override
    public YyvSp selectYyvSpById(Integer id) {
        return yyvSpMapper.selectYyvSpById(id);
    }
}
