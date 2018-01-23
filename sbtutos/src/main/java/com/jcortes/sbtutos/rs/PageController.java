package com.jcortes.sbtutos.rs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.foo.NotificationService;

@RestController
public class PageController {

	// @Autowired -> property based injection (not testeable at all)
	private NotificationService service;

	@Autowired // setter based injection
	public void setService(NotificationService service) {
		this.service = service;
	}

//	@Autowired -> contructor based injection
	public PageController(NotificationService service) {
		super();
		this.service = service;
	}

	@RequestMapping("/")
	public String home() {
		return service.showMessage("Home");
	}
}
