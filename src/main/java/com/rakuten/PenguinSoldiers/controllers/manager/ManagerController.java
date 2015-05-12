package com.rakuten.PenguinSoldiers.controllers.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ManagerController {
	
	@RequestMapping(value = "manager", method = RequestMethod.GET)
	public String manager() {
		return "manager/managerMain";
	}

}
