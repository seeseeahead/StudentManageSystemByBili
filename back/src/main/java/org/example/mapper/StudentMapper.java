package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Student;
import org.springframework.stereotype.Component;

/**
 * @author zhansang
 * @date 2023/7/14
 * @javaSE
 */
@Component//添加到ioc
public interface StudentMapper extends BaseMapper<Student> {

    @Select("select count(*) from student;")
    Integer getTotal();
}
