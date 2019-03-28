package springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springcloud.service.Test1Service;

@RestController
public class TestController {
    @Autowired
    private Test1Service test1Service;


    @RequestMapping(value="/get",method= RequestMethod.GET)
    public String get(){

        return test1Service.get();
    }
    @RequestMapping(value = "/getting/{a}",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public String getting(@PathVariable("a") int a){
        System.out.println("11111");
        if (a==1){
            return "成功";
        }else {
            throw new RuntimeException("该ID:"+a+"没有对应的信息");
        }
    }
    public String processHystrix_Get(@PathVariable("a") int a)
    {
        return "找不到该记录";
    }
}