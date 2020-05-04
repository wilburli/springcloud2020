package org.longhua.cloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.longhua.cloud.domain.TAccount;

import java.math.BigDecimal;


@Mapper
public interface TAccountMapper extends BaseMapper<TAccount> {
    int decrease(@Param("userId") Long userId,
                 @Param("money") BigDecimal money);
}