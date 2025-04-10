package com.sohamglobal.provider.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sohamglobal.provider.entities.Film;

@RestController
public class ProviderController {
	
	@GetMapping("/films")
	public List<Film> getFilms()
	{
		Film f1=new Film("pk","comedy","hindi");
		Film f2=new Film("the matrix","action","english");
		List<Film> list=new ArrayList<Film>();
		list.add(f1);
		list.add(f2);
		return list;
	}

}
