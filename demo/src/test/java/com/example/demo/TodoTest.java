package com.example.demo;

import com.example.demo.model.Todo;
import com.example.demo.mapper.TodoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoTest {

    @Resource
    private TodoMapper todoMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<Todo> todoList = todoMapper.selectList(null);
        todoList.forEach(System.out::println);
    }

}
