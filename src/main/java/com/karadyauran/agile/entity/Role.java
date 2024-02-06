package com.karadyauran.agile.entity;

import com.karadyauran.agile.validation.interf.Uuid;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UuidGenerator;

import java.util.Objects;
import java.util.UUID;

@Data
@Entity
@Table(name = "roles")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role
{
    @Id
    @UuidGenerator
    @Column(name = "id")
    UUID id;

    @Size(min = 2, max = 20)
    @Column(name = "name")
    String name;

    @Uuid
    @Column(name = "project_id")
    UUID projectId;

    @ManyToOne
    @JoinTable(
            name = "user_projects",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    User user;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }

    @Override
    public String toString()
    {
        return String.format(
                "\n[ROLE]\n%s\n%s\n%s\n",
                projectId,
                name,
                user
        );
    }
}
