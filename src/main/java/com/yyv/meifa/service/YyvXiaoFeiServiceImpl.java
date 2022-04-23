package com.yyv.meifa.service;

import com.yyv.meifa.mapper.YyvXiaoFeiMapper;
import com.yyv.meifa.pojo.YyvUser;
import com.yyv.meifa.pojo.YyvXiaoFei;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("yyvXiaoFeiService")
public class YyvXiaoFeiServiceImpl implements YyvXiaoFeiService {
    @Resource(name = "yyvXiaoFeiMapper")
    private YyvXiaoFeiMapper yyvXiaoFeiMapper;
    @Resource(name = "yyvUserService")
    private YyvUserService yyvUserService;

    @Override
    public List<YyvXiaoFei> selectAll(Integer pageIndex,Integer pageSize,String userName,Integer userCode) {
        pageIndex=(pageIndex-1)*pageSize;
        return yyvXiaoFeiMapper.selectAll(pageIndex, pageSize,userName,userCode);
    }

/*    @Override
    public List<YyvXiaoFei> selectXiaoFeiByIdAndName(Integer userCode, String userName) {
        return yyvXiaoFeiMapper.selectXiaoFeiByIdAndName(userCode, userName);
    }*/

    @Override
    public boolean delYyvXiaoFei(Integer id) {
        boolean flag=false;
        int row = yyvXiaoFeiMapper.delYyvXiaoFei(id);
        if(row>0){
            flag=true;
        }
        return flag;
    }

    @Override
    public boolean insertYyvXiaoFei(YyvXiaoFei yyvXiaoFei) throws ParseException {
        boolean flag=false;
        if(yyvXiaoFei.getBenciyuE()-yyvXiaoFei.getBenci()>=0){
            double benci=yyvXiaoFei.getBenci();
            yyvXiaoFei.setSumjin(yyvXiaoFei.getSumjin()+benci);
            yyvXiaoFei.setBenciyuE(yyvXiaoFei.getBenciyuE()-benci);
            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String ssm=dateFormat.format(new Date());
            yyvXiaoFei.setxTime(dateFormat.parse(ssm));
            int row = yyvXiaoFeiMapper.insertYyvXiaoFei(yyvXiaoFei);
            if(row>0){
                YyvUser yyvUser = yyvUserService.selectYyvUserById(yyvXiaoFei.getUserId());
                yyvUser.setSumjin(yyvUser.getSumjin()+benci);
                yyvUser.setYuE(yyvUser.getYuE()-benci);
                yyvUser.setZcount(yyvUser.getZcount()+1);
                yyvUser.setLastTime(yyvXiaoFei.getxTime());
                int count = yyvUserService.xiaoFeiUpdateYyvUser(yyvUser);
                if(count>0){
                    flag=true;
                }

            }

        }
        return flag;
    }

    @Override
    public boolean selectUserId(Integer userId) {
        boolean flag=false;
        int row = yyvXiaoFeiMapper.selectUserId(userId);
        if (row>0){
            flag=true;
        }
        return flag;
    }

    @Override
    public boolean selectSpId(Integer spId) {
        boolean flag=false;
        int row = yyvXiaoFeiMapper.selectSpId(spId);
        if (row>0){
            flag=true;
        }
        return flag;
    }

    @Override
    public boolean deleteUserId(Integer userId) {
        boolean flag=false;
        int row = yyvXiaoFeiMapper.deleteUserId(userId);
        if (row>0){
            flag=true;
        }
        return flag;
    }

    @Override
    public boolean deteleSpId(Integer spId) {
        boolean flag=false;
        int row = yyvXiaoFeiMapper.deteleSpId(spId);
        if (row>0){
            flag=true;
        }
        return flag;
    }

    @Override
    public int selectYyvXiaoFeiCount(String userName, Integer userCode) {

        return yyvXiaoFeiMapper.selectYyvXiaoFeiCount(userName,userCode);
    }
}
