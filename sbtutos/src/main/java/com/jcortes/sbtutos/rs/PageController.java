package com.jcortes.sbtutos.rs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.foo.NotificationService;

@RestController
public class PageController {

	private NotificationService service;

	@Autowired // setter based injection
	public void setService(NotificationService service) {
		this.service = service;
	}

	@Value("${pageController.msg}")
	private String msg;

	@Value("${my.secret}")
	private String mySecret;

	@Value("${app.description}")
	private String appDescription;

	@Value("${spring.profiles.active}")
	private String profile;

	@RequestMapping("/")
	public String home() {
		return service.showMessage(String.format("%s %s", msg, mySecret));
	}

	@RequestMapping("/desc")
	public String description() {
		return service.showMessage(appDescription);
	}

	@RequestMapping("/env")
	public String getEnv() {
		return "env: " + profile;
	}
}
