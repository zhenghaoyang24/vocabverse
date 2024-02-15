package zhy.testmapper;

import com.zheng.mapper.ExampleMapper;
import com.zheng.mapper.StudyWordMapper;
import com.zheng.pojo.StudyWord;
import com.zheng.pojo.StudyWordRemenberHistory;
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

public class TestStudyWord {

    private StudyWordMapper mapper;


    @Before
    public void before() throws IOException {
        //加载核心文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//true 自动提交事务
        mapper = sqlSession.getMapper(StudyWordMapper.class);
    }

    @Test
    public void getStudyWordById() {
        StudyWord word = mapper.getStudyWordInformationById(4637, 1000);
        System.out.println(word);
    }

    @Test
    public void getStudyWordRemenberHistory() {
        List<StudyWordRemenberHistory> studyWordRemenberHistory = mapper.getStudyWordRememberHistory(4637, 1000);
        System.out.println(studyWordRemenberHistory);
    }




}
