package com.example.empleados3.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.validator.internal.util.logging.Log;
import org.jboss.logging.BasicLogger;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
@Slf4j

public class ValidCode implements  ConstraintValidator<CodeValidation, String> {

	private static final Pattern CODE_PATTERN=Pattern.compile("^emp-[a-zA-Z]+-\\d{0,9}$\r\n"+ "");
	private CharSequence value;
	private BasicLogger log;
	@Override
	public void initialize(CodeValidation constraintAnnotation) {
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value==null) {
			log.info("Codigo null");
		return false;
	}
	
	Matcher matcher = CODE_PATTERN.matcher(value);
	return matcher.matches();
	}
}
