package com.karadyauran.agile.entity;

import com.karadyauran.agile.entity.enums.FileFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Attachment {
  @Id
  private UUID attachmentId;
  private UUID taskId;
  private String fileName;
  private FileFormat fileFormat;
  private String filePath;

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
