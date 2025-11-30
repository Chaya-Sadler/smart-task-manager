package chaya.sadler.task_service.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class TaskStatusValidator implements ConstraintValidator<ValidStatus, String> {

    private static final Set<String> ALLOWED = Set.of(
            "TODO",
            "IN_PROGRESS",
            "DONE",
            "BLOCKED"
    );

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        if(value == null) return false;
        return ALLOWED.contains(value.toUpperCase());
    }
}
