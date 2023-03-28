package com.chrisflores.calendariospring.util;


import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.chrisflores.calendariospring.data.DateEvent;
import com.chrisflores.calendariospring.data.DateEventRepository;



@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent>{
	private final DateEventRepository dateEventRepository;	
	
	
	public AppStartupEvent(DateEventRepository dateEventRepository) {
		this.dateEventRepository = dateEventRepository;
		
	}



	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		Iterable<DateEvent> events = this.dateEventRepository.findAll();
		events.forEach(System.out::println);
	}
}
