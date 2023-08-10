package org.example;

import com.google.gson.Gson;
import org.example.mapper.StudentMapper;
import org.example.pojo.PageBean;
import org.example.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author zhansang
 * @date 2023/7/14
 * @javaSE
 */
@CrossOrigin(origins = {"*","null"})//解决网站跨域
@RestController//请求类
public class Controller {
    @Autowired//依赖注入
    private StudentMapper studentMapper;
    private Gson gson = new Gson();//转换变量

    @GetMapping("/students")//查询
    public String getStudents(){
        List<Student> students = studentMapper.selectList(null);
        Integer totals = getTotal();
        PageBean pageBean = new PageBean(students,totals);
        return gson.toJson(pageBean);
    }
//    @GetMapping("/students")//查询
//    public String getStudents(){
//        List<Student> students = studentMapper.selectList(null);
//        return gson.toJson(students);
//    }

    /**
     * 查询全部员工总数
     * @return
     */
//    @GetMapping("/total")
    public int getTotal(){
        Integer total = studentMapper.getTotal();
        return total;
    }

    @PostMapping("/add")//增
    public void addStudent(@RequestBody Student student){
        studentMapper.insert(student);
    }

    @PostMapping("/delete")//删
    public void removeStudents(@RequestBody Student student){
        studentMapper.deleteById(student);
    }

    @PostMapping("/update")//改
    public void udpateStudents(@RequestBody Student student){
        studentMapper.updateById(student);
    }
}
