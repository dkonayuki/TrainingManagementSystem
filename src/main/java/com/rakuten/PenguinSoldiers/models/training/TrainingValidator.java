package com.rakuten.PenguinSoldiers.models.training;

import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.Constraint;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.rakuten.PenguinSoldiers.models.account.UserService;
import com.rakuten.PenguinSoldiers.models.outline.Outline;
import com.rakuten.PenguinSoldiers.models.training.TrainingForm;

public class TrainingValidator {

	@Autowired
	private TrainingForm trainingForm;

	public void validate(TrainingForm trainingForm, Errors errors) {

		String st = trainingForm.getName();
		System.out.println(st);
		if (st != null && !st.isEmpty()) {
			System.out.println("name is not null");
		} else {
			//System.out.println("name is null");
			errors.rejectValue("name", "name.notNull");
		}

		/* -- make sure Due date is later than Beginning date -- */
		// convert string date to DateTime

		DateFormat format = new SimpleDateFormat("dd/MM/yyyy, HH:mm");
		String b_date = trainingForm.getDate();
		String d_date = trainingForm.getDueDate();

		int b_date_flag = 0;
		int d_date_flag = 0;
		if (b_date != null && !b_date.isEmpty() && b_date.length()!=0) {
			System.out.println("beginning date input");
			b_date_flag=1;
		} else {
			errors.rejectValue("date", "BeginningDate.notNull");
		}
		if (d_date != null && !d_date.isEmpty() && d_date.length()!=0) {
			System.out.println("due date input");
			d_date_flag=1;
		} else {
			errors.rejectValue("dueDate", "DueDate.notNull");
		}

		Date begin_date = null, due_date = null;

		//if beginning & due date are both inputed, check whether due date is later then beginning date 
		if ((b_date_flag==1)&&(d_date_flag==1))
		{
			try {
				begin_date = format.parse(b_date);
				due_date = format.parse(d_date);
			} catch (ParseException e) {
				System.out.println("Parse error " + e.getMessage());
			}
			if (due_date.compareTo(begin_date) > 0) {
				System.out.println("Due date & beginning date are correct");
				} else {
					errors.rejectValue("dueDate", "Duedate.wrong");
					}
			
			Date today = new Date();
			if(begin_date.compareTo(today)>0)
			{
				System.out.println("Beginning date is in the future");
			}
			else
			{
				errors.rejectValue("date", "BeginningDate.Past");
			}
			if(due_date.compareTo(today)>0)
			{
				System.out.println("Due date is in the future");
			}
			else
			{
				errors.rejectValue("dueDate", "DueDate.Past");
			}
		}
		
		// Outline validation
		// make sure Training Date is not null, etc.
		validateOutline(trainingForm.getOutlines(), errors);

	}

	public void validateOutline(List<String> outlines, Errors errors) {
		String outlineDate, outlineText;
		Date outline_date = null;
		Date today = new Date();
		for (String outlineStr : outlines) {
			String outlinesJsonString = URLDecoder.decode(URLDecoder
					.decode(outlineStr));
			try {
				JSONObject outlineJson = new JSONObject(outlinesJsonString);
				outlineDate = outlineJson.getString("outline-date");
				outlineText = outlineJson.getString("outline-text");
				//training date is not null
				if (outlineDate != null && !outlineDate.isEmpty()) {
					System.out.println("outline date input");
					
					//training date is not in the past
					DateFormat format = new SimpleDateFormat("dd/MM/yyyy, HH:mm");
					try {
						outline_date = format.parse(outlineDate);
					} catch (ParseException e) {
						//errors.rejectValue("outlines", "outlineDate.invalid");
						System.out.println("Parse error " + e.getMessage());
					}
					if (outline_date.compareTo(today) > 0) {
						System.out.println("Outline date are correct");
						} else {
							errors.rejectValue("outlines", "outlineDate.Past");
							}	
				}
				else{
					errors.rejectValue("outlines", "outlineDate.notNull");
				}
			} catch (Exception ex) {
				System.out.println("Parse Outline error");
			}
		}
	}

}