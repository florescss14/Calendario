package com.chrisflores.calendariospring.webservice;

import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.chrisflores.calendariospring.data.DateEvent;
import com.chrisflores.calendariospring.data.ResponseSignin;
import com.chrisflores.calendariospring.data.User;
import com.chrisflores.calendariospring.service.EventsService;
import com.chrisflores.calendariospring.service.UserService;
import com.fasterxml.jackson.databind.util.JSONPObject;



@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class WebserviceContoller {
	private final EventsService eventsService;
	private final UserService userService;
	
	public WebserviceContoller(EventsService eventsService, UserService userService) {
		this.eventsService = eventsService;
		this.userService = userService;
	}
	
	@RequestMapping(path = "/events", method = RequestMethod.GET)
	public List<DateEvent> getEvents(){
		return this.eventsService.getEvents();
	}
	
	@RequestMapping(path = "/usersignup", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public User addUser(@RequestBody ResponseSignin response) {
		System.out.println(response.toString());	
		return this.userService.addUser(response);
	}
	
	@RequestMapping(path = "/userlogin", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public User login(@RequestBody JSONObject body) { 
		String username = body.get("username").toString();
		String password = body.get("password").toString();
		return userService.signIn(username, password);
//		String token = getJWTToken(username);
//		User user = new User();
//		user.setUser(username);
//		user.setToken(token);		
//		return user;
	}
	
}
