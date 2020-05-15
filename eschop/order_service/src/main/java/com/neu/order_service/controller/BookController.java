package com.neu.order_service.controller;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.order_service.domain.Book;
import com.neu.order_service.domain.BookDetail;
import com.neu.order_service.service.BookService;
import com.neu.order_service.utils.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("books")
public class BookController {

    @Autowired
    BookService bookService;


    @PostMapping("{id}")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "addFallback")  //当add方法出现错误时候,调用addFallback方法返回预期数据
    //hystrix的默认超时时间是1s
    public JsonModel add(@PathVariable("id") int id){

       // System.out.println(0 / id);
        //id==0 模拟熔断
        //id=!0

        JsonModel jsonModel = new JsonModel();
        //模拟下单(下单参数)
           //页面
               //商品的id和对应的数量

        Book book = new Book();

        BookDetail bookDetail = new BookDetail();
        bookDetail.setProductId(1);
        bookDetail.setProductCount(10);

        book.getBookDetails().add(bookDetail);


        jsonModel.setSuccess(bookService.add(book)==1);//商品服务下游线程休眠2s
        jsonModel.setMsg(jsonModel.isSuccess()?"下单成功":"下单失败");
        return jsonModel;
    }

    public JsonModel addFallback(@PathVariable("id") int id){
        JsonModel jsonModel = new JsonModel();
        jsonModel.setSuccess(false);
        jsonModel.setMsg("熔断开启,因为被除数为"+id);
        return jsonModel;
    }


}
