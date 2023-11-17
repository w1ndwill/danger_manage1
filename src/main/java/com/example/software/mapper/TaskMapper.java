package com.example.software.mapper;

import com.example.software.bean.Official;
import com.example.software.bean.Task;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TaskMapper {
    List<Task> getAllTasks();

    List<Official> getAllofficial();
//    @Delete(" DELETE FROM task WHERE number = #{number}")
    void deleteTask(Task task);
    void updateTask(Task task);
    void addTask(Task task);
}
