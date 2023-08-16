import com.itbaizhan.mapper.TeacherMapper;
import com.itbaizhan.pojo.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestTeacherMapper {
    InputStream is = null;
    SqlSession session = null;
    TeacherMapper teacherMapper = null;
    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        session = factory.openSession();
        teacherMapper = session.getMapper(TeacherMapper.class);
    }

    @After
    public void after() throws IOException{
        session.close();
        is.close();
    }

    @Test
    public void testFindAll(){
        List<Teacher> all = teacherMapper.findAll();
        all.forEach(System.out::println);
    }

    /**
     * 特殊字符处理
     */
    @Test
    public void testFindById(){
        List<Teacher> teachers = teacherMapper.findById(4);
        teachers.forEach(System.out::println);
    }
}
