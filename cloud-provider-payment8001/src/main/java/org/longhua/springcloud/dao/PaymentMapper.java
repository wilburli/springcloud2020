package org.longhua.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.longhua.springcloud.entities.Payment;

@Mapper
public interface PaymentMapper extends BaseMapper<Payment>{

}