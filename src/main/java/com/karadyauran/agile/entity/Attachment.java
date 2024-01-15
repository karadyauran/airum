package com.karadyauran.agile.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.karadyauran.agile.entity.enums.FileFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "task_attachments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Attachment
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ta_attachment_id")
    private UUID attachmentId;

    @Column(name = "ta_task_id", insertable = false, updatable = false)
    private UUID taskId;

    @Column(name = "ta_user_id", insertable = false, updatable = false)
    private UUID userId;

    @Column(name = "ta_attachment_name")
    private String attachmentName;

    @Column(name = "ta_attachment_type")
    @Enumerated(EnumType.STRING)
    private FileFormat attachmentType;

    @Column(name = "ta_attachment_path")
    private String attachmentPath;

    @ManyToOne
    @JsonBackReference("attachmentTaskReference")
    @JoinColumn(name = "ta_task_id", referencedColumnName = "t_task_id")
    private Task task;

    @ManyToOne
    @JsonBackReference("attachmentUserReference")
    @JoinColumn(name = "ta_user_id", referencedColumnName = "u_user_id")
    private User user;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attachment that = (Attachment) o;
        return Objects.equals(attachmentId, that.attachmentId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(attachmentId);
    }

    @Override
    public String toString()
    {
        return String.format("Attachment: %s, %s",
                taskId, attachmentName);
    }
}
