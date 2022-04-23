package com.yyv.meifa.service;

import com.yyv.meifa.mapper.YyvUserMapper;
import com.yyv.meifa.pojo.YyvUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("yyvUserService")
public class YyvUserServiceImpl implements YyvUserService {
    @Resource(name = "yyvUserMapper")
    private YyvUserMapper yyvUserMapper;

    @Override
    public List<YyvUser> selectYyvUser(Integer pageIndex,Integer pageSize,String userName,Integer userCode) {
        pageIndex=(pageIndex-1)*pageSize;
        return yyvUserMapper.selectYyvUser(pageIndex, pageSize, userName, userCode);
    }

    @Override
    public boolean insertYyvUser(YyvUser yyvUser) {
        boolean flag=false;
        if(yyvUser!=null){
            int userCode=(int)(Math.random()*999999);
            if(selectYyvUserCode(userCode)!=null){
             userCode=(int)(Math.random()*999999);
            }
            yyvUser.setUserCode(userCode);
            if(yyvUserMapper.insertYyvUser(yyvUser)>0){
                flag=true;
            }
        }
        return flag;
    }
    @Override
    public boolean updateYyvUser(YyvUser yyvUser) {
        boolean flag=false;
        if(yyvUser!=null){
             if(yyvUserMapper.updateYyvUser(yyvUser)>0){
                 flag=true;
             }
        }
        return flag;
    }

    @Override
    public boolean deleteYyvUser(Integer id) {
        boolean flag=false;
        if(yyvUserMapper.deleteYyvUser(id)>0){
            flag=true;
        }
        return flag;
    }
    @Override
    public YyvUser selectYyvUserById(Integer id) {
        return yyvUserMapper.selectYyvUserById(id);
    }
    @Override
    public boolean updateYyvUserByyuE(float yuE, Integer id) {
        boolean flag=false;
        int count=yyvUserMapper.updateYyvUserByyuE(yuE,id);
        if(count>0){
            flag=true;
        }
        return flag;
    }

    @Override
    public YyvUser selectYyvUserCode(Integer userCode) {
        return yyvUserMapper.selectYyvUserCode(userCode);
    }

    @Override
    public int xiaoFeiUpdateYyvUser(YyvUser yyvUser) {

        return yyvUserMapper.xiaoFeiUpdateYyvUser(yyvUser);
    }

    @Override
    public int selectYyvXiaoFeiCount(String userName, Integer userCode) {
        return yyvUserMapper.selectUserCount(userName, userCode);
    }
}
