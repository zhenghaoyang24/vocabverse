package zhy.testmapper;

import com.zheng.mapper.ExampleMapper;
import com.zheng.mapper.VocabularyMapper;
import com.zheng.pojo.Example;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestExampleMapper {
    private ExampleMapper mapper;


    @Before
    public void before() throws IOException {
        //加载核心文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//true 自动提交事务
        mapper = sqlSession.getMapper(ExampleMapper.class);
    }
    @Test
    public void addExample() {
        Example addExample = new Example();
        addExample.setWordid(1);
        addExample.setEn("a");
        addExample.setCn("啊");
        addExample.setHolderid(1000);
        addExample.setHeat(0);
        addExample.setAdddate("2024-1-1");
        System.out.println(addExample);
        boolean b = mapper.addExample(addExample);

    }

    @Test
    public void deleteExample() {
        boolean b = mapper.deleteExample(141739);
    }

    @Test
    public void editExample() {
        Example example = new Example();
        example.setExapid(141752);
        example.setEn("aaaaaaa");
        example.setCn("啊啊啊啊");
        boolean b = mapper.editExample(example);
    }


    @Test
    public void findExampleByExapid() {

        Example example = mapper.findExampleByExapid(1);
        System.out.println(example);
    }
}

