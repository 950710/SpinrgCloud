package com.twq.service.impl;

import com.twq.mapper.DeptMapper;
import com.twq.pojo.Dept;
import com.twq.service.DepetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl  implements DepetService {


    @Autowired
    private DeptMapper deptMapper;

    @Override
    public boolean addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public Dept selectById(Long id) {
        return deptMapper.selectById(id);
    }

    @Override
    public List<Dept> selectAll() {
        return deptMapper.selectAll();
    }
}
