package com.zyou.ops.util.base;

import org.springframework.dao.DataAccessException;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.mapper
 * @Author: yang
 * @CreateTime: 2019-01-30 17:00
 * @Description: ${Description}
 */

public interface BaseMapper<T extends Object,PK extends Serializable>  {

    /**
     * 新增实体
     * @param e
     * @return
     * @throws DataAccessException
     */
    Long insert(T e) throws DataAccessException;
//
//    /**
//     * 新增实体
//     * @param e
//     * @return
//     * @throws DataAccessException
//     */
//    void inserts(T e) throws DataAccessException;
    /**
     * 删除实体
     * @param id
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    Long delByIds(final PK... id) throws DataAccessException;
    /**
     * 更新实体
     * @param e
     * @return
     * @throws DataAccessException
     */
    Long update(T e) throws DataAccessException;


    /**
     * 根据实体id获取实体列表
     * @param id
     * @return
     * @throws DataAccessException
     */
    T selectById(final PK id) throws DataAccessException;
//
//    /**
//     * 根据实体属性获取实体列表
//     * @param e
//     * @return
//     * @throws DataAccessException
//     */
//    List<T> selectByProperty(T e)throws DataAccessException;
//    /**
//     * 获取数据分页
//     * @param e
//     * @return
//     * @throws DataAccessException
//     */
//    List<T> selectByPage(T e)throws DataAccessException;
//    /**
//     * 根据特定参数查询
//     * @param map
//     * @return
//     * @throws DataAccessException
//     */
//    List<T> selectByParam(Map<Object, Object> map) throws DataAccessException;


    List<T> selectAll() throws  DataAccessException;


    /**
     * 分页获取总数
     * @param
     * @return
     * @throws DataAccessException
     */
    Integer getCount() throws  DataAccessException;


    /**
     * 分页获取对象
     * @param map
     * @return
     * @throws DataAccessException
     */
    List<T> getAllByPage(Map<String, Object> map) throws DataAccessException;


}
