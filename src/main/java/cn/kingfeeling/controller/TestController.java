package cn.kingfeeling.controller;

import cn.kingfeeling.model.SysMenu;
import cn.kingfeeling.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author zemal-tan
 * @description
 * @create 2017-07-31 17:13
 */

@Controller
@RequestMapping("/")
public class TestController {

    @Autowired
    SysMenuService sysMenuService;

    @RequestMapping("menuList")
    public ModelAndView getMenuView(){

        List<SysMenu> sysMenuList = sysMenuService.getMenuList();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", sysMenuList);
        modelAndView.setViewName("list");

        return modelAndView;
    }

}
