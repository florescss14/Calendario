package com.chrisflores.calendariospring.data;

import java.sql.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="date_event")
public class DateEvent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "event_id")
	private long eventId;
	@Column(name = "event_name")
	private String eventName;
	@Column(name = "event_date")
	private Date eventDate;
	@Column(name = "description")
	private String description;
	
	public long getEventId() {
		return eventId;
	}
	public void setEventId(long eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "DateEvent [eventId=" + eventId + ", eventName=" + eventName + ", eventDate=" + eventDate
				+ ", description=" + description + "]";
	}
	
	
	
}
