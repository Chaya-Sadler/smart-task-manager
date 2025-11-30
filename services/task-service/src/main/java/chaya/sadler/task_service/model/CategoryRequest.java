package chaya.sadler.task_service.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryRequest(@NotBlank(message = "Category name is required")
                            @Size(max = 50, message = "Category name must be max 50 characters")
                              String name,
                              String description) {
}
