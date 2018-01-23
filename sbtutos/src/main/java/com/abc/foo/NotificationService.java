package com.abc.foo;

import org.springframework.stereotype.Service;

@Service("notificationSvc")
public class NotificationService {

	public String showMessage(String msg) {
		return "from NotificationService";
	}

	public void doNothing() {

	}
}
