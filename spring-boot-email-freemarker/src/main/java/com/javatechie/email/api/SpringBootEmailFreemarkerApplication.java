package com.javatechie.email.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.email.api.dto.MailRequest;
import com.javatechie.email.api.dto.MailResponse;
import com.javatechie.email.api.service.EmailService;


@SpringBootApplication
@RestController
public class SpringBootEmailFreemarkerApplication {

	@Autowired
	private EmailService service;

	@PostMapping("/sendEmail")
	public MailResponse sendEmail(@RequestBody MailRequest request) {
		Map<String, Object> model = new HashMap<>();
		model.put("Name", request.getName());
		model.put("Location", "Dwarka Residency Awan, Madhya Pradesh, India");
		model.put("IssueDate", "24 Nov, 2022");
		model.put("Mobile", "8518068366");
		model.put("Email", "deepaklodha067@gmail.com");
		model.put("Position", "Software Developer");
		model.put("JoinDate", "01 Dec, 2022");
		model.put("CTC", "500000");
		model.put("Variable", "15%");
		return service.sendEmail(request, model);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmailFreemarkerApplication.class, args);
		System.out.println("Server has been Started on port 2000!!");
	}
}
