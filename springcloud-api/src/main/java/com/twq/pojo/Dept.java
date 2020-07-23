package com.twq.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor//无参构造方法
@Accessors(chain = true) //链式写法
public class Dept implements Serializable {

    private Long deptno;//主键
    private String dname;
    //这个数据看存在哪个数据库中（同一个信息存在不同的数据库）
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }


    /*
        链式写法
    Dept dept = new Dept();

    dept.setDeptno(11).setDname('1111').setDb_source('sss');*/
}
