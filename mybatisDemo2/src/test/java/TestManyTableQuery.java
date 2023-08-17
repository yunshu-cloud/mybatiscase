import com.itbaizhan.mapper.ClassesMapper;
import com.itbaizhan.mapper.StudentMapper;
import com.itbaizhan.mapper.TeacherMapper;
import com.itbaizhan.mapper2.ClassesMapper2;
import com.itbaizhan.mapper2.StudentMapper2;
import com.itbaizhan.pojo.Classes;
import com.itbaizhan.pojo.Student;

import com.itbaizhan.pojo.Teacher2;
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

/**
 * 利用junit前置后置方法优化测试方法
 */
public class TestManyTableQuery {
    InputStream is = null;
    SqlSession session = null;
    StudentMapper studentMapper = null;
    ClassesMapper classesMapper = null;
    TeacherMapper teacherMapper = null;
    @Before
    public void init() throws IOException {
         is = Resources.getResourceAsStream("SqlMapConfig.xml");
         SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
         SqlSessionFactory factory = builder.build(is);
         session = factory.openSession();
         studentMapper = session.getMapper(StudentMapper.class);
         classesMapper = session.getMapper(ClassesMapper.class);
         teacherMapper = session.getMapper(TeacherMapper.class);
    }
    @After
    public void after() throws IOException {
        session.close();
        is.close();
    }

    @Test
    public void testFindAllStudent() throws IOException {
        List<Student> all = studentMapper.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void testFindAllClasses(){
        List<Classes> all = classesMapper.findAll();
        all.forEach(System.out::println);
    }


    @Test
    public void testFindAllTeacher(){
        List<Teacher2> all = teacherMapper.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void testFindAllClasses2(){
        ClassesMapper2 classesMapper2 = session.getMapper(ClassesMapper2.class);
        List<Classes> all = classesMapper2.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void testFindAllStudent2(){
        StudentMapper2 studentMapper2 = session.getMapper(StudentMapper2.class);
        List<Student> allStudent = studentMapper2.findAllStudent();
        allStudent.forEach(System.out::println);
    }
}
