package com.openshift.coursecatalogue.repositories;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.openshift.coursecatalogue.model.Courses;

/**
 * @author kaleembasha.akbar
 *
 * Course Repository File. Custom repository methods can be added
 */
@Repository
public class CourseRepo{
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Courses> findAll(){
		return mongoTemplate.findAll(Courses.class);
	}

	public Courses findOne(String courseId) {
		// TODO Auto-generated method stub
		LOG.info("courseId"+courseId);
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(courseId));
		return mongoTemplate.findOne(query,Courses.class);
	}
	
	
	

}
