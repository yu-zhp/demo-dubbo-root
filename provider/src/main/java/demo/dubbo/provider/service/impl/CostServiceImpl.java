package demo.dubbo.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import demo.dubbo.api.service.CostService;

@Service
public class CostServiceImpl implements CostService {

    /**
     * 假设之前总花费了100
     */
    private final Integer totalCost = 1000;

    @Override
    public Integer add(int cost) {
        Integer i = Integer.valueOf(RpcContext.getContext().getAttachment("cost"));
        return totalCost+cost+i;
    }
}
