package com.karadyauran.agile.controller.page;

import com.karadyauran.agile.entity.Task;
import com.karadyauran.agile.service.interf.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController
{
    private final TaskService taskService;

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable("id") String id)
    {
        System.out.println(taskService.getTaskById(id));
        return taskService.getTaskById(id);
    }
}
