package com.xdf.dao;

import com.xdf.pojo.Student;
import com.xdf.pojo.StudentMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * JdbcDaoSupport
 *  01.DataSource  数据源
 *  02.JdbcTemplate  增删改查的模版
 */
public class StudentDaoImpl extends JdbcDaoSupport implements StudentDao{
    @Override
    public int add(Student student) {
        String sql="insert into student(sname,age) values (?,?)";
        return getJdbcTemplate().update(sql,student.getsName(),student.getAge());
    }

    @Override
    public int delete(Serializable id) {
        String sql="delete from student where sid=?";
        return getJdbcTemplate().update(sql,id);
    }

    @Override
    public int update(Student student) {
        String sql="update student  set sname=? where sid=?";
        return getJdbcTemplate().update(sql,student.getsName(),student.getsId());
    }

  /*  @Override
    public List<Student> findAllList() {
        String sql="select sid,sname,age from student";
        return getJdbcTemplate().query(sql,new StudentMapper());
    }*/


    @Override
    public List<Student> findAllList() {
        String sql="select sid,sname,age from student";
        return getJdbcTemplate().query(sql, new RowMapper<Student>() {   //匿名内部类
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                System.out.println("====================");
                Student student=new Student();
                student.setsId(rs.getInt("sid"));
                student.setAge(rs.getInt("age"));
                student.setsName(rs.getString("sname"));
                return student;
            }
        });
    }
}
