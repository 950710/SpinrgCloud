package com.twq.mapper;

import com.twq.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptMapper {

    public boolean addDept(Dept dept);

    public Dept selectById(Long id);

    public List<Dept>  selectAll();

}
