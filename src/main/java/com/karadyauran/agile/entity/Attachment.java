package com.karadyauran.agile.entity;

import com.karadyauran.agile.entity.enums.FileFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "attachments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Attachment {
  @Id
  @Column(name = "a_attachment_id")
  private UUID attachmentId;

  @Column(name = "a_task_id")
  private UUID taskId;

  @Column(name = "a_file_name")
  private String fileName;

  @Column(name = "a_file_format")
  private FileFormat fileFormat;

  @Column(name = "a_file_path")
  private String filePath;

  @ManyToOne
  @JoinColumn(name = "a_task_id", insertable = false, updatable = false)
  private Task task;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Attachment that = (Attachment) o;
    return Objects.equals(attachmentId, that.attachmentId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attachmentId);
  }

  @Override
  public String toString() {
    return String.format("Attachment: %s, %s",
            taskId, fileName);
  }
}
