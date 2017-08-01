package cn.kingfeeling.service;

import cn.kingfeeling.mapper.SysMenuMapper;
import cn.kingfeeling.model.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zemal-tan
 * @description
 * @create 2017-08-01 13:52
 */

@Service
public class SysMenuService {

    @Autowired
    SysMenuMapper sysMenuMapper;

    public List<SysMenu> getMenuList(){
        List<SysMenu> sysMenuList = new ArrayList<SysMenu>();

        SysMenu sysMenu = new SysMenu();
        sysMenu.setName("menu8.1");
        sysMenu.setUrl("/menu8.1");
        sysMenuMapper.insert(sysMenu);
        sysMenuList.add(sysMenu);
        return sysMenuList;
    }
}
