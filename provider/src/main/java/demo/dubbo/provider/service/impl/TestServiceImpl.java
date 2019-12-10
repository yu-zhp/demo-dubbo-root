package demo.dubbo.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import demo.dubbo.api.service.TestService;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public void add(String add) {
        return;
    }
}
