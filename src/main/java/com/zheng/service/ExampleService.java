package com.zheng.service;

import com.zheng.pojo.Example;

import java.util.List;

public interface ExampleService {

    List<Example> findExampleByWordId(int wordid);

    Example findExampleByExapid(int exapid);

    Example findMostHeatExample(int wordid);

    boolean addHeat(int heat,int exapid);


    boolean addExample(Example example);

    boolean deleteExample(int exapid);

    boolean editExample(Example example);


}
