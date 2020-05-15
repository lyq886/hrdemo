package com.neu.order_service.controller;

import com.neu.order_service.domain.Book;
import com.neu.order_service.domain.BookDetail;
import com.neu.order_service.service.BookService;
import com.neu.order_service.utils.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("books")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping
    @ResponseBody
    public JsonModel add(){
        JsonModel jsonModel = new JsonModel();
        //模拟下单(下单参数)
           //页面
               //商品的id和对应的数量

        Book book = new Book();

        BookDetail bookDetail = new BookDetail();
        bookDetail.setProductId(1);
        bookDetail.setProductCount(10);

        book.getBookDetails().add(bookDetail);



        jsonModel.setSuccess(bookService.add(book)==1);
        jsonModel.setMsg(jsonModel.isSuccess()?"下单成功":"下单失败");
        return jsonModel;
    }

}
