package com.openshift.coursecatalogue.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * @author kaleembasha.akbar
 *
 * Model class for Enrollment Document
 */
@Document
public class Enrollment {
	
	@Id
	private String id;
	
	private Users user_id;
	
	private Courses course_id;
	
	private String start_date;
	
	private String end_date;
	
	private String status;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Users getUser_id() {
		return user_id;
	}

	public void setUser_id(Users user_id) {
		this.user_id = user_id;
	}

	public Courses getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Courses course_id) {
		this.course_id = course_id;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
