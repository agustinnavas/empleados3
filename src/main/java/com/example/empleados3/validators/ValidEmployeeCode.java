package com.example.empleados3.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EmployeeCodeValidation.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEmployeeCode {

    String message() default "Código inválido.Debe contener exactamente las letras emp y las tres primeras letras de su departamento y 4 numeros..";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value() default "PREFIX-";
}
	
