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
public class SysMenuService implements BaseService<SysMenu>{

    @Autowired
    SysMenuMapper sysMenuMapper;


    public int insert(SysMenu sysMenu) {
        return sysMenuMapper.insert(sysMenu);
    }

    public int insertList(List<SysMenu> list) {
        try {
            for (SysMenu sysMenu: list){
                sysMenuMapper.insert(sysMenu);
            }
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    public int update(SysMenu sysMenu) {
        return sysMenuMapper.updateByPrimaryKey(sysMenu);
    }

    public int updateList(List<SysMenu> list) {
        try {
            for (SysMenu sysMenu: list){
                sysMenuMapper.updateByPrimaryKey(sysMenu);
            }
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return 1;
    }


    public int deleteByPk(Long pk) {
        return sysMenuMapper.deleteByPrimaryKey(pk);
    }

    public int deleteByPks(List<Long> pks) {
        try {
            for (Long pk: pks){
                sysMenuMapper.deleteByPrimaryKey(pk);
            }
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return 1;
    }


    public SysMenu findOne(Long pk) {
        return sysMenuMapper.selectByPrimaryKey(pk);
    }

    public List<SysMenu> findList(List<Long> pks) {
        List<SysMenu> result = new ArrayList<SysMenu>();
        try {
            for (Long pk: pks){
                result.add(sysMenuMapper.selectByPrimaryKey(pk));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
