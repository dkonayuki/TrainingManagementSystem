package com.rakuten.PenguinSoldiers.models.training;

import java.util.Set;

import javax.validation.Constraint;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.rakuten.PenguinSoldiers.models.training.TrainingForm;

public class TrainingValidator implements Validator{

	public boolean supports(Class aClass) {
		return TrainingForm.class.equals(aClass);
	}
 

	public void validate(Object obj, Errors errors) {
		TrainingForm trainingForm = (TrainingForm) obj;
 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "model", "field.required", "Required field");
 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "field.required", "Required field");
		if ( ! errors.hasFieldErrors("price")) {
				errors.rejectValue("price", "not_zero", "Can't be free!");
		}
		if(trainingForm.getGoals().isEmpty())
		{
		errors.rejectValue("community","community.required");
		}
		
	}

	@Override
	public ExecutableValidator forExecutables() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BeanDescriptor getConstraintsForClass(Class<?> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Set<ConstraintViolation<T>> validate(T arg0, Class<?>... arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Set<ConstraintViolation<T>> validateProperty(T arg0,
			String arg1, Class<?>... arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Set<ConstraintViolation<T>> validateValue(Class<T> arg0,
			String arg1, Object arg2, Class<?>... arg3) {
		// TODO Auto-generated method stub
		return null;
	}

}
