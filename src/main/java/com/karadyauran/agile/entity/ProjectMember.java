package com.karadyauran.agile.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Objects;


@Entity
@Table(name = "project_members")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectMember
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "pm_project_member_id")
    private UUID projectMemberId;

    @Column(name = "pm_user_id", insertable = false, updatable = false)
    private UUID userId;

    @Column(name = "pm_role_id", insertable = false, updatable = false)
    private UUID roleId;

    @Column(name = "pm_created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "pm_updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference("projectMemberUserReference")
    @JoinColumn(name = "pm_user_id", referencedColumnName = "u_user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "pm_role_id", referencedColumnName = "r_role_id")
    private Role role;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectMember that = (ProjectMember) o;
        return Objects.equals(projectMemberId, that.projectMemberId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(projectMemberId);
    }

    @Override
    public String toString()
    {
        return String.format("ProjectMember: %s",
                userId);
    }
}
