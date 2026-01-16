package com.jhordan.taskforge.service;

import com.jhordan.taskforge.model.Task;
import com.jhordan.taskforge.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> findAll() {
        return repository.findAll();
    }

    public Task findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Task save(Task task) {
        return repository.save(task);
    }

    public Task update(Long id, Task updatedTask) {
        Task task = findById(id);
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setCompleted(updatedTask.isCompleted());
        return repository.save(task);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
