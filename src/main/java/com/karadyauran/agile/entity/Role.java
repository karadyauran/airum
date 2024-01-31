package com.karadyauran.agile.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Timestamp;
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

    @Column(name = "name")
    String name;

    @Column(name = "project_id")
    UUID projectId;

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
        return name;
    }
}