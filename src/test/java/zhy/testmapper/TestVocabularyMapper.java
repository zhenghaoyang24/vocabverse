package zhy.testmapper;

import com.zheng.mapper.VocabularyMapper;
import com.zheng.pojo.SearchWordHistory;
import com.zheng.pojo.Word;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestVocabularyMapper {

    private VocabularyMapper mapper;



    //抽取
    @Before
    public void before() throws IOException {
        //加载核心文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//true 自动提交事务
        mapper = sqlSession.getMapper(VocabularyMapper.class);
    }

    @Test
    public void findByLetterEn() {
        List<Word> wordList = mapper.findByLetterEn("activ");
        for (Word word:wordList){
            System.out.println(word.getSpelling());
        }
    }

    @Test
    public void findByLetterCn() {
        List<Word> wordList = mapper.findByLetterCn("漂亮");
        for (Word word:wordList){
            System.out.println(word.getSpelling());
        }
    }

    @Test
    public void findWordById() {
        Word wordById = mapper.findWordById(12);
        System.out.println(wordById);
    }

    @Test
    public void addSearchTimes() {
        boolean b = mapper.addSearchTimes(1);
        System.out.println(b);
    }

    @Test
    public void addHistory() {
        SearchWordHistory searchHistory = new SearchWordHistory();
        searchHistory.setWordid(3);
        searchHistory.setUserid(1);
        searchHistory.setSpelling("a");
        boolean b = mapper.addSearchedWordHistory(searchHistory);
        System.out.println(b);
    }

    @Test
    public void judgSearchWordHistory() {
        SearchWordHistory searchWordHistory = mapper.judgSearchWordHistory(2, 1);
        System.out.println(searchWordHistory);
    }

    @Test
    public void getAllSearchWordHistory() {
        List<SearchWordHistory> history = mapper.getAllSearchWordHistory(1);
        System.out.println(history);
    }

    @Test
    public void deleteSearchWordHistory() {
        boolean b = mapper.deleteSearchWordHistory(1, 1);
    }

    @Test
    public void getWordsSearchTimesRank() {
        List<Word> wordsSearchTimesRank = mapper.getWordsSearchTimesRank();
        System.out.println(wordsSearchTimesRank);
    }









}
