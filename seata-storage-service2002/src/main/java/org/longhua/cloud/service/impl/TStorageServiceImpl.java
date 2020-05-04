package org.longhua.cloud.service.impl;

import org.longhua.cloud.mapper.TStorageMapper;
import org.longhua.cloud.service.TStorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class TStorageServiceImpl implements TStorageService {

    @Resource
    private TStorageMapper tStorageMapper;

    @Override
    public void decrease(Long productId, Integer count) {
        tStorageMapper.decrease(productId, count);
    }
}
