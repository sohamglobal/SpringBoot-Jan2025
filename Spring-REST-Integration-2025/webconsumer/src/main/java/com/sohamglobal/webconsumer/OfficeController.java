package com.sohamglobal.webconsumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.sohamglobal.webconsumer.models.Employee;

@Controller
public class OfficeController {
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/")
	public String home(Model model)
	{
		String url="http://localhost:8080/allemp";
		ResponseEntity<List<Employee>> response=restTemplate.exchange(
				url,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Employee>>() {}
				);
		List<Employee> list=response.getBody();
		model.addAttribute("list", list);
		
		return "index.jsp";
	}
}
