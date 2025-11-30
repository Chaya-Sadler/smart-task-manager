package chaya.sadler.task_service.model;

import java.time.LocalDate;

public record TaskResponse(String title,
                           String description,
                           String status,
                           String priority,
                           LocalDate dueDate) {
}
