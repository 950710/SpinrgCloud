package com.twq.controller;

import com.twq.pojo.Dept;
import com.twq.service.DepetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DepetService depetService;
    @Autowired
    private DiscoveryClient client;

    @PostMapping("/add")
    public boolean addDept(Dept dept){
        return depetService.addDept(dept);
    }

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return depetService.selectById(id);
    }

    @GetMapping("/list")
    public List<Dept> getAll(){
        return depetService.selectAll();
    }


    //查看Eureka下的所有微服务中指定的微服务信息
    @GetMapping("/discovery")
    public Object discovery(){
        //获取微服务列表的清单
        List<String> services= client.getServices();
        System.out.println("discovery=>services:"+services);

        //得到一个具体的微服务信息，通过具体的微服务id：applicationName；
        List<ServiceInstance> instances = client.getInstances("SPINGCLOUD-PROVIDER-DEPT");
            for(ServiceInstance instance : instances){
                System.out.println(
                        instance.getHost()+"\t"+
                        instance.getPort()+"\t"+
                        instance.getUri()+"\t"+
                        instance.getServiceId()
                );
            }
        return this.client;
    }
}
