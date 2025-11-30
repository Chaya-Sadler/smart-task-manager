package chaya.sadler.task_service.service;

import chaya.sadler.task_service.dao.TaskRepository;
import chaya.sadler.task_service.model.TaskEntity;
import chaya.sadler.task_service.model.TaskRequest;
import chaya.sadler.task_service.model.TaskResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public ResponseEntity<String> createTasks(TaskRequest taskRequest) {
        TaskEntity taskEntity = new TaskEntity(taskRequest.title(),
                taskRequest.description(),
                taskRequest.status(),
                taskRequest.priority(),
                taskRequest.dueDate(),
                taskRequest.categoryId());
        taskRepository.save(taskEntity);

        return new ResponseEntity<>("Task created successfully!", HttpStatus.CREATED);
    }

    public List<TaskResponse> getAllTasks() {
        List<TaskEntity> taskEntityList =  taskRepository.findAll();
        return taskEntityList.stream()
                .map( t -> new TaskResponse(t.getTitle(),
                        t.getDescription(),
                        t.getStatus(),
                        t.getPriority(),
                        t.getDueDate()))
                .collect(Collectors.toList());

    }

    public ResponseEntity<String> updateTask(UUID id, TaskRequest taskRequest) {
        TaskEntity taskEntity = taskRepository.findById(id).orElseThrow( () ->
                new EntityNotFoundException(" Task not found")) ;

        taskEntity.setTitle(taskRequest.title());
        taskEntity.setDescription(taskRequest.description());
        taskEntity.setPriority(taskRequest.priority());
        taskEntity.setStatus(taskRequest.status());
        taskEntity.setDueDate(taskRequest.dueDate());

        taskRepository.save(taskEntity);

        return new ResponseEntity<>("Task updated successfully!", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteTask(UUID id) {
        TaskEntity taskEntity = taskRepository.findById(id).orElseThrow( () ->
                new EntityNotFoundException(" Task not found")) ;

        taskRepository.delete(taskEntity);
        return new ResponseEntity<>("Task removed successfully!", HttpStatus.OK);
    }

    public TaskResponse getTaskbyId(UUID id) {
        TaskEntity taskEntity = taskRepository.findById(id).orElseThrow(() ->
            new EntityNotFoundException(" Task is not found"));

        return new TaskResponse(taskEntity.getTitle(),
                taskEntity.getDescription(),
                taskEntity.getStatus(),
                taskEntity.getPriority(),
                taskEntity.getDueDate());

    }
}
