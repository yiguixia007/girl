package com.imooc.controller;

import com.imooc.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/10/15 0015.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
//    @Value("${cupSize}")
//    private String cupSize;
//
//    @Value("${age}")
//    private Integer age;
//    //这里的简单类型也可以
//    //private int age;
//
//    @Value("${content}")
//    private String content;

    @Autowired
    private GirlProperties girlProperties;

    @GetMapping(value = "/say")
    public String sayHello(@RequestParam(value="id",required = false,defaultValue = "0") Integer id){
        System.out.println("第一天的代码");
        System.out.println("第一天的代码");
        System.out.println("完成feature_001的部分代码");
        System.out.println("完成feature_001的剩余代码");
        return "id: "+id;
    } 
}
