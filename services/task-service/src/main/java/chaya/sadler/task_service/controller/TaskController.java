package chaya.sadler.task_service.controller;

import chaya.sadler.task_service.model.TaskRequest;
import chaya.sadler.task_service.model.TaskResponse;
import chaya.sadler.task_service.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("tasks")
    public ResponseEntity<String> createTasks(@Valid  @RequestBody TaskRequest taskRequest){
        return taskService.createTasks(taskRequest);
    }

    @GetMapping("tasks")
    public List<TaskResponse> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("tasks/{id}")
    public TaskResponse getTaskbyId(@PathVariable UUID id){
        return taskService.getTaskbyId(id);
    }

    @PutMapping("tasks/{id}")
    public ResponseEntity<String> updateTask(@PathVariable UUID id, @RequestBody TaskRequest taskRequest){
        return taskService.updateTask(id, taskRequest);
    }

    @DeleteMapping("tasks/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable UUID id){
        return taskService.deleteTask(id);
    }
}
