//package com.bubble.consumer.controller;
//
//import com.bubble.service.HelloService;
//import org.apache.dubbo.config.annotation.Reference;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * Hello服务
// *
// * @author wugang
// * date: 2019-08-16 11:09
// **/
//@RestController
//@RequestMapping("/test")
//public class HelloController {
//
//    @Reference(version = "${demo.service.version}",
//            application = "${dubbo.application.id}",
//            registry = "${dubbo.registry.id}")
//    private HelloService helloService;
//
//    @GetMapping("/hello")
//    public String hello(@RequestParam String name) {
//        String result = helloService.sayHello(name);
//        System.out.println("result: " + result);
//        return result;
//    }
//
//}
