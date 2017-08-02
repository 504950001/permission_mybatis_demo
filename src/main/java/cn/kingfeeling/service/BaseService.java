package cn.kingfeeling.service;

import java.util.List;
import java.util.Set;

/**
 * @author zemal-tan
 * @description 基础service层接口,基本增删改查功能
 * @create 2017-08-01 16:50
 */
public interface BaseService<T> {

    int insert(T t); // 有主键id为修改,没有为增加

    int insertList(List<T> list);

    int update(T t); // 有主键id为修改,没有为增加

    int updateList(List<T> list);

    int deleteByPk(Long pk);

    int deleteByPks(List<Long> pks);

    T findOne(Long pk);

    List<T> findList(List<Long> pks);


}
