package demo.dubbo.consumer.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import demo.dubbo.api.service.CostService;
import demo.dubbo.consumer.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    /**
     * 使用dubbo的注解 com.alibaba.dubbo.config.annotation.Reference。进行远程调用service
     */
    @Reference
    private CostService costService;

    @Override
    public Integer getCost(int a) {
        return costService.add(a);
    }
}
