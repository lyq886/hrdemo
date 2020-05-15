package com.neu.order_service.service.impl;

import com.neu.order_service.dao.BookDao;
import com.neu.order_service.domain.Book;
import com.neu.order_service.domain.BookDetail;
import com.neu.order_service.service.BookService;
import com.neu.product_service.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;

    @Autowired
    RestTemplate restTemplate;
    @Override
    public int add(Book book) {

        //思路
            //要保存订单
            //要保存订单明细

       List<BookDetail> bookDetails =  book.getBookDetails();
       for(BookDetail bookDetail : bookDetails){

           //要根据商品的id获取商品的其他信息【比如:价钱、名称......】

           int productId= bookDetail.getProductId();
           //调用商品服务
           //采用Ribbon
           //TODO

           String URL = "http://product-service/products/"+productId;
           Product product = restTemplate.getForObject(URL, Product.class);

           System.out.println(product.getName()+"---------");

           if(true){
               return 1;
           }
       }

        return bookDao.add(book);
    }
}
