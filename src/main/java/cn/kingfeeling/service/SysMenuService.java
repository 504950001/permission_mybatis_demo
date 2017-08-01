package cn.kingfeeling.service;

import cn.kingfeeling.mapper.SysMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zemal-tan
 * @description
 * @create 2017-08-01 13:52
 */

@Service
public class SysMenuService {

    @Autowired
    SysMenuMapper sysMenuMapper;
}
