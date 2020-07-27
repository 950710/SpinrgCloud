package com.twq.service;

import com.twq.pojo.Dept;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Component
@FeignClient(value = "SPINGCLOUD-PROVIDER-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
    @GetMapping("/dept/add")
    public boolean addDept(Dept dept);
    @GetMapping("/dept/get/{id}")
    public Dept selectById(@PathVariable("id") Long id);
    @GetMapping("/dept/list")
    public List<Dept> selectAll();
}
