package cn.kingfeeling.controller;

import cn.kingfeeling.mapper.SysMenuMapper;
import cn.kingfeeling.model.SysMenu;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zemal-tan
 * @description
 * @create 2017-07-31 17:13
 */

@Controller
@RequestMapping("/")
public class TestController {

    @RequestMapping("index")
    @ResponseBody
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        return modelAndView;
    }

    @RequestMapping("index2")
    public ModelAndView add2(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        return modelAndView;
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ResponseBody
    public String welcome(){
        return "test";
    }

    @RequestMapping(value = "test2", method = RequestMethod.GET)
    public String welcome2(){
        return "test";
    }

    @Autowired
    SysMenuMapper sysMenuMapper;

    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ModelAndView query(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");

        modelAndView.addObject("key","value-zemal");
        SysMenu sysMenu = new SysMenu();
        sysMenu.setName("testMenu2");


        sysMenuMapper.insert(sysMenu);

        return modelAndView;
    }

}
