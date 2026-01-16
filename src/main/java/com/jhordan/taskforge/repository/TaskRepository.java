package com.jhordan.taskforge.repository;

import com.jhordan.taskforge.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
