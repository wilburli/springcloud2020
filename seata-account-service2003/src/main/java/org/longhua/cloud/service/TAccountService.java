package org.longhua.cloud.service;

import java.math.BigDecimal;


public interface TAccountService {

    void decrease(Long userId, BigDecimal money);
}
