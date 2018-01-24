package com.jcortes.sbtutos.vo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "emailconfig")
public class EmailConfig {

	// @Value("${emailconfig.from}")
	private String from;
	private String to;
	private String subject;
	private String contentType;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@Override
	public String toString() {
		return "EmailConfig [from=" + from + ", to=" + to + ", subject=" + subject + ", contentType=" + contentType
				+ "]";
	}

}
