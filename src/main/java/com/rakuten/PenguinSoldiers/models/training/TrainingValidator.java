package com.rakuten.PenguinSoldiers.models.training;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.validation.Constraint;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.rakuten.PenguinSoldiers.models.account.UserService;
import com.rakuten.PenguinSoldiers.models.training.TrainingForm;

public class TrainingValidator{
	
	@Autowired
	private TrainingForm trainingForm;

	public void validate(TrainingForm trainingForm, Errors errors) {
		
		String st = trainingForm.getName();
		System.out.println(st);
		if(st != null && !st.isEmpty())
		{
			System.out.println("name is not null");
		}
		else
		{
			System.out.println("name is null");
			errors.rejectValue("name","name.notNull","cannot be empty");
		}
		// make sure Training Date is not null, etc.
		
		/*  --  make sure Due date is later than Begining date --  */
		// convert string date to DateTime
		
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy, HH:mm");
		String b_date = trainingForm.getDate();
		String d_date = trainingForm.getDueDate();
		if(b_date != null && !b_date.isEmpty())
		{
			System.out.println("beginning date input");
		}
		else
		{
			errors.rejectValue("date","date.notNull","cannot be empty");
		}
		if(d_date != null && !d_date.isEmpty())
		{
			System.out.println("due date input");
		}
		else
		{
			errors.rejectValue("dueDate","date.notNull","cannot be empty");
		}
		
		Date begin_date=null, due_date=null;
		
		try {
			begin_date = format.parse(b_date);
			due_date = format.parse(d_date);
		} catch (ParseException e) {
			System.out.println("Parse error " + e.getMessage());
		}
		if (due_date.compareTo(begin_date)>0)
		{
			System.out.println("Due date & beginning date are correct");
		}
		else
		{
			errors.rejectValue("dueDate","date.wrong","cannot be empty");
		}
		
		// Outline
		System.out.println(trainingForm.getOutlines().size());
		if(trainingForm.getOutlines().size()==0)
		{
			System.out.println("empty outlines");
		}
		else
		{
			System.out.println("got outlines");
		}
	    for(String item:trainingForm.getOutlines()){
	        System.out.println(item);
	    }
		
	}
	
	

}