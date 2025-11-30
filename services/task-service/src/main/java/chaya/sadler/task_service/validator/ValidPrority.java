package chaya.sadler.task_service.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TaskPriorityValidator.class)
public @interface ValidPrority {
    String message() default "Invalid priority value";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default{};
}
