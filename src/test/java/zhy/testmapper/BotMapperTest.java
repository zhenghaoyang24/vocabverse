package zhy.testmapper;

import com.zheng.mapper.BookMapper;
import com.zheng.mapper.BotMapper;
import com.zheng.pojo.Bot;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class BotMapperTest {
    private BotMapper mapper;



    @Before
    public void before() throws IOException {
        //加载核心文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//true 自动提交事务
        mapper = sqlSession.getMapper(BotMapper.class);
    }

    @Test
    public void getBotById() {
        Bot xiezuo = mapper.getBotById("xiezuo");
        System.out.println(xiezuo);
    }

    @Test
    public void addBotUsed() {
        boolean b = mapper.addBotUsed("xiezuo");
        System.out.println(b);
    }


    @Test
    public void addLike() {
        boolean b = mapper.addLike("xiezuo");
        System.out.println(b);
    }

    @Test
    public void addDisLike() {
        boolean b = mapper.addDislike("xiezuo");
        System.out.println(b);
    }


}
