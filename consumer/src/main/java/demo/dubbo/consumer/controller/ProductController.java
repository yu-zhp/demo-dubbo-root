package demo.dubbo.consumer.controller;

import com.alibaba.dubbo.rpc.RpcContext;
import demo.dubbo.consumer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 添加完 返回总共消费
     * @param a
     * @return
     */
    @RequestMapping("/add")
    public String getCost(int a){
        RpcContext.getContext();
        return "该产品总共消费 ："+productService.getCost(a);
    }

}
