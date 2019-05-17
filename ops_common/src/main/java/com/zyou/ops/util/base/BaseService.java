package com.zyou.ops.util.base;

import org.springframework.dao.DataAccessException;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.service.base
 * @Author: yang
 * @CreateTime: 2019-01-30 16:40
 * @Description: ${Description}
 */
public interface BaseService<T extends Object,PK extends Serializable> {

    /**
     * 添加
     * @param t
     * @return
      */
      Long create(T t) throws DataAccessException,Exception;
    /**
     * 修改
     * @param t
     */
     Long update(T t)throws DataAccessException,Exception;
    /**
     * 根据主键查询
     * @param pk
     * @return
     */
    T searchById(PK pk)throws DataAccessException,Exception;
//    /**
//     * 分页查询
//     * @return
//     */
//    List<T> searchByPage(T t)throws DataAccessException,Exception;
//    /**
//     *
//     * @param t
//     * @return
//     * @throws
//     */
//    List<T> searchByProperty(T t)throws DataAccessException,Exception;
    /**
     * 删除
     * @throws
     */
    @SuppressWarnings("unchecked")
    Long delete(PK... pks) throws DataAccessException,Exception;
//    /**
//     * 批量增加
//     *
//     * @param e
//     * @throws Exception
//     */
//    void batchInsert(Collection<T> e) throws DataAccessException,Exception;
//
//    /**
//     * 批量修改
//     *
//     * @param e
//     * @throws Exception
//     */
//    void batchUpdate(Collection<T> e) throws DataAccessException,Exception;


    /**
     * 查询列表
     */

    List<T> searchAll(T e) throws DataAccessException,Exception;


    List<T> searchAll() throws DataAccessException,Exception;


}
