package com.zyou.ops.util.base.baseImpl;

import com.zyou.ops.util.base.BaseMapper;
import com.zyou.ops.util.base.BaseService;
import org.springframework.dao.DataAccessException;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.service.base
 * @Author: yang
 * @CreateTime: 2019-01-30 16:50
 * @Description: ${Description}
 */
public abstract class BaseServiceImpl<T extends Object, PK extends Serializable> implements BaseService<T, PK> {
    public abstract BaseMapper<T, PK> getBaseMapper();

    public  Long create(T e) throws DataAccessException{
        return this.getBaseMapper().insert(e);
    }

    public T searchById(PK pk) throws DataAccessException{
        return this.getBaseMapper().selectById(pk);
    }

    public List<T> searchAll() throws DataAccessException{
        return this.getBaseMapper().selectAll();
    }

    public Long update(T e) throws DataAccessException{
        return this.getBaseMapper().update(e);
    }

    public Long delete(PK...pks) throws DataAccessException{
        return this.getBaseMapper().delByIds(pks);
    }

    public Integer getCount() throws  DataAccessException{
        return  this.getBaseMapper().getCount();
    }

    public List<T> getAllByPage(Map<String,Object> map ) throws DataAccessException{
        return  this.getBaseMapper().getAllByPage(map);
    }


}