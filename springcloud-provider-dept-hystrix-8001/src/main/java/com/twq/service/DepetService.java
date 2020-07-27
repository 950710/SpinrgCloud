package com.twq.service;

import com.twq.pojo.Dept;

import java.util.List;

public interface DepetService {
    public boolean addDept(Dept dept);

    public Dept selectById(Long id);

    public List<Dept> selectAll();
}
