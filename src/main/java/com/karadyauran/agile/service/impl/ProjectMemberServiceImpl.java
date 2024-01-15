package com.karadyauran.agile.service.impl;

import com.karadyauran.agile.entity.ProjectMember;
import com.karadyauran.agile.repository.ProjectMemberRepository;
import com.karadyauran.agile.service.interf.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjectMemberServiceImpl implements ProjectMemberService
{
    private final ProjectMemberRepository projectMemberrepository;

    @Override
    public ProjectMember getProjectMemberById(String id)
    {
        return projectMemberrepository.findProjectMemberByProjectMemberId(UUID.fromString(id));
    }
}
