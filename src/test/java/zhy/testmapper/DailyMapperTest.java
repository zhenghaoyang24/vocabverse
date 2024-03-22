package zhy.testmapper;

import com.zheng.mapper.BookMapper;
import com.zheng.mapper.DailyMapper;
import com.zheng.pojo.Daily;
import com.zheng.pojo.UserBook;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DailyMapperTest {

    private DailyMapper mapper;


    @Before
    public void before() throws IOException {
        //加载核心文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//true 自动提交事务
        mapper = sqlSession.getMapper(DailyMapper.class);
    }


    @Test
    public void getDailyByUseridAndTime(){
        Daily daily = mapper.getDailyByUseridAndTime(1000, "2024-1-24");
        System.out.println(daily);
    }

    @Test
    public void creatDaily() {
        Daily daily1 = new Daily();
        daily1.setUserid(1000);
        daily1.setTime("2024-1-24");
        daily1.setCheckin(0);
        daily1.setSearchedword(0);
        daily1.setStudytime(0);
        daily1.setStudyword(0);
        boolean b = mapper.creatDaily(daily1);
        System.out.println(b);
    }
}
