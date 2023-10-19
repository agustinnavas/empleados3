package com.example.empleados3.validators;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.example.empleados3.validators.ValidCode;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = ValidCode.class)
public @interface CodeValidation {

	String message() default "Código inválido." 
			+ " Debe contener exactamente las letras emp y las tres primeras letras de su departamento y 4 numeros.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
