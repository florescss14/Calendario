package com.chrisflores.calendariospring.webservice;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chrisflores.calendariospring.data.DateEvent;
import com.chrisflores.calendariospring.service.EventsService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class WebserviceContoller {
	private final EventsService eventsService;
	
	public WebserviceContoller(EventsService eventsService) {
		this.eventsService = eventsService;
	}
	
	@RequestMapping(path = "/events", method = RequestMethod.GET)
	public List<DateEvent> getEvents(){
		return eventsService.getEvents();
	}
	
	
}
