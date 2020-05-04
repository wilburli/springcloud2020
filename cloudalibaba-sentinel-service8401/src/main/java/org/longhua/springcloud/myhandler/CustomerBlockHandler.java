package org.longhua.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.longhua.springcloud.entities.CommonResult;

public class CustomerBlockHandler {

    public static CommonResult handler1Exception(BlockException exception){
        return new CommonResult(4444,"global自定义阻塞handler");
    }

    public static CommonResult handler1Exception2(BlockException exception){
        return new CommonResult(4444,"global自定义阻塞handler2");
    }

}
