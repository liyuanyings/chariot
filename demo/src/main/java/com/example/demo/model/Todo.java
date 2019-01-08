package com.example.demo.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class Todo implements Serializable {

  private Integer id;

  private String title;

  private Boolean finished;

  private LocalDateTime createdAt;

  private LocalDate deadline;

  private LocalDateTime finishedAt;

}
