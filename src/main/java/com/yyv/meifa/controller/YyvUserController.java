package com.yyv.meifa.controller;

import com.alibaba.fastjson.JSON;
import com.yyv.meifa.pojo.YyvUser;
import com.yyv.meifa.service.YyvUserService;
import com.yyv.meifa.service.YyvXiaoFeiService;
import com.yyv.meifa.util.PageSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class YyvUserController {
    @Resource(name = "yyvUserService")
    private YyvUserService yyvUserService;
    @Resource(name = "yyvXiaoFeiService")
    private YyvXiaoFeiService yyvXiaoFeiService;
    @RequestMapping("home")
    public String home(){
        return "YyvUser/list";
    }
    @RequestMapping("/list")
    @ResponseBody
    public Object list(@RequestParam(defaultValue = "1",required = false) Integer pageIndex,@RequestParam(required = false)String userName,@RequestParam(required = false)Integer userCode){
        Integer pageSize=2;
        PageSupport ps=new PageSupport();
        ps.setPageSize(pageSize);
        ps.setCurrentPageNo(pageIndex);
        int count = yyvUserService.selectYyvXiaoFeiCount(userName, userCode);
        ps.setTotalCount(count);
        List<YyvUser> yyvUserList = yyvUserService.selectYyvUser(pageIndex,pageSize,userName,userCode);
        ps.setYyvUsers(yyvUserList);
        String withDateFormat = JSON.toJSONStringWithDateFormat(ps, "yyyy-MM-dd HH:mm:dd");
        return withDateFormat;
    }
    @RequestMapping("/del")
    @ResponseBody
    public Object del(@RequestParam Integer id){
        boolean flag =false;
        boolean fl = yyvXiaoFeiService.selectUserId(id);
        if(fl){
            boolean deleteUserId = yyvXiaoFeiService.deleteUserId(id);
            if(deleteUserId){
                boolean row = yyvUserService.deleteYyvUser(id);
                if (row){
                    flag=true;
                }
            }
        }else {
            boolean row = yyvUserService.deleteYyvUser(id);
            if (row){
                flag=true;
            }
        }

        return flag;
    }
    @RequestMapping("/toupdate")
    public String toUpdate(Model model,@RequestParam Integer id){
        YyvUser yyvUser = yyvUserService.selectYyvUserById(id);
        model.addAttribute("yyvUser",yyvUser);
        return "YyvUser/update";
    }
    @RequestMapping("update")
    public String update(YyvUser yyvUser,Model model){
        boolean flag = yyvUserService.updateYyvUser(yyvUser);
        if(flag){
            return "redirect:/user/home";
        }else {
            model.addAttribute("error","修改失败请从新修改");
            return "redirect:/user/update?id="+yyvUser.getId();
        }
    }
    @RequestMapping("toadd")
    public String toadd(){
        return "YyvUser/add";
    }
    @RequestMapping("add")
    public String add(YyvUser yyvUser,Model model){
        boolean flag = yyvUserService.insertYyvUser(yyvUser);
        if(flag){
            return "redirect:/user/home";
        }else {
            model.addAttribute("error","添加失败失败请从新添加");
            return "redirect:/user/toadd";
        }
    }
    @RequestMapping("cj")
    @ResponseBody
    public Object cj(@RequestParam float yuE,@RequestParam Integer id){
        boolean flag = yyvUserService.updateYyvUserByyuE(yuE, id);
        return flag;
    }
    @RequestMapping("/userCodeAjax")
    @ResponseBody
    public Object userCodeAjax(@RequestParam Integer userCode){
        YyvUser yyvUser = yyvUserService.selectYyvUserCode(userCode);
        return yyvUser;
    }
}
