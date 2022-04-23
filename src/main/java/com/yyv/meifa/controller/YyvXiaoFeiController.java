package com.yyv.meifa.controller;

import com.alibaba.fastjson.JSON;
import com.yyv.meifa.pojo.YyvSp;
import com.yyv.meifa.pojo.YyvXiaoFei;
import com.yyv.meifa.service.YyvSpService;
import com.yyv.meifa.service.YyvXiaoFeiService;
import com.yyv.meifa.util.PageSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("show")
public class YyvXiaoFeiController {
    @Resource(name = "yyvXiaoFeiService")
    private YyvXiaoFeiService yyvXiaoFeiService;
    @Resource(name = "yyvSpService")
    private YyvSpService yyvSpService;
    @RequestMapping("/home")
    public String home(){
        return "YyvXiaoFei/list";
    }
    @RequestMapping("list")
    @ResponseBody
    public Object show(Model model,@RequestParam(defaultValue = "1",required = false) Integer pageIndex,@RequestParam(required = false) String userName,@RequestParam(required = false) Integer userCode){
        Integer pageSize=20;
        PageSupport ps=new PageSupport();
        ps.setPageSize(pageSize);
        ps.setCurrentPageNo(pageIndex);
        int count = yyvXiaoFeiService.selectYyvXiaoFeiCount(userName, userCode);
        ps.setTotalCount(count);
        List<YyvXiaoFei> yyvXiaoFeiList = yyvXiaoFeiService.selectAll(pageIndex,pageSize,userName,userCode);
        ps.setYyvXiaoFeis(yyvXiaoFeiList);
        String jsonString = JSON.toJSONStringWithDateFormat(ps,"yyyy-MM-dd HH:mm:dd");
        return jsonString;
    }
    @RequestMapping("/user")
    public String user(){
        return "redirect:/user/list";
    }
    @RequestMapping("/sp")
    public String sp(){
        return "redirect:/sp/list";
    }
    @RequestMapping("del")
    @ResponseBody
    public Object del(@RequestParam Integer id){
        boolean flag = yyvXiaoFeiService.delYyvXiaoFei(id);
        return flag;
    }
    @RequestMapping("toAdd")
    public String toAdd(Model model) {
        List<YyvSp> yyvSpList = yyvSpService.selectYyvSp();
        model.addAttribute("yyvSpList", yyvSpList);
        return "YyvXiaoFei/add";
    }

    @RequestMapping("add")
    @ResponseBody
    public Object add(YyvXiaoFei yyvXiaoFei) throws ParseException {
        boolean flag = yyvXiaoFeiService.insertYyvXiaoFei(yyvXiaoFei);
        return flag;
    }
}
