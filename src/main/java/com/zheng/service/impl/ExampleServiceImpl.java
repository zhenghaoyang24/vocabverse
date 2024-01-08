package com.zheng.service.impl;

import com.zheng.mapper.ExampleMapper;
import com.zheng.pojo.Example;
import com.zheng.service.ExampleService;
import com.zheng.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleServiceImpl implements ExampleService {

    static SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public List<Example> findExampleByWordId(int wordid) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ExampleMapper mapper = sqlSession.getMapper(ExampleMapper.class);
        List<Example> exampleList = mapper.findExampleByWordId(wordid);
        sqlSession.close();
        return exampleList;
    }

    @Override
    public boolean addHeat(int heat, int exapid) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ExampleMapper mapper = sqlSession.getMapper(ExampleMapper.class);
        boolean b = mapper.addHeat(heat, exapid);
        sqlSession.close();
        return b;
    }

    @Override
    public boolean addExample(Example example) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ExampleMapper mapper = sqlSession.getMapper(ExampleMapper.class);
        boolean b = mapper.addExample(example);
        sqlSession.close();
        return b;
    }

    @Override
    public boolean deleteExample(int exapid) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ExampleMapper mapper = sqlSession.getMapper(ExampleMapper.class);
        boolean b = mapper.deleteExample(exapid);
        sqlSession.close();
        return b;
    }

    @Override
    public boolean editExample(Example example) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ExampleMapper mapper = sqlSession.getMapper(ExampleMapper.class);
        boolean b = mapper.editExample(example);
        sqlSession.close();
        return b;
    }


//    @Override
//    public boolean editExample() {
//        Example example = new Example();
//        example.setHolderid(141752);
//        example.setEn("aaaaaaa");
//        example.setCn("啊啊啊啊啊啊啊");
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        ExampleMapper mapper = sqlSession.getMapper(ExampleMapper.class);
//        boolean b = mapper.editExample(example);
//        return  b;
//    }
}
