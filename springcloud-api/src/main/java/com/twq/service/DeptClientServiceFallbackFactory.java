package com.twq.service;

import com.twq.pojo.Dept;
import feign.hystrix.FallbackFactory;

import java.util.List;

public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public Dept selectById(Long id) {
                return new Dept().setDeptno(id).setDname("id"+id+"没有对应信息，客户端提供了降级的信息，这个服务已经被关闭~").setDb_source("没有数据~");
            }

            @Override
            public List<Dept> selectAll() {
                return null;
            }
        };
    }
}
