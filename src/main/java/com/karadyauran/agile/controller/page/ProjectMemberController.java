package com.karadyauran.agile.controller.page;

import com.karadyauran.agile.entity.ProjectMember;
import com.karadyauran.agile.service.interf.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project-member")
@RequiredArgsConstructor
public class ProjectMemberController
{
    private final ProjectMemberService projectMemberService;

    @GetMapping("/id={id}")
    public ProjectMember getProjectMemberById(@PathVariable String id)
    {
        return projectMemberService.getProjectMemberById(id);
    }
}
