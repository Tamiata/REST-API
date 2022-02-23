package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/task")

public class TaskController {

    private final DbService service;
    private final TaskMapper taskMapper;
    private Long taskId;

    @Autowired
    public TaskController(DbService service, TaskMapper taskMapper) {
        this.service = service;
        this.taskMapper = taskMapper;
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    public List<TaskDto> getTasks() {
        List<Task> tasks = service.getAllTasks();
        return taskMapper.mapToTaskDtoList(tasks);
    }

    @GetMapping(value = "getTask/{taskId}")
    public TaskDto getTask(Long taskId) {
        Optional<Task> task = service.getTask(taskId);
        return taskMapper.mapToTaskDto(task.get());
    }

    @DeleteMapping(value = "deleteTask")
    public void deleteTask(Long taskId) {
    }

    @PutMapping(value = "updateTask")
    public TaskDto updateTask(TaskDto task) {
        return new TaskDto(2L, "Edited test title2", "Test content2");
    }

    @PostMapping(value = "createTask")
    public void createTask(TaskDto task) {
    }

    @PostMapping(value = "copyTask")
    public String copyTask(Long fromTaskId, Long toTaskId) {
        return "copyTask method test: fromTaskId, toTaskId";
    }

    @PutMapping(value = "moveTask")
    public String moveTask(Long taskIdFrom, Long newTaskId) {
        return "moveTask method test: taskIdFrom, taskIdTo";
    }

    @DeleteMapping(value = "batchDeleteTask")
    public String batchDeleteTask(Long setStart, Long setEnd) {
        return"batchDeleteTask method test";
    }

}
