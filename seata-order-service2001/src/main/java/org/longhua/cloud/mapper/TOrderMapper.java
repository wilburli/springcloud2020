package org.longhua.cloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.longhua.cloud.domain.TOrder;


@Mapper
public interface TOrderMapper{
    /**
     * 新建订单
     */
    int creat(TOrder order);

    /**
     * 更改订单状态
     */
    int update(@Param("userId") Long userId, @Param("status") Integer status);
}