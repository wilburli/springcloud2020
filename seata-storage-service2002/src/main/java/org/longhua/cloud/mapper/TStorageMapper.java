package org.longhua.cloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.longhua.cloud.domain.TStorage;

@Mapper
public interface TStorageMapper extends BaseMapper<TStorage> {
    int decrease(@Param("productId") Long productId, @Param("count") Integer count);
}