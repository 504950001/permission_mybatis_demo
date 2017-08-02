package cn.kingfeeling.controller;

import cn.kingfeeling.config.UrlMappingConfig;
import cn.kingfeeling.content.CallBackModel;
import cn.kingfeeling.content.ResponseConstants;
import cn.kingfeeling.content.Responses;
import cn.kingfeeling.content.SessionCache;
import cn.kingfeeling.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author zemal-tan
 * @description 用于前端页面的请求
 * @create 2017-07-29 11:25
 */
@RequestMapping("/")
@Controller
public class PageController {

//    @Autowired
//    UrlMappingConfig urlMappingConfig;

//    @Value("${page.login}")
//    private String login; //直接在Controller引用

    @Autowired
    PageService pageService;


    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return UrlMappingConfig.loginPage;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();

        SessionCache sessionCache = null;
        Responses responses = null;
        try {
            sessionCache = pageService.login(username, password, session);
            responses = CallBackModel.getSuccesResponse(sessionCache);
        }catch (Exception e){
            e.printStackTrace();
            responses = CallBackModel.getErrorResponse(sessionCache, e.getMessage());
        }

        model.addAttribute(responses);

        if (responses.getCode()== ResponseConstants.CODE_FAILED){ // 抛出异常,登录失败,返回到登录页面
            return UrlMappingConfig.loginPage;
        }

        // 返回了session中的一些属性值,可以在前端获取到用户名和权限url,用户名可以放到cookie中,权限url
        // 决定了那些页面可以显示和访问
        return UrlMappingConfig.indexPage;
    }


    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String indexPage() {
        return UrlMappingConfig.indexPage;
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, Model model) {
        Responses responses = null;
        Object result = null;
        try {
            pageService.logout(request.getSession());
            result = "注销成功!";
            responses = CallBackModel.getSuccesResponse(result);
        }catch (Exception e){
            e.printStackTrace();
            result = "注销失败!";
            responses = CallBackModel.getErrorResponse(result, e.getMessage());
        }

        model.addAttribute(responses);

        return UrlMappingConfig.loginPage;
    }

    @RequestMapping(value = "unauthorized", method = RequestMethod.GET)
    public String unauthorized() {

        return UrlMappingConfig.unauthorizedPage;
    }

}
