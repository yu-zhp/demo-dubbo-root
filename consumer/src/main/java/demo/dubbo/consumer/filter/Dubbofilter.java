package demo.dubbo.consumer.filter;


import com.alibaba.dubbo.rpc.*;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class Dubbofilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String traceId = UUID.randomUUID().toString().replace("-", "");
        String rpcName = invocation.getInvoker().getInterface() + "." + invocation.getMethodName();
        log.info("traceId={} >>> InterfaceName={} , Parameter={}", traceId, rpcName, JSON.toJSONString(invocation.getArguments()));
        System.out.println("==========================================================================================");
        //执行rpc接口
        long startTime = System.currentTimeMillis();
        Result result = invoker.invoke(invocation);
        log.info("RPC invoke");
        long elapsed = System.currentTimeMillis() - startTime;
        if (result.hasException() && invoker.getInterface() != GenericService.class) {
            log.error("traceId={} InterfaceName={} dubbo执行异常: {}", traceId, rpcName, result.getException());
        } else {
            log.info("traceId={} >>> InterfaceName={} , Resposne={} , SpendTime={} ms", traceId, rpcName, JSON.toJSONString(new Object[]{result.getValue()}), elapsed);
        }
//        RpcContext.getContext();


        return result;
    }
}
