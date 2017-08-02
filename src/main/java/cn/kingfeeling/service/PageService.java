package cn.kingfeeling.service;

import cn.kingfeeling.mapper.SysMenuMapper;
import cn.kingfeeling.mapper.SysUserMapper;
import cn.kingfeeling.model.SysRole;
import cn.kingfeeling.model.SysUser;
import cn.kingfeeling.content.SessionCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zemal-tan
 * @description 登录,登出等操作
 * @create 2017-08-02 9:18
 */
@Service
public class PageService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Autowired
    SysMenuMapper sysMenuMapper;
    
    public static final String SESSION_KEY = "username";

    public SessionCache login(String username, String password, HttpSession session){
        SysUser sysUser = sysUserMapper.findByUsername(username);

        if (sysUser == null) {
            throw new RuntimeException("请输入正确的的用户名!");
        }

        if (!password.equals(sysUser.getPassword())) {
            throw new RuntimeException("请输入正确的密码!");
        }

        // 获取权限信息写入session
        SessionCache sessionCache = new SessionCache();
        sessionCache.setId(sysUser.getId());
        sessionCache.setUsername(sysUser.getUsername());

        Set<String> urlSet = new HashSet<String>(); // 存放可访问url

        // --------------可优化-----------------
        Set<Long> menuIdSet = sysUserMapper.findMenuIdsByPk(sysUser.getId()); // 只是开始节点的menuId
        for (Long menuId: menuIdSet){
            Set<String> urls = sysMenuMapper.findUrlByMenuId(menuId); // 错误,需要遍历该节点及其子节点
            if (urls != null && urls.size()>0)
                urlSet.addAll(urls);
        }

        if (urlSet != null && urlSet.size() >0)
            sessionCache.setMenuUrl(urlSet);
        session.setAttribute(SESSION_KEY, sessionCache);

        return sessionCache;
    }

    public void logout(HttpSession session){
        session.removeAttribute(SESSION_KEY);
    }
}
