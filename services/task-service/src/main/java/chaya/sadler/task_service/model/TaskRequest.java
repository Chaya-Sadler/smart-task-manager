package chaya.sadler.task_service.model;

import chaya.sadler.task_service.validator.ValidPrority;
import chaya.sadler.task_service.validator.ValidStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record TaskRequest(@NotBlank(message = "Title is required")
                          String title,
                          String description,

                          @NotBlank(message = "Status must be one of TODO, IN_PROGRESS, DONE, BLOCKED")
                          @ValidStatus
                          String status,

                          @NotBlank(message = "Priority must be one of HIGH, LOW, MEDIUM, CRITICAL")
                          @ValidPrority
                          String priority,

                          @FutureOrPresent
                          @JsonFormat(pattern = "yyyy-MM-dd")
                          LocalDate dueDate,

                          @NotNull()
                          UUID categoryId) {
}
