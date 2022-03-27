package com.skycloud.refactor.proxy;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.skycloud.refactor.proxy.pojo.User;

public class MybatisTest {
    //通过Id查询一个用户
    @Test
    public void testSearchById() throws IOException {
        //1.读取配置文件 
        InputStream in = Resources.getResourceAsStream("mybatisConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();
        //4.执行Sql语句
        User user = session.selectOne("test.findUserById", 1);
        //5. 打印结果
        System.out.println(user);
        //6.释放资源
        session.close();
        in.close();
    }
    
    @Test
    public void testAssignable(){
    	class A{}
    	class B extends A{}
    	
    	A a = new A();
        B b = new B();
        A ba = new B();
        System.out.println("1-------------");
        System.out.println(A.class.isAssignableFrom(a.getClass()));
        System.out.println(B.class.isAssignableFrom(b.getClass()));
        System.out.println(A.class.isAssignableFrom(b.getClass()));
        System.out.println(B.class.isAssignableFrom(a.getClass()));
        System.out.println(A.class.isAssignableFrom(ba.getClass()));
        System.out.println(B.class.isAssignableFrom(ba.getClass()));
        System.out.println("2-------------");
        System.out.println(a.getClass().isAssignableFrom(A.class));
        System.out.println(b.getClass().isAssignableFrom(B.class));
        System.out.println(a.getClass().isAssignableFrom(B.class));
        System.out.println(b.getClass().isAssignableFrom(A.class));
        System.out.println(ba.getClass().isAssignableFrom(A.class));
        System.out.println(ba.getClass().isAssignableFrom(B.class));
        System.out.println("3-------------");
        System.out.println(Object.class.isAssignableFrom(b.getClass()));
        System.out.println(Object.class.isAssignableFrom("abc".getClass()));
        System.out.println("4-------------");
        System.out.println("a".getClass().isAssignableFrom(Object.class));
        System.out.println("abc".getClass().isAssignableFrom(Object.class));
    }

    //根据用户名模糊查询用户列表
    @Test
    public void testFindUserByUsername() throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("mybatisConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();
        //4.执行Sql语句
        List<User> list = session.selectList("test.findUserByUsername", "小强");
        //5. 打印结果
        for (User user:list) {
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();
    }
    
    //根据用户名模糊查询用户列表
    @Test
    public void testFindUserByMapper() throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("mybatisConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();
        //4.执行Sql语句
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> list = mapper.select();
        //5. 打印结果
        for (User user:list) {
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();
    }

    //添加用户
    @Test
    public void testInsertUser() throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("mybatisConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.执行Sql语句
        User user = new User();
        user.setUsername("小强");
        user.setBirthday(new Date());
        user.setAddress("sadfsafsafs");
        user.setSex("2");
        int i = sqlSession.insert("test.insertUser", user);
        sqlSession.commit();
        //5. 打印结果
        // 刚保存用户，此时用户ID需要返回。执行完上面insert程序后，此时就能知道用户的ID是多少
        // 需要在User.xml文件中配置
        System.out.println("插入id:"+user.getId());//插入id:30

        //6.释放资源
        sqlSession.close();
        in.close();
    }
    //更新用户
    @Test
    public void testUpdateUserById() throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("mybatisConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.执行Sql语句
        User user = new User();
        user.setId(2);
        user.setUsername("小小");
        user.setBirthday(new Date());
        user.setAddress("西安市");
        user.setSex("1");
        int i = sqlSession.insert("test.updateUserById", user);
        sqlSession.commit();
        //5. 打印结果
        System.out.println(user.getId());
        //6.释放资源
        sqlSession.close();
        in.close();
    }
    //删除用户
    @Test
    public void testDeleteUserById() throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("mybatisConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.执行Sql语句
        int i = sqlSession.insert("test.deleteUserById", 1);
        sqlSession.commit();
        //5. 打印结果
        System.out.println(i);
        //6.释放资源
        sqlSession.close();
        in.close();
    }
}
