package com.xdf.pojo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
    /**
     * mapRow:行映射器
     * rs不再是我们之前认为的整个结果集，而是一行数据
     * 当我们的结果集中有多条数据时，会反复执行mapRow();
     */
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        System.out.println("====================");
        Student student=new Student();
        student.setsId(rs.getInt("sid"));
        student.setAge(rs.getInt("age"));
        student.setsName(rs.getString("sname"));
        return student;
    }
}
