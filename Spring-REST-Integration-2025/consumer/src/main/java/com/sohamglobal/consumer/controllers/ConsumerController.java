package com.sohamglobal.consumer.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.sohamglobal.consumer.entities.Film;



@Controller
public class ConsumerController {
	
	@Autowired
    private RestTemplate restTemplate;
	
	@GetMapping("/")
	public String home(Model model)
	{
		String url = "http://localhost:8080/films";
		//List<Film> list=new ArrayList<Film>(); 
        
		ResponseEntity<List<Film>> response = restTemplate.exchange(
	            url,
	            HttpMethod.GET,
	            null,
	            new ParameterizedTypeReference<List<Film>>() {}
	        );
	        List<Film> list=response.getBody();
		list.stream().forEach(obj->System.out.println(obj.getFilmname()));
	        
		model.addAttribute("films",response.getBody());
		return "index.jsp";
	}

}
