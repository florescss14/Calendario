package com.chrisflores.calendariospring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrisflores.calendariospring.data.DateEvent;
import com.chrisflores.calendariospring.data.DateEventRepository;

@Service
public class EventsService {
	@Autowired
	private final DateEventRepository dateEventRepository;
	
	public EventsService(DateEventRepository dateEventRepository) {
		this.dateEventRepository = dateEventRepository;
	}
	
	public List<DateEvent> getEvents(){
		return (List<DateEvent>) dateEventRepository.findAll();
	}
}
