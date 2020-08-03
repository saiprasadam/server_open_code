package com.openshift.coursecatalogue.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * @author kaleembasha.akbar
 *
 * Model class for Course Document
 */
@Document
public class Courses {
	@Id
	private String id;
	
	private String name;
	
	private String description;
	private List<Filter> filters;
	@DBRef(db="users")
	private String owner;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public List<Filter> getFilters() {
		return filters;
	}

	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}

	public Courses(String id, String name, String description, List<Filter> filters, String owner) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.filters = filters;
		this.owner = owner;
	}

	public Courses() {
		super(); // TODO Auto-generated constructor stub }
	}
	
}
