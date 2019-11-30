package com.alix.orm.demo1.application.controller;

import com.alix.orm.demo1.common.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨安星(Alix)
 * @create 2019-11-25 17:16
 */
@RestController
public class TestController {

    @Autowired
    private  RedisUtil redisUtil;

    @RequestMapping("/test")
    public String test(){
        redisUtil.set("key1","yanganxing111");
        return (String) redisUtil.get("key1");
    }
}
