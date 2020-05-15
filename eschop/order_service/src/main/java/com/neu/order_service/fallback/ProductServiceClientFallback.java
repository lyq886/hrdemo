package com.neu.order_service.fallback;

import com.neu.order_service.client.ProductServiceClient;
import com.neu.product_service.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
public class ProductServiceClientFallback implements ProductServiceClient {


    @Override
    public Product findById(Integer productId) {
        Product product = new Product();
        product.setName("id为的"+product+"商品库存不足");
        return product;
    }
}
