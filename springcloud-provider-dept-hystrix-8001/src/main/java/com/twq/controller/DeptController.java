package com.twq.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.twq.pojo.Dept;
import com.twq.service.DepetService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DepetService depetService;

    @GetMapping("get/{id}")
    @HystrixCommand(fallbackMethod="htstrixGet")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = depetService.selectById(id);
            if(dept == null){
                throw new RuntimeException("id=>"+id+",不存在该用户，或者信息无法找到~");
            }
        return dept;
    }
    //备选方法
    public Dept htstrixGet(@PathVariable("id") Long id){
        return new Dept()
                .setDeptno(id)
                .setDname("id=>"+id+"没有对应信息，null--@Hystrix")
                .setDb_source("no this database in MySQL");
    }
}
