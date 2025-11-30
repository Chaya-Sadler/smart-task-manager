package chaya.sadler.task_service.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class TaskPriorityValidator implements ConstraintValidator<ValidPrority, String> {

    private static final Set<String> ALLOWED = Set.of(
            "LOW",
            "MEDIUM",
            "HIGH",
            "CRITICAL"
    );
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value == null) return false;
        return ALLOWED.contains(value.toUpperCase());
    }
}
