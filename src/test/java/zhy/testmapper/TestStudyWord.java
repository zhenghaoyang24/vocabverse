package zhy.testmapper;

import com.zheng.mapper.StudyWordMapper;
import com.zheng.pojo.StudyWord;
import com.zheng.pojo.StudyWordRememberHistory;
import com.zheng.utils.GetDateUtil;
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
        List<StudyWordRememberHistory> studyWordRemenberHistory = mapper.getStudyWordRememberHistory(4637, 1000);
        System.out.println(studyWordRemenberHistory);
    }

    @Test
    public void addStudyWordMapper() {
        String nowData = GetDateUtil.getNowData();
        boolean b = mapper.addStudyWordMapper(1000, 4637, nowData, nowData);
        System.out.println(b);
    }

    @Test
    public void deleteStudyMapper() {
        boolean b = mapper.deleteStudyWordMapper(1000, 66327);
        System.out.println(b);
    }

    @Test
    public void deleteStudyWordRemenberHistory() {
        boolean b = mapper.deleteStudyWordRemenberHistory(1000, 2);
        System.out.println(b);
    }

    @Test
    public void getTodayStudyWords() {
        StudyWord studyWords = mapper.getTodayStudyWord(1000, "2024-2-24");
        System.out.println(studyWords);
    }


    @Test
    public void getTodayStudyWordsCount() {
        int c= mapper.getTodayStudyWordsCount(1000, "2024-2-28");
        System.out.println(c);
    }

    @Test
    public void addStudyWordRemenberHistory() {
        StudyWordRememberHistory studyWordRemenberHistory = new StudyWordRememberHistory();
        studyWordRemenberHistory.setUserid(1000);
        studyWordRemenberHistory.setWordid(4637);
        studyWordRemenberHistory.setOpt(3);
        studyWordRemenberHistory.setSelectdate("2024-2-29");
        boolean b = mapper.addStudyWordRememberHistory(studyWordRemenberHistory);
        System.out.println(b);
    }

    @Test
    public void updateStudyWordInformation() {
        StudyWord studyWord = mapper.getStudyWordInformationById(49586, 1000);
        studyWord.setDay_q_0(1);
        System.out.println(studyWord);
        boolean b = mapper.updateStudyWordInformation(studyWord);
    }





}
