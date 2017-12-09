package com.revature.services;

import com.revature.beans.Application;
import com.revature.beans.Employee;

import com.revature.dao.AccountDao;
import com.revature.dao.EmpDao;

import javax.servlet.http.HttpServletRequest;

public class Updating {
	HttpServletRequest request;
	public void update(Application app, Employee emp, int decision) {
		EmpDao dao = new EmpDao();
		while (app.getStanding() <= emp.getStatus()) {
			if(emp.getStatus() >= 5) {
				//return to user that their account has been approved
			}
			//make sure they dont get a chance to ask if the department numbers match up
			if (decision >= 3) {
				// return to user a message saying that their application has been approved
				app.setStanding(app.getStanding() + 1);
				app.setGrade(app.getGrade() + decision);
				dao.selectEmployeeByIDNum(app.getAccNum());
				//return a grade back to the user, add to the grade whatever the decision is
				//alert those at the level of the appStanding
				// read application back into table
			} else if (decision < 3) {
				// return to user that their application did not meet the requirements and/or
				// was unsatisfactory.
			}
		}
		// this function will return the grade that someone gets for a presentation
		// check to see if user status is above application's level
		// if so, display information to the user
		// update their information and pass it back to user, whether good or bad score
//object.setter(request.getParam(param field))
		//random.nexInt(999);
	}


	public boolean gradeCheck(int stated, int recorded) {
		//recorded = someApplication's overall score
		if(stated == recorded) {
			return true;
		}
		else if (stated > recorded) {
			//return to the user that they need to stop fucking around and put in their correct score, in those exact words
			return false;
		}
		else {
			//tell user that they will be fired by next week if they keep on lying like that
			return false;
		}
	}

//create a function for checking the grade versus the input they put in the form
//updates level to +1


	public void approvePerson() {
		//check for examples of approving a person, hint hint
	}
}