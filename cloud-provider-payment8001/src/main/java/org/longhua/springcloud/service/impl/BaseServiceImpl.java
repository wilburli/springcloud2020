package org.longhua.springcloud.service.impl;


import org.longhua.springcloud.dao.BaseMapper;
import org.longhua.springcloud.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {

    private BaseMapper<T> baseDao;

    public void setBaseMapper(BaseMapper<T> baseDao){
        this.baseDao = baseDao;
    }

    @Override
    public int deleteByPrimaryKey(Integer id){
        return baseDao.deleteByPrimaryKey(id);
    }
    @Override
    public int insert(T record){
        return baseDao.insert(record);
    }
    @Override
    public int insertSelective(T record){
        return baseDao.insertSelective(record);
    }
    @Override
    public T selectByPrimaryKey(Integer id){
        return (T) baseDao.selectByPrimaryKey(id);
    }

    @Override
    public T selectByPrimaryKey(Long id){
        return (T) baseDao.selectByPrimaryKey(id);
    }
    @Override
    public int updateByPrimaryKeySelective(T record){
        return baseDao.updateByPrimaryKeySelective(record);
    }
    @Override
    public int updateByPrimaryKey(T record){
        return baseDao.updateByPrimaryKey(record);
    }

}
