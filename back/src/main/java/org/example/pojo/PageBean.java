package org.example.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author zhansang
 * @date 2023/8/8
 * @javaSE
 */
@Data
public class PageBean {
    private List<Student> list;
    private Integer totals;

    public PageBean(List<Student> students, Integer totals) {
        this.list = students;
        this.totals = totals;
    }
}
