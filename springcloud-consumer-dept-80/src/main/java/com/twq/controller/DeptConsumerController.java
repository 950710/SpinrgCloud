package com.twq.controller;

import com.twq.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
        //消费者，不应该有service层
        //RestTemplate  供我们消费者直接调用
        //（Url，实体：map，Class<T> responseType）

    @Autowired
    private RestTemplate restTemplate;


    //private static final String REST_URL_PRRFIX="http://localhost:8001";
    //Ribbon。我们这里的地址，应该是一个变量，通过服务名来访问
    private static final String REST_URL_PRRFIX="http://SPINGCLOUD-PROVIDER-DEPT";

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PRRFIX+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PRRFIX+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept>  list(){
        return restTemplate.getForObject(REST_URL_PRRFIX+"/dept/list",List.class);
    }

}
