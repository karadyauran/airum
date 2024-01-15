package com.karadyauran.agile.controller.page;

import com.karadyauran.agile.entity.Project;
import com.karadyauran.agile.service.interf.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
@RequiredArgsConstructor
public class ProjectController
{
    private final ProjectService projectService;

    @GetMapping("/id={id}")
    public Project getProjectById(@PathVariable String id)
    {
        return projectService.getProjectById(id);
    }
}
