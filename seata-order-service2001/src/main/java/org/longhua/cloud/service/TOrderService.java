package org.longhua.cloud.service;

import org.longhua.cloud.domain.TOrder;

public interface TOrderService{
    /**
     * 新建订单
     */
    int create(TOrder order);
}
