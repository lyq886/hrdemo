package com.neu.order_service.client;

import com.neu.order_service.fallback.ProductServiceClientFallback;
import com.neu.product_service.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Feign接口
 *    注意:
 *       接口的方法什么要和对应控制器的方法声明保持一致
 */
@FeignClient(name = "product-service",fallback = ProductServiceClientFallback.class)
//name的值是服务提供方的应用名字
public interface ProductServiceClient {

    //注意点
       //这里的方法什么要和对应控制器的方法声明保持一致
       //如下规则
/*       1、路径
	2、Http方法必须对应
	3、使用requestBody，应该使用@PostMapping
	4、多个参数的时候，通过@RequestParam（"id") int id)方式调用
5、使用路径传递参数是,通过@PathVariable(“id”) int id方式调用
6、使用RequestMethod(method=get|post)注解*/


    @RequestMapping(value="products/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Product findById(@PathVariable("id") Integer productId);
}
