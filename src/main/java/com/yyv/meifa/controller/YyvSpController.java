package com.yyv.meifa.controller;

import com.yyv.meifa.pojo.YyvSp;
import com.yyv.meifa.service.YyvSpService;
import com.yyv.meifa.service.YyvXiaoFeiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/sp")
public class YyvSpController {
    @Resource(name = "yyvSpService")
    private YyvSpService yyvSpService;
    @Resource(name = "yyvXiaoFeiService")
    private YyvXiaoFeiService yyvXiaoFeiService;

    public YyvSpService getYyvSpService() {
        return yyvSpService;
    }

    public void setYyvSpService(YyvSpService yyvSpService) {
        this.yyvSpService = yyvSpService;
    }
    @RequestMapping("/list")
    public String listSp(Model model){
        List<YyvSp> yyvSpList = yyvSpService.selectYyvSp();
        model.addAttribute("yyvSpList",yyvSpList);
        return "YyvSp/list";
    }
    @RequestMapping("/del")
    @ResponseBody
    public Object del(@RequestParam Integer id){
        boolean flag =false;
        boolean row = yyvXiaoFeiService.selectSpId(id);
        if (row){
            boolean deteleSpId = yyvXiaoFeiService.deteleSpId(id);
            if (deteleSpId){
                flag=yyvSpService.deleteYyvSp(id);
            }
        }else {
            flag=yyvSpService.deleteYyvSp(id);
        }

        return flag;
    }
    @RequestMapping("/update")
    public String update(Model model,@RequestParam Integer id){
        YyvSp yyvSp = yyvSpService.selectYyvSpById(id);
        model.addAttribute("yyvsp",yyvSp);
        return "YyvSp/save";
    }
    @RequestMapping("/save")
    public String save(YyvSp yyvSp){
        if(yyvSp.getId()==null||yyvSp.getId().equals("")){
            yyvSp.setId(0);
        }
        boolean save = yyvSpService.save(yyvSp);

            return "redirect:/sp/list";

    }
    @RequestMapping("toadd")
    public String toadd(){
        return "YyvSp/save";
    }

}
