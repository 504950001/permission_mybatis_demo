package cn.kingfeeling.controller;

import cn.kingfeeling.config.UrlMappingConfig;
import cn.kingfeeling.content.CallBackModel;
import cn.kingfeeling.content.ResponseConstants;
import cn.kingfeeling.content.Responses;
import cn.kingfeeling.model.SysMenu;
import cn.kingfeeling.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zemal-tan
 * @description 用户、用户组、权限、权限组的增删改查
 * @create 2017-04-08 16:38
 **/

@Controller
@RequestMapping("/menu")
public class MenuController  {

    @Autowired
    SysMenuService sysMenuService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@ModelAttribute SysMenu sysMenu, Model model) {
        Responses responses = null;
        int result = sysMenuService.insert(sysMenu);
        try {
            responses =new Responses(ResponseConstants.SUCCESS_OK,
                    ResponseConstants.CODE_SUCCESS,
                    ResponseConstants.CODE_SUCCESS_VALUE, result);

        } catch (Exception e) {
            e.printStackTrace();
            responses = new Responses(ResponseConstants.SUCCESS_FAILED,
                    ResponseConstants.CODE_FAILED,
                    e.getMessage(), result);
        }
        model.addAttribute(responses);
        return UrlMappingConfig.menuInsert;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam Long pk, Model model) {

        Responses responses = null;
        int result = sysMenuService.deleteByPk(pk);
        try {
            responses =new Responses(ResponseConstants.SUCCESS_OK,
                    ResponseConstants.CODE_SUCCESS,
                    ResponseConstants.CODE_SUCCESS_VALUE, result);

        } catch (Exception e) {
            e.printStackTrace();
            responses = new Responses(ResponseConstants.SUCCESS_FAILED,
                    ResponseConstants.CODE_FAILED,
                    e.getMessage(), result);
        }
        model.addAttribute(responses);
        return UrlMappingConfig.menuDelete;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute SysMenu sysMenu, Model model) {
        Responses responses = null;
        int result = sysMenuService.update(sysMenu);
        try {
            responses =new Responses(ResponseConstants.SUCCESS_OK,
                    ResponseConstants.CODE_SUCCESS,
                    ResponseConstants.CODE_SUCCESS_VALUE, result);

        } catch (Exception e) {
            e.printStackTrace();
            responses = new Responses(ResponseConstants.SUCCESS_FAILED,
                    ResponseConstants.CODE_FAILED,
                    e.getMessage(), result);
        }
        model.addAttribute(responses);
        return UrlMappingConfig.menuUpdate;
    }


    @RequestMapping(value = "/findByPk", method = RequestMethod.GET)
    public String find(@RequestParam Long pk, Model model) {

        Responses responses = null;
        SysMenu result = null;
        try {
            result = sysMenuService.findOne(pk);
            responses = CallBackModel.getSuccesResponse(result);
        }catch (Exception e){
            e.printStackTrace();
            responses = CallBackModel.getErrorResponse(result, e.getMessage());
        }
        model.addAttribute(responses);

        return UrlMappingConfig.menuFind;
    }

}
