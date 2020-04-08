package org.longhua.springcloud.lb.impl;

import org.longhua.springcloud.lb.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements LoadBalancer {

    AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){

        int current;
        int next;

        do{
            current = this.atomicInteger.get();
            next = current >= 2147483647 ?0:current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        // 获取第几次访问  高并发的时候next容易被别人取走 所以自旋
        return next;
    }

    @Override
    public ServiceInstance getInstance(List<ServiceInstance> serviceInstance) {
        int index = getAndIncrement() % serviceInstance.size();
        return serviceInstance.get(index);
    }
}
