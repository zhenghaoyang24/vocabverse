package zhy.testmapper;

import com.zheng.mapper.BookMapper;
import com.zheng.mapper.ExampleMapper;
import com.zheng.pojo.Example;
import com.zheng.pojo.UserBook;
import com.zheng.pojo.VocBook;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BookMapperTest {

    private BookMapper mapper;


    @Before
    public void before() throws IOException {
        //加载核心文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//true 自动提交事务
        mapper = sqlSession.getMapper(BookMapper.class);
    }

    @Test
    public void allMyUserBooks() {
        List<UserBook> userBooks = mapper.allMyUserBooks(1000);
        System.out.println(userBooks);
    }

    @Test
    public void addUserBookVocCount() {
        mapper.addUserBookVocCount(14);
    }

    @Test
    public void addUserBook() {
        UserBook userBook = new UserBook();
        userBook.setHolderid(1000);
        userBook.setCreattime("2024-1-11");
        userBook.setShare(0);
        userBook.setUserbookname("考研常用");
        userBook.setVoccount(0);
        userBook.setBookdescribe("哈哈哈");
        mapper.addUserBookMapper(userBook);
    }

    @Test
    public void addWordToUserBook() {
        boolean b = mapper.addWordToUserBook(100367, 14);
        System.out.println(b);

    }

    @Test
    public void judgeTheWordInTheBook() {
        VocBook vocBook = mapper.judgeTheWordInTheBook(31093, 14);
        System.out.println(vocBook);
    }

    @Test
    public void theBookOfAllWords() {
        List<VocBook> vocBooks = mapper.theBookOfAllWords(14);
        System.out.println(vocBooks);
    }

    @Test
    public void deleteWordFromUserBookMapper() {
        boolean b = mapper.deleteWordFromUserBookMapper(22542, 14);
        System.out.println(b);
    }


}
